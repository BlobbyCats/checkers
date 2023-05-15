//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameScreen extends JFrame implements ActionListener {
	Font plFont = new Font("Courier", Font.BOLD, 20);
	static String p1 = "";
	static String p2 = "";
	static int gameNum = 1;
	static int p1Wins = 0;
	static int p2Wins = 0;
	String p1Color = "";
	String p2Color = "";
	int move = 1;
	boolean isP1Turn = false;
	boolean isP2Turn = false;

	JButton resign = new JButton("Resign");
	JButton draw = new JButton("Draw");
	JButton undo = new JButton("Undo");

	JButton board = new JButton("Board");

	JButton rules = new JButton("Rules");

	JButton home = new JButton();

	JLabel game = new JLabel("Game #" + gameNum);
	JLabel turn = new JLabel("It is " + "\'s turn.");
	JLabel toPlay = new JLabel(" to play!");

	public GameScreen(String title, String player1, String player2, int gNum, int player1Wins, int player2Wins) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(800, 500);

		p1 = player1;
		p2 = player2;
		gameNum = gNum;
		game = new JLabel("Game #" + gameNum);
		p1Wins = player1Wins;
		p2Wins = player2Wins;
		
		pickColors();
		updateTurn();

		add(resign);
		add(draw);
		add(undo);
		add(home);
		add(rules);
		add(game);
		add(turn);
		add(toPlay);

		rescaleImage("homeIcon.png", home, 55, 47);
		home.setFocusPainted(false);

		layout.putConstraint(SpringLayout.WEST, home, 20, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, home, 20, SpringLayout.NORTH, this);

		resign.setPreferredSize(new Dimension(250, 50));

		layout.putConstraint(SpringLayout.WEST, resign, 500, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, resign, 250, SpringLayout.NORTH, this);

		draw.setPreferredSize(new Dimension(250, 50));

		layout.putConstraint(SpringLayout.WEST, draw, 500, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, draw, 300, SpringLayout.NORTH, this);

		undo.setPreferredSize(new Dimension(250, 50));

		layout.putConstraint(SpringLayout.WEST, undo, 500, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, undo, 350, SpringLayout.NORTH, this);

		rules.setPreferredSize(new Dimension(150, 40));

		layout.putConstraint(SpringLayout.WEST, rules, 620, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, rules, 20, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, game, 600, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, game, 100, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, turn, 580, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, turn, 150, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, toPlay, 580, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, toPlay, 200, SpringLayout.NORTH, this);

		resign.addActionListener(this);
		draw.addActionListener(this);
		undo.addActionListener(this);
		home.addActionListener(this);
		rules.addActionListener(this);

		resign.setActionCommand("resign");
		draw.setActionCommand("draw");
		undo.setActionCommand("undo");
		home.setActionCommand("home");
		rules.setActionCommand("rules");
	}
	public void updateTurn() {
		if ((move % 2) == 1) {
			toPlay = new JLabel("Black to play!");
			if (p1Color == "black") {
				turn = new JLabel("It is " + p1 + "\'s turn.");
				isP1Turn = true;
				isP2Turn = false;
			}
			else {
				turn = new JLabel("It is " + p2 + "\'s turn.");
				isP2Turn = true;
				isP1Turn = false;
			}
		}
		else {
			toPlay = new JLabel("Red to play!");
			if (p1Color == "black") {
				turn = new JLabel("It is " + p2 + "\'s turn.");
				isP2Turn = true;
				isP1Turn = false;
			}
			else {
				turn = new JLabel("It is " + p1 + "\'s turn.");
				isP1Turn = true;
				isP2Turn = false;
			}
		}
	}
	public void pickColors() {
		int rand = (int)(Math.random() * 2);
		if (rand == 0) {
			p1Color = "black";
			p2Color = "red";
		}
		else {
			p2Color = "black";
			p1Color = "red";
		}
	}
	public void rescaleImage(String fileName, JButton button, int width, int height) {
		ImageIcon icon = new ImageIcon(fileName);
		Image img = icon.getImage();
		img = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		button.setIcon(icon);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("resign")) {
			int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to resign?", "Message", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				if (isP1Turn) {
					p2Wins++;
					System.out.println(p2 + p2Wins);
				}
				else {
					p1Wins++;
					System.out.println(p1 + p1Wins);
				}
			}

		}
		if (e.getActionCommand().equals("draw")) {
			int n = JOptionPane.showConfirmDialog(this, "Are you sure you want a draw?", "Message", JOptionPane.YES_NO_OPTION);
		}
		if (e.getActionCommand().equals("undo")) {
			int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to undo your move?", "Message", JOptionPane.YES_NO_OPTION);
		}
		if (e.getActionCommand().equals("rules")) {
			Rule rule = new Rule();
			this.setVisible(false);
			rule.setSize(this.getWidth(), this.getHeight());
			rule.setVisible(true);
		}
		if (e.getActionCommand().equals("home")) {
			HomePage homepage = new HomePage();
			this.setVisible(false);
			homepage.setSize(this.getWidth(), this.getHeight());
			homepage.setVisible(true);
		}
	}
	public static void main (String[] args) {
		GameScreen game = new GameScreen("Checkers!", "Seraphina", "Bagasanthi", 2, 40, 23);
		game.setSize(800, 500);
		game.setVisible(true);
	}
}

