package no_02_annotation;

/*
 어노테이션은 JSP하기전까지만 해도 볼 일이 없었는데 JSP하면서 부터 갑자기 나오는 친구이다.
 어노테이션은 프로그래머가 직접 만들어 줄 수도 있다. 이를 커스텀 어노테이션이라 한다 카더라.
*/
public class Main {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.bark();
		dog.move(1, 2);
		
		/*
		어노테이션을 적용한건 맞는데, 클래스 자체에 정보를 추가해 줄 뿐 기존소스에 영향을 주거나 하지는 않는다.
		한마디로 그냥 주석이나 다름없다.
		
		그런데 어노테이션은 reflection으로 읽어줄 수 있고, 이를이용하면 @RequestMapping
		과 같은 것을 만들어 줄 수 있다. 다음장에서 배운다.
		*/
	}
}
