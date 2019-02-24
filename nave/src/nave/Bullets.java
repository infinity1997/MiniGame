package nave;

public class Bullets {

	
	private int ballposX;
	private int ballposY;	
	private int ballXdir=-1;
	private boolean shoot=false;
	
	
	public void move() {
		ballposY+=ballXdir;
	}	 public Bullets(int x, int y,boolean t) {
		 ballposX=x;
		 ballposY=y;
		 shoot=t;
	 }
	
	 public int getBallX() {return ballposX;}
	 public int getBallY() {return ballposY;}
	 public boolean getShoot() {return shoot;}	
	
	 public void addY() {
		 ballposY-=3;	
		 }
	 
	 public void addYBoot() {
		 ballposY+=3;
	 }
 }

	
	

