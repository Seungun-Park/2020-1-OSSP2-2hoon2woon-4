package hoon2woon2;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.psnbtech.*;

import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main extends JFrame{
	/**
	 *
	 */
	private static final long serialVersionUID = 5622708864988613307L;

	public static Tetris tetris;
	public static Client client;
	public static MultiPlay multi;
	public static BoardPanel board;
	public static SidePanel side;

	public static int num = 0;
	BufferedImage img = null;

	public Main(){
		this.setTitle("Tetris main");// 제목
		this.setSize(700,700);
		this.setVisible(true);// 생성
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		try {
			img = ImageIO.read(new File(Main.class.getResource("/hoon2woon2/Images/Main_Image2.jpg").toString()));
		} catch (IOException e) {
			//TODO: handle exception
			JOptionPane.showMessageDialog(null, "No Image");
			System.exit(0);	
		}
		myPanel panel = new myPanel();
		panel.setSize(700,700);
		this.add(panel);

		JButton singleplaybutton = new JButton("singleplay");		
		singleplaybutton.setHorizontalAlignment(JButton.CENTER);
		singleplaybutton.setPreferredSize(new Dimension(100, 100));

		singleplaybutton.addActionListener(new ActionListener() {

		   @Override
			public void actionPerformed(ActionEvent e) {
				num = 1;
				dispose();
				System.out.println(num);
		   }
		});
		getContentPane().add(singleplaybutton, BorderLayout.CENTER);
		this.setLayout( new FlowLayout() );
	}

	class myPanel extends JPanel{
		public void paint(Graphics g){
			g.drawImage(img, 0, 0, null);
		}
	}

	public static void main(String[] args) {
		new Main();
		while(true){
			System.out.println(num);
			if(num==1){
				client = new Client();
				tetris = new Tetris(client);
				tetris.startGame();
				multi = new MultiPlay(client);
			}
		}
	}
}
