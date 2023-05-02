

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

//import hodyapro.Instructions;
public class Start extends JPanel{
	private Image img;
	private JButton start,Instructions;
	private Border emptyBorder;
	public Start() {
		img = Toolkit.getDefaultToolkit().createImage("src/color.jpg");
		emptyBorder=BorderFactory.createEmptyBorder(500, 95,60, 650);//create empty border
		setBorder(emptyBorder);
		setLayout(new GridLayout(2,2,6,6));
		start=new JButton("start");
		Instructions=new JButton("Instructions");
		add(Instructions);
		add(start);
		Font font=new Font("Comic Sans MS",Font.ITALIC,20);
		start.setFont(font);
		Instructions.setFont(font);
		StartListener l=new StartListener();
		start.addActionListener(l);
		Instructions.addActionListener(l);
	}
	//create the background 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0,1300,700,this);
	}

	private class StartListener implements ActionListener{
		//close all open windows

		public void actionPerformed(ActionEvent e) {


			if(e.getSource().equals(start)) {
				JFrame frame=new JFrame();
				frame.add(new Ask());
				frame.setSize(1300,700);
				frame.setLocationRelativeTo(null);//center the window
				frame.setTitle("M");
				frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
				frame.setVisible(true);
			}

			if(e.getSource().equals(Instructions)) {
				JFrame frame = new JFrame("M");
				frame.add(new Fileins());
				frame.setSize(730,540);
				frame.setLocationRelativeTo(null);//center the window
				frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
				frame.setResizable(false);//lock the possibility of change the size of the window
				frame.setVisible(true);



			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("M");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Start panel=new Start();
		frame.add(panel);
		frame.setSize(1300,700);
		frame.setLocationRelativeTo(null);//center the window
		frame.setResizable(false);//lock the possibility of change the size of the window
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
		frame.setVisible(true);
	}

}