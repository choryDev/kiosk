package payDialog;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

import javax.swing.JPanel;

public class SignDrawer extends JPanel {
	Vector<Point> vStart = new Vector<Point>();
	public SignDrawer() {
		addKeyListener(new KeyListener() {
	@Override
	public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER:
			vStart.removeAllElements();
			repaint();
			break;
				}
			}
	});
		
	addMouseMotionListener(new MouseMotionAdapter() {
		public void mouseDragged(MouseEvent e) { 
			vStart.add(e.getPoint());
			repaint();
		}
	});

	// 마우스 이벤트 처리
	addMouseListener(new MouseAdapter() {
		// 마우스를 누르면 호출된다.
		public void mousePressed(MouseEvent e) {
		vStart.add(null);
		vStart.add(e.getPoint());
		}
	});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
			for (int i = 1; i < vStart.size(); i++) {
				if (vStart.get(i - 1) == null)
					continue;
				else if (vStart.get(i) == null)
					continue;
				else
				g.drawLine((int) vStart.get(i - 1).getX(), (int) vStart.get(i - 1).getY(),
				(int) vStart.get(i).getX(), (int) vStart.get(i).getY());
				}	
		}
	}