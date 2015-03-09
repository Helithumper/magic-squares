import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


public class MagicSquare {
	
	//Fields
	private int[][] square;
	private int size;
	private int row;
	private int column;
	private int matrixSize;
	private int progress;
	//private int usedTimes;
	
	//Constructor
	public MagicSquare(int s){
		size = s;
		square = new int[size][size];
		row = 0;
		column = size/2;
		matrixSize = size * size;
		//square[row][column] = 1;
		progress=0;
		//usedTimes=1;
	}
	
	//AM
	public int getProgress(){return progress;}
	
	//Methods
	public void generate(){
		int tempRow;
		int tempCol;
		//progress = 0;
		int row2 = size-1;
		int col2 = size/2;
		square[row2][col2]=1;
		for(int count = 2; count<=matrixSize; count++){
			
			if (square[(row2 + 1) % size][(col2 + 1) % size] == 0) {
                row2 = (row2 + 1) % size;
                col2 = (col2 + 1) % size;
            }
            else {
                row2 = (row2 - 1 + size) % size;
                // don't change col
            }
            square[row2][col2] = count;
			/*tempRow = row;
			tempCol = column;
			//Check if on top row
			if(tempRow==0){
				tempRow=size-1;
				//System.out.println("hi");
			}
			else{tempRow--;}
			
			if(tempCol+1==size){
				tempCol = 0;
				//System.out.println("hello");
			}
			else{tempCol++;}
			
			if(square[tempRow][tempCol]==0){
				square[tempRow][tempCol]=count;row=tempRow;column=tempCol;
			}
			
			else{
				
				if(row==size-1){
					square[0][column]=count;row=0;
				}
				else{
					square[row+1][column] = count;
					row=row+1;
				}*/
			}
		//System.out.println(toString());
	    //progress++;
	    //System.out.println(progress);
	    //MagicSquareRunner.update(progress,matrixSize*2);
		}
		//System.out.println("Generate");
	
	public int getHeight(){return square.length;}
	//toString
	public void toStringMod(){
		//return "Square: " + Arrays.toString(square) + "\nSize: " + size + "\nRow: " + row + "\nColumn: " + column + " \nMatrix Size: " + matrixSize;
		String result = "";
		long magicConstant = 0;
		//MagicSquareRunner.update(0, matrixSize);
		progress=0;
		System.out.println("try2");
		/*for(int i = 0 ; i<square.length; i++){
			result+="----";
			for(int j =0; j<square[i].length;j++){
				result+= square[i][j]+",";progress++;MagicSquareRunner.update(progress, matrixSize);
			}
			result+= "\n";*/
			//magicConstant = magicConstant+square[][0];
		//}
		//System.out.println("tostring");
		//usedTimes++;
		JFrame frame = new JFrame();
		frame.setMinimumSize(new Dimension(400,300));
		JPanel panel = new JPanel();
		JProgressBar bar = new JProgressBar();
		panel.add(bar);
		frame.add(panel);
		frame.setVisible(true);
		int done = square.length*square.length;
		bar.setMaximum(done);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("TextFiles/Biggies.txt")));
			//writer.print(Arrays.deepToString(square));
			//writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//int done = square.length*square.length;
		for(int i = 0;i<square.length;i++){
			for(int j = 0;j<square[i].length;j++){
				writer.print(square[i][j]+".");
				
				done--;
				bar.setValue(done);
			}
			writer.println();
			magicConstant+=square[i][0];
		}
		
		writer.print("--__--__--The magic constant is " + magicConstant + ". The Number of Rows/Columns is " + square.length + ". Time Elapsed: " + MagicSquareRunner.currentTime + ". Computer Name: " + System.getenv("computername") + ".--__--__--");
		writer.close();
	}
}