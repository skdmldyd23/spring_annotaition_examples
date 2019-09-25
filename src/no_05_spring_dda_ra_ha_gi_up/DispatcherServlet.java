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
		
		System.out.println("DispatcherServlet::초기화 시작");
		String classPath = System.getProperty("java.class.path");
		// 이것도 원래대로라면 어차피 classpath에서 다 뒤지니 필요없는거지만 만들기 복잡해지니 패키지도 가져옴
		String packageName = this.getClass().getPackage().getName();
		
		System.out.println("DispatcherServlet::classpath 뒤짐");
		System.out.println("DispatcherServlet::뒤졌더니 나온 클래스 목록...");
		// 폴더를 뒤져 파일명을 얻어 fileNames에 집어넣는 코드
		File classpathDir = new File(classPath+"\\"+packageName);
		File[] files = classpathDir.listFiles();
		ArrayList<String> fileNames = new ArrayList<String>();
		for (File item:files) {
			String name = (item.getName().split("\\."))[0];
			fileNames.add(name);
			System.out.println("DispatcherServlet::"+name);
		}
		
		System.out.println("DispatcherServlet::@Controller가 붙은 친구를 찾는중...");
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
		System.out.println("DispatcherServlet::@Controller가 붙은 친구를 목록은 다음과 같습니다");
		for (Object item:beans) {
			System.out.println("DispatcherServlet::"+item.getClass().getName());
		}
		
		System.out.println("DispatcherServlet::@RequestMapping이 붙은 함수를 찾아 따로 보관합니다.");
		for (Object item:beans) {
			Method[] methods = item.getClass().getDeclaredMethods();
			for (int i=0; i<methods.length; i++) {
				RequestMapping rm = methods[i].getAnnotation(RequestMapping.class);
				if (rm != null) {
					MapperMethod mm = new MapperMethod(item.getClass(), methods[i], rm.value());
					System.out.println("DispatcherServlet::"+rm.value()+"이(가) 매핑됨");
					mapperMethods.add(mm);
				}
			}
		}
		
		System.out.println("DispatcherServlet::초기화 완료");
	}
	
	public void request(String request) {
		for(MapperMethod mm : mapperMethods) {
			if (request.equals(mm.getUrl())) {
				mm.execute();
				return;
			}
		}
		System.out.println("404낫파운드");
	}
}

