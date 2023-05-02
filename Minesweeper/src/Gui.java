import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Gui extends JPanel {
	private JButton []arrBottum;//a set of buttons	
	private Board board;
	private int[]arrBoard;
	public Object MouseButton;
	private Color color;
	private int countMokshimLable;
	private JLabel mokshimLable;
	private JButton hag;
	private JLabel mLeft, mLeft1,mLeft2;
	private Font f,fi;
	public  Gui (int w,int l,int c){	
		f=new Font("Ariel",Font.BOLD,25);//Type of letters
		fi=new Font("Ariel",Font.BOLD,20);
		board=new Board(w,l,c);
		Random r=new Random();
		color=new Color(r.nextInt());
		arrBoard=board.getArr();
		arrBottum=new JButton [board.getSIZE()];
		countMokshimLable= board.getCountOfMokshim();
		String s=String.valueOf(countMokshimLable);
		mokshimLable=new JLabel(s);
		mokshimLable.setBackground(Color.cyan);
		mokshimLable.setFont(f);
		mokshimLable.setOpaque(true);
		mLeft=new JLabel("");
		mLeft.setFont(fi);
		mLeft.setBackground(Color.cyan);
		mLeft.setOpaque(true);
		mLeft1=new JLabel("מוקשים ");
		mLeft1.setFont(fi);
		mLeft1.setBackground(Color.cyan);
		mLeft1.setOpaque(true);
		mLeft2=new JLabel("Mokshim");
		mLeft2.setFont(fi);
		mLeft2.setBackground(Color.cyan);
		mLeft2.setOpaque(true);


		hag=new JButton(new ImageIcon("src//degel.jpg"));
		setLayout(new GridLayout(board.getLength()+1,board.getWedth()));
		for(int i=0;i<board.getSIZE();i++) {//Initializes the array of buttons
			arrBottum[i]=new JButton("");//(String)a[i]);
			arrBottum[i].setBackground(this.color);
			add(arrBottum[i]);
			arrBottum[i].addMouseListener(new mut() );

		}	
		add(hag);
		add(mokshimLable);
		add(mLeft2);
		add(mLeft1);
		add(mLeft);
	}

	public JButton[] getArrBottum() {
		return arrBottum;
	}
	public void setArrBottum(JButton[] arrBottum) {
		this.arrBottum = arrBottum;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public int[] getArrBoard() {
		return arrBoard;
	}
	public void setArrBoard(int[] arrBoard) {
		this.arrBoard = arrBoard;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	private class mut extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if (e.getButton()==e.BUTTON1) {
				for(int j=0;j<arrBottum.length;j++) {
					if(e.getSource().equals(arrBottum[j])) {
						arrBottum[j].setBackground(Color.white);
						if(arrBottum[j].getText().equals("")) {
							if(arrBoard[j]>0) {
								String s=String.valueOf(arrBoard[j]);
								arrBottum[j].setText(s);
								setColorText(arrBottum[j]);
							}

							if(arrBoard[j]==0) {
								open(j);

							}
							String	s="";
							if(arrBoard[j]<0) {			
								done();

								choose(0);
							}
							if(win()) {
								s="winner";
								choose(1);
							}
						}
					}
				}

			}
			if (e.getButton()==e.BUTTON3) {
				for(int j=0;j<arrBottum.length;j++) {
					if(e.getSource().equals(arrBottum[j])) {
						if(arrBottum[j].getText().equals("")) {
							arrBottum[j].setText("*");
							Font f=new Font("Ariel",Font.BOLD,60);//Type of letters
							arrBottum[j].setFont(f);
							countMokshimLable--;
							String s=String.valueOf(countMokshimLable);
							mokshimLable.setText(s);

						}
						else	


							if(arrBottum[j].getText().equals("*") ){
								arrBottum[j].setText("");
								countMokshimLable++;
								String s=String.valueOf(countMokshimLable);
								mokshimLable.setText(s);
							}
					}
				}

			}
		}
	}

	public void	choose(int happened){

		Win w=new Win(board.getWedth(),board.getLength(),board.getCountOfMokshim(),happened);
		JFrame frame = new JFrame("M");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(w);
		frame.setSize(880,500);
		frame.setLocationRelativeTo(null);//center the window
		frame.setResizable(false);//lock the possibility of change the size of the window
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
		frame.setVisible(true);	









	}
	public void setColorText(JButton j) {
		if(j.getText().equals("1"))
			j.setForeground(Color.blue);
		if(j.getText().equals("2"))
			j.setForeground(Color.red);
		if(j.getText().equals("3"))
			j.setForeground(Color.GREEN);
		if(j.getText().equals("4"))
			j.setForeground(Color.yellow);
		if(j.getText().equals("5"))
			j.setForeground(Color.magenta);
		if(j.getText().equals("6"))
			j.setForeground(Color.ORANGE);
		if(j.getText().equals("7"))
			j.setForeground(Color.darkGray);
		if(j.getText().equals("8"))
			j.setForeground(Color.cyan);



	}
	public void done() {
		for(int i=0;i<arrBottum.length;i++) {
			if(arrBoard[i]==-1)
				arrBottum[i].setText("x");

		}
	}
	public boolean win() {
		for (int i = 0; i < board.getSIZE(); i++) {
			if(arrBoard[i]>0&&(arrBottum[i].getText().equals("")||arrBottum[i].getText().equals("*")))	
				return false;

		}
		return true;


	}
	public void restart1() {
		for (int i = 0; i <arrBottum.length; i++) {
			arrBottum[i].setText("");	
			arrBottum[i].setBackground(color);
		}
		Board b=new Board(board.getWedth(),board.getLength(),board.getCountOfMokshimMove());
		this.arrBoard=b.getArr();


	}
	public void restart0() {

		for (int i = 0; i <arrBottum.length; i++) {
			arrBottum[i].setText("");		
			arrBottum[i].setBackground(color);
		}	
	}
	public  void open(int position) {
		if(position>=0&&position<board.getSIZE()) {
			if(arrBottum[position].getText()!="") {
				return;
			}
			if(arrBoard[position]>0) {
				String s=String.valueOf(arrBoard[position]);
				arrBottum[position].setText(s);
				setColorText(arrBottum[position]);
				arrBottum[position].setBackground(Color.white);;
				return;
			}

			if(arrBoard[position]==0) {
				String s=" ";
				arrBottum[position].setText(s);
				arrBottum[position].setBackground(Color.white);;
				if((position+1)%board.getWedth()!=0)
					open(position+1);
				if((position)%board.getWedth()!=0)		
					open(position-1);
				open(position+board.getWedth());
				open(position-board.getWedth());
				if((position+1)%board.getWedth()!=0)
					open(position+board.getWedth()+1);
				if((position)%board.getWedth()!=0)
					open(position+board.getWedth()-1);
				if((position+1)%board.getWedth()!=0)
					open(position-board.getWedth()+1);
				if((position)%board.getWedth()!=0)
					open(position-board.getWedth()-1);
			}

		}
	}
	public void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame();
		frame.add(new Gui(10,10,0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/mokesh.jpg"));
		frame.setTitle("M");
		frame.setVisible(true);
	}


}






















































