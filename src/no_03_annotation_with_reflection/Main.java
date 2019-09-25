package no_03_annotation_with_reflection;

import java.lang.reflect.Field;

/*
���÷����� �̿��ϸ� Ŭ������ ��� ������ ������ �� �ְ�, �� ����������� ������̼� ���� ���Եȴ�.
��, ��ü�� ����� �ش簴ü�� ���� reflection���� �˻��� ���� ������̼� ������ ã�� �� �� �ְ�,
�̸� �̿��ϸ� �������� @Controller�� �پ������� ���� ���θ� ���� �� �ִ�.
*/
public class Main {
	public static void main(String[] args) {
		// ��
		Dog dog = new Dog();

		/* 
		���÷����� �̿��Ͽ� �ʵ带 ��� �˻��ϸ�, ���� FieldAnnotation�� �پ�������, StringŸ���� ģ���� ������
		������̼ǿ� ������ ���� ������ �־��ִ� �ڵ��̴�.
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
		���ݱ��� �� �ൿ�� ����ϸ� ������ ����.
		1. ������̼��� ���� �������.
		2. reflection���� ������̼��� �پ����� ���θ� Ȯ���Ͽ���.
		
		�� �ܼ��� ����� �̿��ϸ� Spring���� ���Ҵ� ���ؾȵǴ� �ൿ�� ��� ���� �� �ټ� �ִ�.
		���÷� @Controller��� ������̼��� ���̸�, set()�̳� add()�� �Ѱ����� �ʾƵ� �������� ��Ʈ�ѷ����� �ν��ϰ�
		@RequestMapping("url")�̶�� ������̼��� ���̸� �˾Ƽ� �ּҿ� �����ϴ� �۾��� ��� ���� �� �ִ�.
		*/
	}
}
