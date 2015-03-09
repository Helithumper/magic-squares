import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;


public class MagicSquareRunner {
	public static JProgressBar bar2;
	static String currentTime;
	public static void update(int a,int b){
		if(a!=120){
		
		bar2.setMaximum(b);
		bar2.setValue(a);
		bar2.setString((int)((double)a/b*100)+"%");}
		else{bar2.setString("PRINTING");}
	}
	public static String calculateTime(long start, long current){
		String hours;
		String minutes;
		String seconds;
		if(Math.abs((int)((start-current)/3600000))<10){hours = "0"+Math.abs((int)((start-current)/3600000));}
		else{hours = Integer.toString(Math.abs((int)((start-current)/3600000)));}
		if(Math.abs((int)((start-current)/60000))<10){minutes = "0"+Math.abs((int)((start-current)/60000));}
		else{minutes = Integer.toString(Math.abs((int)(((start-current)/60000)%60)));}
		if(Math.abs((int)((start-current)/1000))<10){seconds = "0"+Math.abs((int)((start-current)/1000));}
		else{seconds = Integer.toString(Math.abs((int)(((start-current)/1000)%60)));}
		currentTime = hours + ":" + minutes + ":" + seconds;
		return currentTime;
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	public static void main(String[] args) {
		int input = 0;
		Scanner reader = new Scanner(System.in);
		while(true){
		while(input % 2 == 0 || input < 0){
			System.out.println("Enter the Size of the Square: ");
			input = reader.nextInt();
			if(input == 666){
				System.out.println("What is your max number, your highness?");
				input = reader.nextInt();
				//SK sk = new SK();
				JFrame frame = new JFrame();
				JPanel panel = new JPanel();
				JProgressBar bar = new JProgressBar(0,input);
				
				panel.setLayout(new GridLayout(5,1));
				frame.add(panel);
				JLabel title = new JLabel("<html><font color = white>Magic Square Generator</html>",SwingConstants.CENTER);
				panel.add(title);
				JLabel elapsed = new JLabel("<html><font color = white>Time Elapsed: 0 Minutes</html>",SwingConstants.CENTER);
				panel.add(elapsed);
				panel.add(bar);
				bar2 = new JProgressBar(0,100);
				panel.add(bar2);
				//int lastValues = 0;
				
				JLabel label = new JLabel("<html><font color = white>The Last Square had " + " values in it!</html>",SwingConstants.CENTER);
				
				bar.setStringPainted(true);
				bar2.setStringPainted(true);
				
				panel.add(label);
				panel.setBackground(Color.BLACK);
				frame.setTitle("Magic Square Generator GUI");
				frame.setVisible(true);
				frame.setMinimumSize(new Dimension(330,100));
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				int maxVal = 50;
				MagicSquare userSquare;
				long startTime = System.currentTimeMillis();
				currentTime = "";
				File currentFile= new File("TextFiles/0 Through 50");
				for(int i = 1 ; i < input; i+=2){
					bar2.setValue(0);
					bar2.setMaximum(i*i);
					userSquare = new MagicSquare(i);
					userSquare.generate();
					System.out.println();
					System.out.println(userSquare.getHeight());
					bar.setValue(i);
					bar.setString(""+i+"/"+input);
					label.setText("<html><font color = white>The Last Square had " + userSquare.getHeight()*userSquare.getHeight() + "  values in it!</html>");
					//lastValues=userSquare.getHeight()*userSquare.getHeight();
					//PrintWriter writer;
					if(i>maxVal){
						currentFile = new File("TextFiles/"+maxVal+" Through " +(maxVal+50));
						currentFile.mkdirs();
						//FileUtils.cleanDirectory(currentFile.getName());
						maxVal+=50;
					}
					userSquare.toStringMod();
					//try {
						//if((i%50==1)&&(i>1)){
						//writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("TextFiles/"+currentFile.getName()+"/PRINTOUT " + i+".txt")));//}
						//else{writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("TextFiles/lastSquare.txt")));}
						//calculateTime(startTime,System.currentTimeMillis());
						//writer.print(userSquare.toString());
						//writer.close();
					//} catch (Exception e){}
					
					//currentTime = Math.abs((int)((startTime-System.currentTimeMillis())/3600000)) + ":" + Math.abs((int)((startTime-System.currentTimeMillis())/60000)) + ":" + Math.abs((int)((startTime-System.currentTimeMillis())/1000));
					elapsed.setText("<html><font color = white>Time Elapsed: " + currentTime + "</html>");
					}
			}
		}
		MagicSquare userSquare = new MagicSquare(input);
		userSquare.generate();
		userSquare.toStringMod();
		return;
		//System.out.println(userSquare.toString());
		//input = 0;
		/*PrintWriter writer;
		try {
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("TextFiles/Biggie.txt")));
			writer.print(userSquare.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*///}
		//else{writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("TextFiles/lastSquare.txt")));}
		//calculateTime(startTime,System.currentTimeMillis());
		
		}
	}

}
