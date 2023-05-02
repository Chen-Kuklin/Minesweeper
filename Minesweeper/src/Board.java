import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import java.util.function.IntConsumer;

public class 	Board  {
	private int []arr;  
	private int length;
	private int wedth;
	private int countOfMokshim;
	private int countOfMokshimMove;
	private final int  SIZE;
	public  Board( int w,int l,int c){
		wedth=w;
		length=l;
		countOfMokshim=c;
		SIZE=wedth*length;
		arr=new int[SIZE];
		fixmokshim();
		fixNumbers();

	}
	public int getCountOfMokshimMove() {
		return countOfMokshimMove;
	}
	public void setCountOfMokshimMove(int countOfMokshimMove) {
		this.countOfMokshimMove = countOfMokshimMove;
	}
	public int[] getArr() {
		return arr;
	}


	public void setArr(int[] arr) {
		this.arr = arr;
	}


	public int getSIZE() {
		return SIZE;
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWedth() {
		return wedth;
	}
	public void setWedth(int wedth) {
		this.wedth = wedth;
	}
	public int getCountOfMokshim() {
		return countOfMokshim;
	}
	public void setCountOfMokshim(int countOfMokshim) {
		this.countOfMokshim = countOfMokshim;
	}
	public void fixmokshim(){
		int i=countOfMokshim;
		while(i!=0) {
			int index=(int)((Math.random()*((SIZE-1)+1)));	
			if(arr[index]!=-1) {
				arr[index]=-1;
				i--;
			}
		}

	}



	

	
	public void fixNumbers(){
		int count =0;
		if(arr[0]!=-1) {
			if(arr[1]==-1)
				count++;
			if(arr[this.wedth]==-1)
				count++;
			if(arr[this.wedth+1]==-1) 
				count++;
			arr[0]=count;//האיבר הראשון במערך 
			count=0;
		}

		if(arr[this.wedth-1]!=-1) {
			if(arr[this.wedth-2]==-1)
				count++;
			if(arr[(this.wedth*2)-2]==-1)
				count++;
			if(arr[(this.wedth*2)-1]==-1)
				count++;
			arr[wedth-1]=count;//האיבר האחרון בשורה הראשונה  
			count=0;
		}

		if(arr[this.wedth*(this.length-1)]!=-1) {
			if(arr[this.wedth*(this.length-2)]==-1)
				count++;
			if(arr[(this.wedth*(this.length-2))+1]==-1)
				count++;
			if(arr[(this.wedth*(this.length-1))+1]==-1)
				count++;
			arr[this.wedth*(this.length-1)]=count;//האיבר הראשון  בשורה האחרונה 
			count=0;
		}
		if(arr[(SIZE)-1]!=-1 ){
			if(arr[(SIZE)-2]==-1)
				count++;
			if(arr[(this.wedth*(this.length-1))-1]==-1)
				count++;
			if(arr[(this.wedth*(this.length-1))-2]==-1)
				count++;
			arr[(SIZE)-1]=count;//האיבר האחרון בשורה האחרונה 
			count=0;
		}
		for(int i=1;i<this.wedth-1;i++) {
			if(arr[i] !=-1) {
				if(arr[i+1]==-1)
					count++;
				if(arr[i-1]==-1)
					count++;
				if(arr[i+this.wedth]==-1)
					count++;
				if(arr[i+this.wedth-1]==-1)
					count++;
				if(arr[i+this.wedth+1]==-1)
					count++;
				arr[i]=count;//האיברים בשורה הראשונה 	
				count=0;
			}
		}

		for(int i=this.wedth*(this.length-1)+1;i<(this.SIZE)-1;i++) {
			if(arr[i]!=-1) {
				if(arr[i-1]==-1)
					count++;
				if(arr[i+1]==-1)
					count++;
				if(arr[i-this.wedth]==-1)
					count++;
				if(arr[i-this.wedth-1]==-1)
					count++;
				if(arr[i-this.wedth+1]==-1)
					count++;
				arr[i]=count;//האיברים בשורה האחרונה 
				count=0;

			}
		}
		for(int i=wedth;i<this.wedth*(this.length-1);i+=wedth) {
			if(arr[i]!=-1) {
				if(arr[i+1]==-1)
					count++;
				if(arr[i-wedth]==-1)
					count++;
				if(arr[i+wedth]==-1)
					count++;
				if(arr[i+1+wedth]==-1)
					count++;
				if(arr[i+1-wedth]==-1)
					count++;

				arr[i]=count;//האיברים בעמודה הראשונה
				count=0;
			}
		}
		for(int i=(2*wedth)-1;i<this.wedth*(this.length-1);i+=wedth) {
			if(arr[i]!=-1) {
				if(arr[i-1]==-1)
					count++;
				if(arr[i-wedth]==-1)
					count++;
				if(arr[i+wedth]==-1)
					count++;
				if(arr[i-1+wedth]==-1)
					count++;
				if(arr[i-1-wedth]==-1)
					count++;
				arr[i]=count;//האיברים בעמודה הראשונה
				count=0;
			}
		}
		for(int i=wedth+1;i<this.wedth*(this.length-1)-1;i++) {
			if(arr[i]!=-1&&i%this.wedth!=0&&i%this.wedth!=wedth-1) {
				if(arr[i+1]==-1)
					count++;
				if(arr[i-1]==-1)
					count++;
				if(arr[i+wedth]==-1)
					count++;
				if(arr[i+wedth+1]==-1)
					count++;
				if(arr[i+wedth-1]==-1)
					count++;
				if(arr[i-wedth]==-1)
					count++;
				if(arr[i-wedth-1]==-1)
					count++;
				if(arr[i-wedth+1]==-1)
					count++;
				arr[i]=count;//שאר האיברים במערך 
				count=0;
			}}

	}


	}















