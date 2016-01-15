package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUIGamePanel extends JPanel {
	private String pressedKey;
	private int hangmanStage;

	public GUIGamePanel(){
		super();
		KeyListener listener = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
				String key=KeyEvent.getKeyText(e.getKeyCode());
				switch (key){
				case "Shift":
				case "Windows":
				case "Ctrl":
				case "Alt":
				case "Caps Lock":
				case "Space":
				case "Comma":
				case "0":
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "9":
				case "8":
				case "Minus":
				case "Equals":
				case "Backspace":
				case "Open Bracket":
				case "Close Bracket":
				case "Semicolon":
				case "Quote":
				case "Slash":
				case "Back Slash":
				case "Alt Graph":
				case "Context Menu":

					return;
				default:
					pressedKey= key;
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}

	public String getPressedKey(){
		return pressedKey;
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		super.setSize(new Dimension (364,364));
		g.setColor(java.awt.Color.WHITE);
		g.fillRect(0, 0, 300, 300);
		drawHangman(hangmanStage,g);
		g.setColor(java.awt.Color.GRAY);
		g.drawLine(0, 0, 0, 300);
		g.drawLine(0, 0, 300, 0);
		g.drawLine(300,0, 300, 300);
		g.drawLine(0,300,300,300);
		g.setColor(java.awt.Color.BLUE);
		
		//Draw Hangman 
		g.fillRect(0,150 , 4, 150);
		g.fillRect(0, 0, 4, 150);
		g.fillRect(0, 0, 180, 4);
		g.setColor(java.awt.Color.RED);
		g.fillRect(180, 0, 4, 120);
		
	}

	public void drawHangman(int stage, Graphics g){
		g.setColor(java.awt.Color.BLUE);
		switch(stage){
		case 1:
			g.fillRect(0,150 , 4, 300);
		case 2:
			g.fillRect(0, 0, 4, 150);
		case 3:
			g.fillRect(0, 0, 180, 4);
		case 4:
			g.fillRect(180, 0, 4, 80);
		case 5:
			g.fillRect(180,80,8,40);
		case 6:
			g.setColor(java.awt.Color.GREEN);
			g.fillRect(0, 250, 300, 50);
			g.setColor(java.awt.Color.BLUE);
		case 7:
			g.setColor(java.awt.Color.RED);
			g.fillRect(100, 200, 100, 20);
			g.setColor(java.awt.Color.BLUE);
		case 8:
			g.fillOval(180, 120, 80, 80);
			g.setColor(java.awt.Color.WHITE);
			g.fillOval(200, 140, 40, 40);
			g.setColor(java.awt.Color.BLUE);
		}
	}

	public void setHangmanStage(int newHangmanStage) {
		hangmanStage = newHangmanStage;

	}



}
