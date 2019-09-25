package no_04_spring_dda_ra_ha_gi;

import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;

public class DispatcherServlet {
	private ArrayList<Object> controllers;
	
	public DispatcherServlet() {
		controllers = new ArrayList<Object>();
		
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
					controllers.add(cls.getDeclaredConstructor().newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("DispatcherServlet::@Controller�� ���� ģ���� ����� ������ �����ϴ�");
		for (Object item:controllers) {
			System.out.println("DispatcherServlet::"+item.getClass().getName());
		}
		
		System.out.println("DispatcherServlet::�ʱ�ȭ �Ϸ�");
		
	}
}

