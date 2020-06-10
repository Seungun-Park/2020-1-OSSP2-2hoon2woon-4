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
import java.awt.Toolkit;
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
	ImageIcon start1 = new ImageIcon("C:/git/2020-1-OSSP2-2hoon2woon-4-3/Client/src/hoon2woon2/Images/start1.jpg");
	ImageIcon start2 = new ImageIcon("C:/git/2020-1-OSSP2-2hoon2woon-4-3/Client/src/hoon2woon2/Images/start2.jpg");


	public Main(){
		this.setTitle("Tetris main");// 제목
		// Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		// int w = (int)((dimen.getWidth()) / 2.5);
		// int h = (int)((dimen.getHeight()) / 1.5);

		this.setSize(640,680);
		this.setVisible(true);// 생성
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this.setResizable(false);
		this.setLocationRelativeTo(null);

		try {
			img = ImageIO.read(new File("C:/git/2020-1-OSSP2-2hoon2woon-4-3/Client/src/hoon2woon2/Images/Main_Image.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No Image");
			System.exit(0);	
		}
		myPanel panel = new myPanel();
		panel.setBounds(0, 0, 640, 640);

		JButton singleplaybutton = new JButton("");		
		MyMouseListener listener = new MyMouseListener();
		singleplaybutton.setHorizontalAlignment(JButton.CENTER);
		singleplaybutton.setIcon(start1);
		singleplaybutton.setVisible(true);
		singleplaybutton.addMouseListener(listener);
		singleplaybutton.setBorderPainted(false);
		singleplaybutton.setFocusPainted(false);

		singleplaybutton.addActionListener(new ActionListener() {

		   @Override
			public void actionPerformed(ActionEvent e) {
				num = 1;
				dispose();
				System.out.println(num);
		   }
		});
		
		this.setLayout( new BorderLayout() );
		panel.setLayout( new FlowLayout() );
		panel.add(singleplaybutton);
		this.add(panel);
		this.setVisible(true);
		panel.setVisible(true);
	}

	class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			b.setIcon(start1);
			b.setVisible(true);
		}
	
		@Override
		public void mousePressed(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			b.setIcon(start1);
			b.setVisible(true);
		}
	
		@Override
		public void mouseReleased(MouseEvent e) {
		}
	
		@Override//마우스가 버튼 안으로 들어오면 빨간색으로 바뀜
		public void mouseEntered(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			b.setIcon(start2);
			b.setVisible(true);
		}
	
		@Override//마우스가 버튼 밖으로 나가면 노란색으로 바뀜
		public void mouseExited(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			b.setIcon(start1);
			b.setVisible(true);
		}
		
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
