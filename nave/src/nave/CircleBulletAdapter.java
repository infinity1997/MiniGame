package nave;

import java.awt.Color;
import java.awt.Graphics;

public class CircleBulletAdapter implements Adapter {
	
	public CircleBullet circleb;
	int posX;
	int posY;
	
	public CircleBulletAdapter(int x, int y)
	{
		circleb=new CircleBullet();
		posX=x;
		posY=y;
	}

	@Override
	public void setPosX(int x) {
		posX+=x;
	}

	@Override
	public void setPosY(int y) {
		posY+=y;
	}

	@Override
	public void paintDraw(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval(posX, posX, circleb.getWidth(), circleb.getHeight());
	}
	
	public int getSpeed() {
		return circleb.getSpeed();
	}

}
