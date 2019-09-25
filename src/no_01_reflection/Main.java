package no_01_reflection;

import java.lang.reflect.*;

/*
	�����ϱ����� reflection�̶� classloader�� �� �� �ִ� ������ ���α׷��ӵ� �� �� �ְ��ϴ� �����̴�.
	�׸��� �ڹ� �⺻���̺귯���̴�.
	�̸� �̿��ϸ� Ŭ������ ��� ������ �� ���� �ְ�, Ŭ������ �ν��Ͻ�ȭ, �޼ҵ��� ������� �� �� �ִ�.
*/

public class Main {
	public static void main(String[] args) {
		// ��Ŭ������ ������ �� �����մϴ�.
		Dog dog = new Dog();
		dog.bark();
		dog.move(1, 2);
		
		// �̸� reflection�� �̿��Ͽ� �غ��� �� ���ֽ��ϴ�.
		Class cls = null;
		try {
			cls = Class.forName("no_01_reflection.Dog");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Field[] fields = cls.getDeclaredFields();
		Constructor[] constructors = cls.getDeclaredConstructors();
		Method[] methods = cls.getDeclaredMethods();

		System.out.println("�ʵ�");
		for (Field item:fields) 
			System.out.println(item);
	
		System.out.println("������");
		for (Constructor item:constructors) 
			System.out.println(item);
		
		System.out.println("�޼ҵ�");
		for (Method item:methods) 
			System.out.println(item);
		
		// �׸��� ��ü���� �� �Լ��� ������ �� �� �ֽ��ϴ�.
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
		������ ���̴� ��������� 2���� ���Ǹ� ���´�.
		
		ù°�� �ش� Ŭ������ ���� ��� ������ �� �о �� �ִ�
		
		�ι�°�� ���ڿ������� �������� ���� ������ new Dog(); �� ���� �������� Dog�� �����ִ°� ���� �ξ� �����ϸ�,
		������ ģ������ �Լ��� ���ڿ�/�ε����� ���� �����ϰ� ����� �ټ��� �ִ�.
		
		�ϳ� ���������� �Ϲ����� ���α׷����� �� ���� ���� ���� ���� ī����. �׷��� ���������� �����ӿ�ũ�� ���鶧��
		�̷��� ����� �ʼ������� ����ؾ� �ϴ� ��¿�� ���� �����
		*/
	}
}
