
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class Tester {
	public static void main(String[] args) {
		//Open the StartGame window
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