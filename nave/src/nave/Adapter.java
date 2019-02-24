package nave;

import java.awt.Graphics;

public interface Adapter {

	
	public void setPosX(int x);
	public void setPosY(int y);
	public void paintDraw(Graphics g);
	public int getSpeed();
}
