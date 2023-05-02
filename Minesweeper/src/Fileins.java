import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Element;
import javax.swing.text.html.ListView;


public class Fileins extends JPanel {
	private Font p;
	private String res;
	private Scanner s;
	private Image im;
	private ListView v;
	private File f;
	public  Fileins () {
		im = Toolkit.getDefaultToolkit().createImage("src//reka.jpg");
		p=new Font("Ariel",Font.BOLD,50);//Type of letters
		f=new File("src//file.txt");
		try {
			s=new Scanner(new BufferedReader(new FileReader(f)));
			res="";
			while(s.hasNext()) {
				res=s.nextLine();
				add(new JLabel(res));

			}
			s.close();

		}
		catch (FileNotFoundException e) {
		}

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(im,0,35,500,500,this);


	}

	public static void main(String[] args) {

		JFrame frame=new JFrame();
		frame.add(new  Fileins());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setTitle("M");
		frame.setLocationRelativeTo(null);//center the window
		//frame.setResizable(false);//lock the possibility of change the size of the window
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
		frame.setVisible(true);

	}	


}
















