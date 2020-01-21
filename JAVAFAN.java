
package lalala;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

class Wind extends JPanel {
	int i = 0;
	public void paint(Graphics p){
		super.paint(p);
		int x1 = getWidth() / 2;
		int y1 = getHeight() / 2;
		int a = (int) (Math.min(getWidth(), getHeight() * 0.4));
		int x = x1 - a;
		int y = y1 - a;
		p.setColor(Color.white);
		p.fillArc(x, y, 2 * a, 2 * a, i, 40);
		p.setColor(Color.ORANGE);
		p.fillArc(x, y, 2 * a, 2 * a, i + 90, 40);
		p.setColor(Color.white);		
		p.fillArc(x, y, 2 * a, 2 * a, i + 180, 40);
		p.setColor(Color.ORANGE);
		p.fillArc(x, y, 2 * a, 2 * a, i + 270, 40);
	}
}

public class hhh extends JFrame implements ActionListener {
	static int time;
	static Wind p = new Wind();
	Timer timer = new Timer(100, this);
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	static Scanner scan = new Scanner(System.in);
	JFrame frame = new JFrame("HONG牌电风扇");
	JButton dang1 = new JButton("一档");
	JButton dang2 = new JButton("二档");
	JButton dang3 = new JButton("三档");
	JButton stop = new JButton("停止");
	Redreaw q = new Redreaw();
	static final int X = 700;
	static final int Y = 700;
	public hhh() {
		frame.setSize(X, Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dang1.addActionListener(new JBB());
		dang2.addActionListener(new JBB());
		dang3.addActionListener(new JBB());
		stop.addActionListener(new JBB());
		panel.add(p);
		panel.add(dang1);
		panel.add(dang2);
		panel.add(dang3);
		panel.add(stop);
		frame.add(panel, BorderLayout.SOUTH);
		frame.add(p);
		frame.setVisible(true);
		frame.setLocation(450, 50);
		timer = new Timer(35, q);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
	}
	// 调整转速
	
	class JBB implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == dang1) {
			timer.start();
			time = 10;
			} 
			else if (e.getSource() == dang2){
			timer.start();
			time = 20;
			}
			else if (e.getSource() == dang3){
			timer.start();
			time = 30;
			} 
			else if(e.getSource() == stop){
			time = 0;
			}
		}
	}
		public static void main(String[] args){
			new hhh();
		}	// 重绘
		
	class Redreaw extends JFrame implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			p.i += time;
			p.repaint();
		}
	 }
}


	


