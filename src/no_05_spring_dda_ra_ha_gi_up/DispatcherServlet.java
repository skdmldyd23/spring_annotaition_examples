package no_05_spring_dda_ra_ha_gi_up;

import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;

public class DispatcherServlet {
	private ArrayList<Object> beans;
	private ArrayList<MapperMethod> mapperMethods;
	
	public DispatcherServlet() {
		beans = new ArrayList<Object>();
		mapperMethods = new ArrayList<MapperMethod>();
		
		System.out.println("DispatcherServlet::�ʱ�ȭ ����");
		String classPath = System.getProperty("java.class.path");
		// �̰͵� ������ζ�� ������ classpath���� �� ������ �ʿ���°����� ����� ���������� ��Ű���� ������
		String packageName = this.getClass().getPackage().getName();
		
		System.out.println("DispatcherServlet::classpath ����");
		System.out.println("DispatcherServlet::�������� ���� Ŭ���� ���...");
		// ������ ���� ���ϸ��� ��� fileNames�� ����ִ� �ڵ�
		File classpathDir = new File(classPath+"\\"+packageName);
		File[] files = classpathDir.listFiles();
		ArrayList<String> fileNames = new ArrayList<String>();
		for (File item:files) {
			String name = (item.getName().split("\\."))[0];
			fileNames.add(name);
			System.out.println("DispatcherServlet::"+name);
		}
		
		System.out.println("DispatcherServlet::@Controller�� ���� ģ���� ã����...");
		for (String item:fileNames) {
			Class cls = null;
			try {
				cls = Class.forName(packageName+"."+item);
				Controller c = (Controller) cls.getDeclaredAnnotation(Controller.class);
				if (c!=null)
					beans.add(cls.getDeclaredConstructor().newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("DispatcherServlet::@Controller�� ���� ģ���� ����� ������ �����ϴ�");
		for (Object item:beans) {
			System.out.println("DispatcherServlet::"+item.getClass().getName());
		}
		
		System.out.println("DispatcherServlet::@RequestMapping�� ���� �Լ��� ã�� ���� �����մϴ�.");
		for (Object item:beans) {
			Method[] methods = item.getClass().getDeclaredMethods();
			for (int i=0; i<methods.length; i++) {
				RequestMapping rm = methods[i].getAnnotation(RequestMapping.class);
				if (rm != null) {
					MapperMethod mm = new MapperMethod(item.getClass(), methods[i], rm.value());
					System.out.println("DispatcherServlet::"+rm.value()+"��(��) ���ε�");
					mapperMethods.add(mm);
				}
			}
		}
		
		System.out.println("DispatcherServlet::�ʱ�ȭ �Ϸ�");
	}
	
	public void request(String request) {
		for(MapperMethod mm : mapperMethods) {
			if (request.equals(mm.getUrl())) {
				mm.execute();
				return;
			}
		}
		System.out.println("404���Ŀ��");
	}
}

