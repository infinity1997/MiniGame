package nave;

import javax.swing.JFrame;

public class main {

	public static void main (String[] args)
	{
		Gameplay game=new Gameplay();
		JFrame frame= new JFrame("nave");
		
		frame.setBounds(10,10,600,600);
		frame.setVisible(true);
		frame.setResizable(false);
		//frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
	}
}
