import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Win extends JPanel  {
	private JButton startNew,close;
	private JLabel lableimage;
	private ImageIcon imgwin;
	private ImageIcon imgfield;
	private int wedth;
	private int lenght;
	private int mokesh;

	public Win(int w,int l,int c,int happened) {
		wedth=w;
		lenght=l;
		mokesh=c;

		close=new JButton(" I want to exist");
		close.setBackground(Color.yellow);
		startNew=new JButton(" I want to start new game");
		startNew.setBackground(Color.yellow);
		if(happened==0) {
			imgfield=new ImageIcon("src/failed.jpg");
			setBackground(Color.red);
			lableimage=new JLabel(imgfield);

		}
		if(happened==1) {
			imgwin=new ImageIcon("src/2048.jpg");
			setBackground(Color.PINK);
			lableimage=new JLabel(imgwin);
		}
		add(startNew);
		add(close);
		add(lableimage);
		startNew.addActionListener(new ButtonListener());
		close.addActionListener(new ButtonListener());



	}

	private class ButtonListener implements ActionListener{//Listener class
		public void actionPerformed(ActionEvent e) {	
			java.awt.Window win[] = java.awt.Window.getWindows();
			for(int i=0;i<win.length;i++){ 
				win[i].dispose(); 
			}

			if(e.getSource().equals(close)) {
				System.exit(0);	
			}
			if(e.getSource().equals(startNew)) {

				JFrame frame=new JFrame();
				frame.add(new Gui(wedth,lenght,mokesh));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(800,680);
				frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
				frame.setTitle("M");
				frame.setVisible(true);






			}	


		}

	}










	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("M");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Win panel=new Win(10, 10, 0,1);
		frame.add(panel);
		frame.setSize(880,500);
		frame.setLocationRelativeTo(null);//center the window
		frame.setResizable(false);//lock the possibility of change the size of the window
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
		frame.setVisible(true);
	}





}