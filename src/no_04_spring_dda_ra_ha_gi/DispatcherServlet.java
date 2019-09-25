package no_04_spring_dda_ra_ha_gi;

import java.io.File;
import java.lang.reflect.*;
import java.util.ArrayList;

public class DispatcherServlet {
	private ArrayList<Object> controllers;
	
	public DispatcherServlet() {
		controllers = new ArrayList<Object>();
		
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
					controllers.add(cls.getDeclaredConstructor().newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("DispatcherServlet::@Controller가 붙은 친구를 목록은 다음과 같습니다");
		for (Object item:controllers) {
			System.out.println("DispatcherServlet::"+item.getClass().getName());
		}
		
		System.out.println("DispatcherServlet::초기화 완료");
		
	}
}

