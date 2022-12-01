package demo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Demo {
	private int WIDTH=1080, HEIGHT = 780;
	private int count_1p=0, count_2p=0;
	
	JFrame frame;
	JPanel introPage = new ExPanel();
	JPanel mainPage = new MainPanel();
	//ImageIcon btImage = new ImageIcon("../images/buttonImage.png");
	JButton button = new JButton("시작하기");
	JLabel txt1 = new JLabel(String.valueOf(count_1p));
	JLabel txt2 = new JLabel(String.valueOf(count_2p));
	
	public Demo() {
		//frame
		frame = new JFrame("Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		//panel
		frame.getContentPane().add(introPage);//인트로 화면 보여주기
		introPage.setLayout(null);
		button.setBounds(100,100,300,90);
		introPage.add(button);
		frame.addKeyListener(new GameListener());
		toMain();
		//label
		txt1.setHorizontalAlignment(JLabel.CENTER);
		txt2.setHorizontalAlignment(JLabel.CENTER);
		mainPage.add(txt1);
		mainPage.add(txt2);
		txt1.setBounds(300, 500, 30, 30);
		txt2.setBounds(800, 500, 30, 30);
		
		
		//mainPage.setVisible(false);
		frame.setVisible(true);
	}
	/*
	 키보드 이벤트처리 + 이펙트 효과 + 시작화면 수정?
	 */
	public void go() {
		txt1.setText(String.valueOf(count_1p));
		txt2.setText(String.valueOf(count_2p));
		frame.repaint();
	}
	
	class ExPanel extends JPanel{
		Image introBackground = new ImageIcon(Demo.class.getResource("../images/introImage.jpg")).getImage();
		public void paintComponent(Graphics g) {
			g.drawImage(introBackground, 0, 0, null);
		}
	}
	class MainPanel extends JPanel{ //게임을 시작할 화면
		Image mainBackground = new ImageIcon(Demo.class.getResource("../images/mainImage.png")).getImage();
		public void paintComponent(Graphics g) {
			g.drawImage(mainBackground, 0, 0, null);
		}
	}
	class GameListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				count_1p++;
				break;
				
			case KeyEvent.VK_ENTER:
				count_2p++;
				break;
				
			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void toMain() {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				introPage.setVisible(false);
				frame.getContentPane().add(mainPage);
				mainPage.setLayout(null);
			}
		});
	}
	
	 
}
