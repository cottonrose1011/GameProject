package demo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Demo {
	private int WIDTH=1080, HEIGHT = 780;
	private int count_1p=0, count_2p=0;
	
	JFrame frame;
	JPanel introPage = new ExPanel();
	JPanel mainPage = new MainPanel();
	ImageIcon btImage = new ImageIcon("../images/buttonImage");
	JButton button = new JButton(btImage); // 시작버튼 사이즈 씹힙. 수정해야함.
	
	public Demo() {
		//frame
		frame = new JFrame("Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
		//panel
		frame.getContentPane().add(introPage);//intro 화면 보여주기
		introPage.add(button);
		button.setBounds(0,0,300,180);
		toMain();
		
		//mainPage.setVisible(false);
		frame.setVisible(true);
	}
	
	public void go() {
		
	}
	
	class ExPanel extends JPanel{
		Image introBackground = new ImageIcon(Demo.class.getResource("../images/introImage.jpg")).getImage();
		public void paintComponent(Graphics g) {
			g.drawImage(introBackground, 0, 0, null);
		}
	}
	class MainPanel extends JPanel{
		Image mainBackground = new ImageIcon(Demo.class.getResource("../images/mainImage.png")).getImage();
		public void paintComponent(Graphics g) {
			g.drawImage(mainBackground, 0, 0, null);
		}
	}
	
	public void toMain() {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				introPage.setVisible(false);
				frame.getContentPane().add(mainPage);
				mainPage.setVisible(true);
			}
		});
	}
	 
}
