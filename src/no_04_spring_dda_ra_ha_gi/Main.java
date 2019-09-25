package no_04_spring_dda_ra_ha_gi;

/*
마지막으로 Spring처럼 동작하는 예제를 만들어 볼 것인데, Spring같은것을 만들기 전에 Spring이 뭔지부터 알아보자.

Spring의 runtime은 Tomcat이다.
이 말은 스프링은 대단한 친구이지만 간단히 생각하면 runtime인 Tomcat위에서 돌아가는 친구일 뿐이라는 것이다.

Tomcat은 사용자에게 web.xml이라는 설정파일을 이용하여 자기자신을 다룰수 있도록 만들어진 프로그램이며,
스프링역시 그 조건에서 자유로운것은 아니다.

그렇다면 Spring이고 Maven이고 뭐고를 떠나 web.xml에서 시작을 하게 되는데, 이 시작하는 부분에 있는 코드가 다음과 같다.
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>/WEB-INF/config/spring/context-*.xml</param-value>
</context-param>
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

<servlet>
	<servlet-name>dispatcher</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/config/dispatcher-servlet.xml</param-value>
	</init-param>
	<load-on-startup>1</load-on-startup> <!-- 안에 든 숫자 1은 우선순위이다. 0보다 큰 수 넣으면 되고, 1이 최우선이다. -->
</servlet>
	<servlet-mapping>
	<servlet-name>dispatcher</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>

ContextLoaderListener와 DispatcherServlet가 있는데,
그냥 게시판정도 만드는것에 사용되는 스프링은 저 2개의 클래스 뿐이다.

그러므로 스프링 처럼 동작하는 친구를 만들려면 ContextLoaderListener와 DispatcherServlet를 만들면 된다는 의미인데,
그중 DispatcherServlet을 만들어 볼 것이다.
*/
public class Main {
	public static void main(String[] args) {
		Tomcat tomcat = new Tomcat();
		tomcat.init();
	}
}
