package no_01_reflection;

import java.lang.reflect.*;

/*
	시작하기전에 reflection이란 classloader가 볼 수 있는 정보를 프로그래머도 볼 수 있게하는 제도이다.
	그리고 자바 기본라이브러리이다.
	이를 이용하면 클래스의 모든 정보를 볼 수도 있고, 클래스를 인스턴스화, 메소드의 실행등을 할 수 있다.
*/

public class Main {
	public static void main(String[] args) {
		// 개클래스는 개같이 잘 동작합니다.
		Dog dog = new Dog();
		dog.bark();
		dog.move(1, 2);
		
		// 이를 reflection을 이용하여 해부해 볼 수있습니다.
		Class cls = null;
		try {
			cls = Class.forName("no_01_reflection.Dog");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] fields = cls.getDeclaredFields();
		Constructor[] constructors = cls.getDeclaredConstructors();
		Method[] methods = cls.getDeclaredMethods();

		System.out.println("필드");
		for (Field item:fields) 
			System.out.println(item);
	
		System.out.println("생성자");
		for (Constructor item:constructors) 
			System.out.println(item);
		
		System.out.println("메소드");
		for (Method item:methods) 
			System.out.println(item);
		
		// 그리고 객체생성 및 함수의 사용까지 할 수 있습니다.
		Dog dog2 = null;
		try {
			// dog2 = new Dog();
			dog2 = (Dog) cls.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dog2.bark();
		dog2.move(3, 4);
		
		try {
			//dog2.bark();
			methods[0].invoke(dog2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		간단해 보이는 기능이지만 2가지 의의를 갖는다.
		
		첫째로 해당 클래스에 대한 모든 정보를 다 읽어볼 수 있다
		
		두번째는 문자열을통해 동적으로 동작 함으로 new Dog(); 와 같이 정적으로 Dog를 적어주는것 보다 훨씬 유연하며,
		생성된 친구들의 함수를 문자열/인덱스을 통해 유연하게 사용해 줄수도 있다.
		
		꽤나 유용하지만 일반적은 프로그래밍을 할 때는 딱히 쓸일 없다 카더라. 그런데 스프링같은 프레임워크를 만들때는
		이러한 기능을 필수적으로 사용해야 하니 어쩔수 없이 배워봄
		*/
	}
}
