package no_05_spring_dda_ra_ha_gi_up;

import java.util.Scanner;

public class Tomcat {
	DispatcherServlet servlets; //������ζ�� ServletŸ������ ���� ������ ������ ���������� �׳� DispatcherServlet�� ����
	
	public void init() {
		System.out.println("Tomcat::��Ĺ �ʱ�ȭ ����");
		System.out.println("Tomcat::��Ʈ�� Ȯ���ϰ� ��Ʈ��ũ ��û�� ������ �ְ� ����");
		System.out.println("Tomcat::ContextLoaderListner ����");
		System.out.println("Tomcat::������ ���� ����");
		/*
		 *  ������� servlet mapping�� web.xml���Ͽ� �ִ� ������ ������ �̸� �о�� �Ľ��ϰ� �ϰ�����
		 *  ���� �߿��Ѱ� �׵��� �ƴϴ� �׳� new �ؼ� �������
		 */
		servlets = new DispatcherServlet();
		
		System.out.println("Tomcat::��Ÿ��� �۾���");
		System.out.println("Tomcat::0.00ms���� ���۵�");
		while(true) {
			Scanner sc = new Scanner(System.in);
			String request = sc.nextLine();
			if (request.equals("-1")) {
				System.out.println("Tomcat::������");
				break;
			}
			servlets.request(request);
		}
	}
}
