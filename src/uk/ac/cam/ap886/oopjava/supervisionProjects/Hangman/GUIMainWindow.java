package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class GUIMainWindow implements UserInterface{
	Game game;
	boolean firstRun=true;
	
	protected JLabel lblName;
	protected JLabel lblGamesWon;
	protected JLabel lblLettersTried;
	protected JLabel openedWord;
	protected JLabel lblStatus;
	protected GUIGamePanel hangmanPanel;

	public GUIMainWindow (Game newGame){
		game = newGame;
		initialize();
	}

	private JFrame frame;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GUIMainWindow window = new GUIMainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 489, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setMinimumSize(new Dimension (364,364));

		JPanel statsPanel = new JPanel();
		statsPanel.setMinimumSize(new Dimension(200, 400));
		statsPanel.setIgnoreRepaint(true);
		statsPanel.setFocusable(false);
		statsPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		statsPanel.setLayout(null);
		frame.getContentPane().add(statsPanel);

		JLabel lblPlayerStats = new JLabel("Player Stats:");
		lblPlayerStats.setBounds(29, 12, 195, 15);
		statsPanel.add(lblPlayerStats);

		//JLabel lblName = new JLabel(this.playerName());
		lblName = new JLabel ("PlayerName");
		lblName.setBounds(29, 39, 195, 15);
		statsPanel.add(lblName);

		//JLabel lblGamesWon = new JLabel("GamesWon");
		lblGamesWon = new JLabel("GamesWon/GamesLost");
		lblGamesWon.setBounds(29, 66, 195, 15);
		statsPanel.add(lblGamesWon);

		JLabel lblWrongLetters = new JLabel("Wrong Letters");
		lblWrongLetters.setBounds(29, 148, 169, 15);
		statsPanel.add(lblWrongLetters);

		lblLettersTried = new JLabel("<Letters Here>");
		lblLettersTried.setText("<html><p style=\"width:120px\">"+"a, b, c, d, e, f, g, h, i, j, k, l, m, n"+"</p></html>");
		lblLettersTried.setBounds(29, 175, 169, 60);
		statsPanel.add(lblLettersTried);

		openedWord = new JLabel("- - - - - - ");
		openedWord.setBounds(29, 121, 182, 15);
		statsPanel.add(openedWord);

		lblStatus = new JLabel("<Status>");
		lblStatus.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblStatus.setBounds(12, 304, 212, 15);
		statsPanel.add(lblStatus);
		
		separator = new JSeparator();
		separator.setBounds(29, 96, 195, 13);
		statsPanel.add(separator);

		hangmanPanel = new GUIGamePanel();
		frame.getContentPane().add(hangmanPanel);
	}

	@Override
	public String playerName() {
		String s = JOptionPane.showInputDialog(frame,"Enter a Player's Name. If one exists, will be loaded from file.","Player Selection/Creation",	JOptionPane.PLAIN_MESSAGE);
		return s;

	}

	@Override
	public void status() {
		lblLettersTried.setText(game.getGuessedLetters().toString());
		openedWord.setText(game.getOpened());
		hangmanPanel.setHangmanStage(game.getHangmanStage());
		hangmanPanel.repaint();
		return;
		//Useless in terms of GUI;

	}

	@Override
	public boolean continuePrompt() {
		if(firstRun){
			firstRun = false;
			this.frame.setVisible(true);
			lblName.setText(game.getPlayer().getName());
			lblGamesWon.setText(game.getPlayer().getScore().getGamesWon()+"/"+game.getPlayer().getScore().getGamesPlayed());
			lblStatus.setText("Welcome "+game.getPlayer().getName());
			return true;
		}else{
		return JOptionPane.showConfirmDialog(frame,"You've "+(game.hasWon()?"won.":"lost.")+"\nThe Word was "+game.getRightWord()+ "\nWould you Like to Quit?")==1;
		//TODO fix integer Assignments
		}
	}

	@Override
	public char guessPrompt() {
		String keyStroke=hangmanPanel.getPressedKey();
		if(keyStroke==null){
			return 0;
		}else{
			keyStroke=keyStroke.toLowerCase().trim();
		}
		return keyStroke.toCharArray()[0];
	}

	@Override
	public void wrongGuess() {
		lblStatus.setText("Sorry, Wrong Guess");
		drawHangman(game.getHangmanStage());

	}

	

	@Override
	public void rightGuess() {
		lblStatus.setText("Good Guess");

	}

	@Override
	public void repeatedGuess() {
		lblStatus.setText("Waiting for (unique) Keyboard Input.");

	}

	@Override
	public void winPrompt() {
		lblStatus.setText("You've Won");

	}

	@Override
	public void losePrompt() {
		lblStatus.setText("You've Lost");

	}

	@Override
	public void greet(Player player) {
		JOptionPane.showConfirmDialog(frame,"Welcome "+(game.getPlayer().isNew()?"":"back ")+game.getPlayer().getName()+".","Player Selection/Creation",	JOptionPane.PLAIN_MESSAGE);

	}
	
	private void drawHangman(int hangmanStage) {
		// TODO Auto-generated method stub
		
	}
}
