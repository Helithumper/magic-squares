import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.DropMode;


public class lol extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lol frame = new lol();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lol() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLoginProgram = new JLabel("Login Program!");
		lblLoginProgram.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		contentPane.add(lblLoginProgram, BorderLayout.NORTH);
		
		JLabel lblU = new JLabel("Username: ");
		contentPane.add(lblU, BorderLayout.WEST);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(12);
		progressBar.setForeground(Color.PINK);
		contentPane.add(progressBar, BorderLayout.SOUTH);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setToolTipText("wut wut");
		editorPane.setDropMode(DropMode.ON);
		contentPane.add(editorPane, BorderLayout.CENTER);
	}

}
