package nave;

public class CircleBullet {

	private int width;
	private int height;
	private int speed;
	private boolean split;
	
	public CircleBullet() {
		width=10;
		height=10;
		speed=3;
		split=true;
	}
	
	public int getWidth() {return width;}
	public int getHeight() {return height;}
	public int getSpeed() {return speed;}
	public boolean getSplit() {return split;} 

}
