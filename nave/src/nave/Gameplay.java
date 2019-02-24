package nave;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Gameplay extends JPanel implements KeyListener,ActionListener {

	private boolean play=false;
	private boolean start=true;
	private int scoreP=0;
	private int scoreB=0;
	
	private int nr_bull=0;
	private Timer timer;
	private int delay=15;
	
	private ArrayList<Bullets> bull=new ArrayList<Bullets>();
	private int PlayerX=310;
	private Bootplay boot;
	
	public Rectangle getValue() {
		return new Rectangle(PlayerX,550,50,20);
	}
	
	public Gameplay() {
		boot=new Bootplay();
		addKeyListener(this);
		setFocusable(true);  // obtin concentrarea asupra ei
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		timer.start();
	}
	
	public void drawScore(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("serif",Font.BOLD ,25));
		g.drawString("Score: "+scoreP, 20, 20);
		g.drawString("Score Boot: "+scoreB,20,40);
	}
	
	/*
	public void Start() {
		while(start)
		{
			if(scoreB>200 || scoreP >200)
				start=false;
		
			if(boot.nume(PlayerX))
				scoreB++;
				
		}
	}
*/	
	
	public void paint (Graphics g) {
		
		
		//backgroud
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 600, 600);
		
		//bullets
		g.setColor(Color.GREEN);
		boot.moveBootAuto();
		
	if(boot.VerificaColiziune(PlayerX))
		scoreB++;
	
		
		for (int i=0;i<bull.size();i++ )
		{
			boot.moveBootPosition(bull.get(i).getBallX(), bull.get(i).getBallY());
		
			if(boot.colisionBoot(bull.get(i).getBallX(), bull.get(i).getBallY()))
					scoreP++;
		
				
			if(bull.get(i).getBallX() >= boot.getBootX() && bull.get(i).getBallX()<=boot.getBootX()+boot.getBootWeight() && bull.get(i).getBallY()==boot.getBootY())
			{
				bull.remove(i);
				scoreP++;
				System.out.println("scorul este "+ scoreP);

			}
			
			if(bull.get(i).getBallY()<=0)
			{
				bull.remove(i);
			}
		}
		
		for(Bullets bl : bull)
		{
			g.fillRect(bl.getBallX(), bl.getBallY(), 10, 10);
		}
		
		//bullets boot
		boot.BulletBootPaint(g, PlayerX);
		
		
		// player
		g.setColor(Color.GREEN);
		g.fillRect(PlayerX,550,50,20);
		
		
		// boot
		g.setColor(Color.RED);
		g.fillRect(boot.getBootX(),boot.getBootY(),boot.getBootWeight(),boot.getBootHeight());
		
		//score
		drawScore(g);
	//	g.dispose(); // finalizeaza mai rapid crearea grafica a componentelor
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
	for(Bullets bl : bull)
		bl.addY();
	
	repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(PlayerX >= 550)
				PlayerX=550;
			else
				moveRight();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(PlayerX < 50)
				PlayerX=0;
			else
				moveLeft();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_P) {
			bull.add(new Bullets(PlayerX+25,600,true));
					}
			
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void moveRight()
	{
		play=true;
		PlayerX+=20;
	}
	
	public void moveLeft()
	{
		play=true;
		PlayerX-=20;
	}

}
