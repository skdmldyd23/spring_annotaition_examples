package no_05_spring_dda_ra_ha_gi_up;

import java.util.Scanner;

public class Tomcat {
	DispatcherServlet servlets; //원래대로라면 Servlet타입으로 갖고 있을거 같은데 복잡해지니 그냥 DispatcherServlet로 만듦
	
	public void init() {
		System.out.println("Tomcat::톰캣 초기화 시작");
		System.out.println("Tomcat::포트도 확인하고 네트워크 요청도 받을수 있게 설정");
		System.out.println("Tomcat::ContextLoaderListner 생성");
		System.out.println("Tomcat::매핑할 서블릿 만듦");
		/*
		 *  원래라면 servlet mapping은 web.xml파일에 있는 정보고 톰켓이 이를 읽어와 파싱하고 하겠지만
		 *  지금 중요한건 그딴게 아니니 그냥 new 해서 만들겠음
		 */
		servlets = new DispatcherServlet();
		
		System.out.println("Tomcat::기타등등 작업함");
		System.out.println("Tomcat::0.00ms만에 시작됨");
		while(true) {
			Scanner sc = new Scanner(System.in);
			String request = sc.nextLine();
			if (request.equals("-1")) {
				System.out.println("Tomcat::종료함");
				break;
			}
			servlets.request(request);
		}
	}
}
