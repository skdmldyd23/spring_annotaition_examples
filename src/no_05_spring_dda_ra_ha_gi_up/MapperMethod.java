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
		 * ���⼭ Ÿ�� �˻��ذ��� ModelAndView�� �׿����� �����ϰ� �ϴ� �� ���� �۾��� �߰��� �� ������
		 * �������� ������ String���� ��ȯ�ϴ� �ڵ忡 ���ؼ��� ó����
		 */
		String jspFileName = null;
		try {
			jspFileName = (String) method.invoke(clazz.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jspFileName+".jsp�� ���� �ý��ۿ��� ã�� �ѷ���");
	}
}
