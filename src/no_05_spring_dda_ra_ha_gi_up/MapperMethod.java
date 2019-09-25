package no_05_spring_dda_ra_ha_gi_up;

import java.lang.reflect.*;

public class MapperMethod {
	private Class clazz;
	private Method method;
	private String url;
	
	public MapperMethod(Class clazz, Method method, String url) {
		try {
			this.clazz = Class.forName(clazz.getName()+"");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.method = method;
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void execute() {
		/*
		 * 여기서 타입 검사해가면 ModelAndView면 그에따라 동작하게 하는 등 각종 작업을 추가할 수 있지만
		 * 귀찮으니 무조건 String으로 반환하는 코드에 대해서만 처리함
		 */
		String jspFileName = null;
		try {
			jspFileName = (String) method.invoke(clazz.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jspFileName+".jsp를 파일 시스템에서 찾아 뿌려줌");
	}
}
