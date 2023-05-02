import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class Ask extends  JPanel{
	private Image img;
	private Border emptyBorder;
	protected int length;
	protected int wedth;
	protected int countOfMokshim;
	private JRadioButton opt1,opt2,opt3,opt4;
	private JButton ok;
	private JLabel wedthLable,lengthLable,mokesLable,instructionLable;
	private JTextField wedthField,lengthField,mokeshField;
	private ButtonGroup group;
	private int count;
	public Ask() {
		Font f=new Font("Ariel",Font.BOLD,50);//Type of letters
		Font d=new Font("Ariel",Font.BOLD,15);
		img = Toolkit.getDefaultToolkit().createImage("src/boom.png");
		emptyBorder=BorderFactory.createEmptyBorder(200, 0,100, 650);//create empty border
		setBorder(emptyBorder);
		setLayout(new GridLayout(3,4));
		count=-1;
		lengthField=new JTextField(4);
		lengthField.setFont(f);
		add(lengthField);
		lengthLable=new JLabel("(9-30):הכנס אורך");
		lengthLable.setFont(d);
		lengthLable.setForeground(Color.yellow);
		add(lengthLable);
		opt4=new JRadioButton("התאמה אישית");
		opt4.setBackground(Color.orange);
		add(opt4);
		opt1=new JRadioButton("מתחיל");
		opt1.setBackground(Color.orange);
		add(opt1);
		wedthField=new JTextField(4);
		wedthField.setFont(f);
		add(wedthField);
		wedthLable=new JLabel("(9-24)הכנס רוחב");
		wedthLable.setFont(d);
		wedthLable.setForeground(Color.yellow);
		add(wedthLable);
		instructionLable=new  JLabel("בחר!");
		instructionLable.setFont(f);
		instructionLable.setForeground(Color.yellow);
		add(instructionLable);
		opt2=new JRadioButton("בינוני");
		opt2.setBackground(Color.orange);
		add(opt2);
		mokeshField=new JTextField(4);
		mokeshField.setFont(f);
		add(mokeshField);
		mokesLable=new JLabel( "(10-668)הכנס מוקשים");
		mokesLable.setFont(d);
		mokesLable.setForeground(Color.yellow);
		add(mokesLable); 
		ok=new JButton("אישור");
		ok.setBackground(Color.red);
		add(ok);
		opt3=new JRadioButton("מתקדם");
		opt3.setBackground(Color.orange);
		add(opt3);
		group=new ButtonGroup();
		group.add(opt1);
		group.add(opt2);
		group.add(opt3);
		group.add(opt4);
		opt1.addActionListener(new ButtonListener());
		opt2.addActionListener(new ButtonListener());
		opt3.addActionListener(new ButtonListener());
		opt4.addActionListener(new ButtonListener());
		ok.addActionListener(new ButtonListener());

	}

	//create the background 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0,1300,700,this);
	}



	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			if(e.getSource().equals(ok)) {
				if(count==-1)
					JOptionPane.showMessageDialog(null,"choose opticn"," Message",JOptionPane.WARNING_MESSAGE);
				if(count==0) {
					buildGame ();
				}
				if(count==1) {

					try {

						wedth=Integer.parseInt(wedthField.getText());	
						length=Integer.parseInt(lengthField.getText());	
						countOfMokshim=Integer.parseInt(mokeshField.getText());	

						if(checkValue()==true)
							buildGame ();


					}
					catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null,"enter all right data"," Message",JOptionPane.WARNING_MESSAGE);
						reset();


					}





				}
			}
			if(e.getSource().equals(opt1)){

				change(9,9,10);
			}
			if(e.getSource().equals(opt2)){
				change(16,16,40);
			}
			if(e.getSource().equals(opt3)){
				change(30,16,99);
			}
			if(e.getSource().equals(opt4)){
				count=1;
			}
		}
	}

	public boolean checkValue() {
		if(length<9||length>30||wedth<9||wedth>24||countOfMokshim<10||countOfMokshim>668) {
			JOptionPane.showMessageDialog(null,"enter valid numbers"," Message",JOptionPane.WARNING_MESSAGE);
			reset();

			return false;
		}

		return true;
	}
	public void reset() {
		wedthField.setText("");
		lengthField.setText("");
		mokeshField.setText("");	
	}
	public void buildGame (){
		JFrame frame=new JFrame();
		frame.add(new Gui(wedth,length,countOfMokshim));
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,680);
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
		frame.setTitle("M");
		frame.setVisible(true);

	}
	public void change (int w,int l,int c) {
		count=0;
		length=w;
		wedth=l;	
		countOfMokshim=c;	
	}

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.add(new Ask());
		frame.setSize(1300,700);
		frame.setTitle("M");
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
		frame.setVisible(true);
	}	









}

