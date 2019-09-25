package no_02_annotation;

@ClassAnnotation
public class Dog {
	private int x;
	private int y;
	private int weight;
	@FieldAnnotation(value="¸Û¸Û")
	private String sound;
	
	public Dog() {
		x = 0;
		y = 0;
		weight = 20;
	}
	
	public void bark() {
		System.out.println(sound);
	}
	
	public void move(int vx, int vy) {
		x += vx;
		y += vy;
		System.out.println("x:"+x+", y:"+y);
	}
}
