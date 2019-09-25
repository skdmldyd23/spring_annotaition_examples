package no_03_annotation_with_reflection;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
	String value() default "�ʱⰪ";
}
