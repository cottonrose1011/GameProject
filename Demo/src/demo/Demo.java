package demo;

import java.awt.Font;
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
	private int count_1p=0, count_2p=0, start = 0, timer = 16;
	
	JFrame frame;
	JPanel Page = new GamePanel();
	//ImageIcon btImage = new ImageIcon("../images/buttonImage.png");
	JButton button = new JButton("게임시작");
	JLabel txt1 = new JLabel(String.valueOf(count_1p));
	JLabel txt2 = new JLabel(String.valueOf(count_2p));
	JLabel timerText = new JLabel(String.valueOf(timer));
	
	GameTimer gameTimer = new GameTimer();
	Image background;


	public Demo() {
		//frame
		frame = new JFrame("Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		//panel
		background =new ImageIcon(Demo.class.getResource("../images/introImage.jpg")).getImage();
		frame.getContentPane().add(Page);//인트로 화면 보여주기
		Page.setLayout(null);
		button.setBounds(650,500,300,90);
		Page.add(button);
		toMain();
		frame.addKeyListener(new GameListener());
		frame.setFocusable(true);
		//label
		txt1.setHorizontalAlignment(JLabel.CENTER);
		txt2.setHorizontalAlignment(JLabel.CENTER);
		timerText.setHorizontalAlignment(JLabel.CENTER);
		
		timerText.setFont(new Font("Serif", Font.ITALIC, 50));
		txt1.setBounds(300, 500, 90, 90);//1p의 count
		txt2.setBounds(800, 500, 90, 90);//2p의 count
		timerText.setBounds(520, 100, 70, 70);//timer의 count
		frame.setVisible(true);
	}
	public void go() {
		while(true) {
			if(count_1p == count_2p) {
				txt1.setFont(new Font("Gothic", Font.PLAIN, 50));
				txt2.setFont(new Font("Gothic", Font.PLAIN, 50));
			}
			if(count_1p > count_2p) {
				txt1.setFont(new Font("Gothic", Font.PLAIN, 80));
				txt2.setFont(new Font("Gothic", Font.PLAIN, 40));
			}
			if(count_1p < count_2p) {
				txt2.setFont(new Font("Gothic", Font.PLAIN, 80));
				txt1.setFont(new Font("Gothic", Font.PLAIN, 40));
			}
			if(start == 1) gameTimer.run(); // 게임 시작하면 timer 가동
		}
	}
	
	class GamePanel extends JPanel{
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.drawImage(background, 0, 0, null);
			this.repaint();
		}
	}
	class GameListener implements KeyListener{
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			switch (e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				count_1p++;
				txt1.setText(String.valueOf(count_1p));
				frame.repaint();
				break;
				
			case KeyEvent.VK_ENTER:
				count_2p++;
				txt2.setText(String.valueOf(count_2p));
				frame.repaint();
				break;
				
			default:
				break;
			}
		}
		@Override
		public void keyTyped(KeyEvent e) {}
		@Override
		public void keyReleased(KeyEvent e) {}
	}
	
	class GameTimer extends Thread { //timer thread
		@Override
		public void run() {
			for(int i=15; i>=1; i--) {
				timer--;
				timerText.setText(String.valueOf(timer));
				frame.repaint();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
	}
	}
	public void toMain() {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				start = 1;
				button.setVisible(false);
				background = new ImageIcon(Demo.class.getResource("../images/mainImage.png")).getImage();
				Page.add(txt1);
				Page.add(txt2);
				Page.add(timerText);
			}

		});
	}
	
	 
}
