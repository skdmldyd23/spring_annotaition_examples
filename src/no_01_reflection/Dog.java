package no_01_reflection;

// °³¸¦ Ç¥ÇöÇØº¸¾ÒÀ¾´Ï´Ù.
public class Dog {
	private int x;
	private int y;
	private int weight;
	private String sound;
	
	public Dog() {
		x = 0;
		y = 0;
		weight = 20;
		sound = "¿Ð¿Ð";
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
