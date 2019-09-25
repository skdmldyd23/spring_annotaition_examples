package no_04_spring_dda_ra_ha_gi;

/*
���������� Springó�� �����ϴ� ������ ����� �� ���ε�, Spring�������� ����� ���� Spring�� �������� �˾ƺ���.

Spring�� runtime�� Tomcat�̴�.
�� ���� �������� ����� ģ�������� ������ �����ϸ� runtime�� Tomcat������ ���ư��� ģ���� ���̶�� ���̴�.

Tomcat�� ����ڿ��� web.xml�̶�� ���������� �̿��Ͽ� �ڱ��ڽ��� �ٷ�� �ֵ��� ������� ���α׷��̸�,
���������� �� ���ǿ��� �����ο���� �ƴϴ�.

�׷��ٸ� Spring�̰� Maven�̰� ���� ���� web.xml���� ������ �ϰ� �Ǵµ�, �� �����ϴ� �κп� �ִ� �ڵ尡 ������ ����.
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
	<load-on-startup>1</load-on-startup> <!-- �ȿ� �� ���� 1�� �켱�����̴�. 0���� ū �� ������ �ǰ�, 1�� �ֿ켱�̴�. -->
</servlet>
	<servlet-mapping>
	<servlet-name>dispatcher</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>

ContextLoaderListener�� DispatcherServlet�� �ִµ�,
�׳� �Խ������� ����°Ϳ� ���Ǵ� �������� �� 2���� Ŭ���� ���̴�.

�׷��Ƿ� ������ ó�� �����ϴ� ģ���� ������� ContextLoaderListener�� DispatcherServlet�� ����� �ȴٴ� �ǹ��ε�,
���� DispatcherServlet�� ����� �� ���̴�.
*/
public class Main {
	public static void main(String[] args) {
		Tomcat tomcat = new Tomcat();
		tomcat.init();
	}
}
