package core.display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Display extends JFrame{
	private int FRAME_WIDTH;
	private int FRAME_HEIGHT;
	JPanel contentPane;
	
	public Display(String title, String versionID){
		this(title, versionID, 640, 480);
	}
	
	public Display(String title, String versionID, int width, int height){
		FRAME_WIDTH = width;
		FRAME_HEIGHT = height;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title + " V: " + versionID);
		//setResizable(false);
		//addKeyListener(i);
		requestFocus();
		//setIconImage(new ImageIcon(imgURL).getImage());
		
		contentPane = new JPanel(null);//new BorderLayout(0, 0)
		contentPane.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		//contentPane.setBackground(Color.RED);
		setContentPane(contentPane);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void add(JComponent j){
		contentPane.add(j);
		contentPane.repaint();
	}
	
	public int getWidth(){
		return FRAME_WIDTH;
	}
	public int getHeight(){
		return FRAME_HEIGHT;
	}
}
