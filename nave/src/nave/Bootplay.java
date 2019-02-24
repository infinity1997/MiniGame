package nave;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class Bootplay {

	private int delayBullet=10;
	private int BootX;
	private int BootY;
	private boolean move=true;
	private int BootWeight;
	private int BootHeight;
	private Random rn = new Random();
	private ArrayList<Bullets> bull=new ArrayList<Bullets>();
	
	public Bootplay()
	{
		 BootX=310;
		 BootY=50;
		 BootWeight=80;
		 BootHeight=30;
			
	}
	
	public int getBootX() {return BootX;}

	public int getBootY() {return BootY;}

	public int getBootWeight() {return BootWeight;}

	public int getBootHeight() {return BootHeight;}
	
	public int getBootBulletX(int i) {return bull.get(i).getBallX();}

	public int getBootBulletY(int i) {return bull.get(i).getBallY();}

	public Rectangle getValueBoot() {
		return new Rectangle(BootX,BootY,BootWeight,BootHeight);
	}
	
	public boolean colisionPlayer(int xBulletBoot,int yBulletBoot,int PlayerX) {
		 if(xBulletBoot+10 >= PlayerX && xBulletBoot <= PlayerX+50)
		 {	if(550-yBulletBoot+10==0)
			 return true;
		 else
			 return false;
		 }
		 else
			 return false;
	 }
	
	public boolean VerificaColiziune(int x) {
		for(int j=0;j<bull.size();j++) {
			if(colisionPlayer(getBootBulletX(j),getBootBulletY(j),x))
				return true;
		}
		return false;
	}
	
	public void moveBootRight()
	{
		if (BootX<=600-BootWeight)
			BootX+=30;
	}
	
	public void moveBootLeft()
	{
		if (BootX>=0)
			BootX-=30;
	}
	
	public int getDistanceBootandBullet(int bullet)
	{
		//calculeaza distanta de la un bulet pana la contactul cu bootul
		int aux=BootY+BootHeight;
		return bullet-aux;
	}
	
	public void moveBootAuto()
	{
		
		int p1 = rn.nextInt(100);
		if(move==true)
		{
			if (BootX<=600-BootWeight)
				BootX+=2;
		
		}
		else if(move==false)
		{			
			if (BootX>=0)
				BootX-=2;
		}
			
		if(p1<=2)
			move=!move;
	}
	
	public void addBullet() {
		if(delayBullet==0) {
			bull.add(new Bullets(BootX+25,BootY,true));
			delayBullet=10;
		}
		else
			delayBullet--;
		
	}
	
	public void moveBullets() {
		
		for (int i=0;i<bull.size();i++ )
		{
			bull.get(i).addYBoot();
			
			if(bull.get(i).getBallY()>=600)
			{
				bull.remove(i);
			}
		}
	}
	
	void BulletBootPaint(Graphics g, int x) {
		
		g.setColor(Color.RED);
		if(getBootX()-x>=-50  &&  getBootX()-x<=50)
		{		
		addBullet();
		}
		moveBullets();
		
		for(Bullets bl : bull)
		{
			g.fillRect(bl.getBallX(), bl.getBallY(), 10, 10);
		}
	}
	
	public boolean colisionBoot(int xBulletPlayer,int yBulletPlayer) {
		 if(xBulletPlayer+10 >= BootX+BootHeight && xBulletPlayer <= BootX+BootWeight)
		 {	if(BootY+BootHeight-yBulletPlayer>=0 && BootY+BootHeight-yBulletPlayer<=10)
			 return true;
		 else
			 return false;
		 }
		 else
			 return false;
	 }
	
	public void moveBootPosition(int xBulletPlayer,int yBulletPlayer) {
		if (yBulletPlayer-BootY<=60)
		{
			if(xBulletPlayer+10 >= BootX && xBulletPlayer <= BootX+BootWeight )
			{	
				
				if(BootX+BootWeight/2<xBulletPlayer) {
					if(BootX-20<=0) {
						moveBootRight();
						moveBootRight();
						
					}
						moveBootLeft();}
				else {
					if(BootX+BootWeight+20>=600) {
					
						moveBootLeft();
						moveBootLeft();
						
					}
					
					moveBootRight();
				}
				
			
					
			}
			
		}
	}
	
}
