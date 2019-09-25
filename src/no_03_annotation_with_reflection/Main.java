package no_03_annotation_with_reflection;

import java.lang.reflect.Field;

/*
리플렉션을 이용하면 클래스의 모든 정보를 가져올 수 있고, 이 모든정보에는 어노테이션 역시 포함된다.
즉, 객체를 만들고 해당객체에 대해 reflection으로 검사해 보면 어노테이션 정보를 찾아 올 수 있고,
이를 이용하면 스프링의 @Controller가 붙었는지와 같은 여부를 따질 수 있다.
*/
public class Main {
	public static void main(String[] args) {
		// 개
		Dog dog = new Dog();

		/* 
		리플렉션을 이용하여 필드를 모두 검사하며, 만약 FieldAnnotation이 붙어있으며, String타입인 친구가 있으면
		어노테이션에 설정된 값을 변수에 넣어주는 코드이다.
		*/
		try {
			Field[] fields = dog.getClass().getDeclaredFields();
			for (Field field : fields) {
				FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
				if (annotation != null && field.getType() == String.class) {
					field.setAccessible(true);
					field.set(dog, annotation.value());
				}
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		dog.bark();
		dog.move(1, 2);

		/*
		지금까지 한 행동을 요약하면 다음과 같다.
		1. 어노테이션을 직접 만들었다.
		2. reflection으로 어노테이션이 붙었는지 여부를 확인하였다.
		
		이 단순한 기능을 이용하면 Spring에서 보았던 이해안되는 행동을 모두 구현 해 줄수 있다.
		예시로 @Controller라는 어노테이션을 붙이면, set()이나 add()로 넘겨주지 않아도 스프링이 컨트롤러임을 인식하고
		@RequestMapping("url")이라는 어노테이션을 붙이면 알아서 주소와 매핑하는 작업을 모두 만들 수 있다.
		*/
	}
}
