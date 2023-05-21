import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author ruthwika
 *
 */

public class GameScreen extends JFrame implements ActionListener {
	Font plFont = new Font("Courier", Font.BOLD, 20);
	Player p1;
	Player p2;
	private static int gameNum = 1;
	private int move = 1;
	private boolean isP1Turn = false;
	private boolean isP2Turn = false;
	private String whoWins = "";

	Board board;

	JButton resign = new JButton("Resign");
	JButton draw = new JButton("Draw");
	JButton undo = new JButton("Undo");

	JButton rules = new JButton("Rules");

	JButton home = new JButton();

	JLabel game = new JLabel("Game #" + gameNum);
	JLabel turn = new JLabel("It is " + "\'s turn.");
	JLabel toPlay = new JLabel(" to play!");
	JLabel p1title = new JLabel();
	JLabel p2title = new JLabel();

	public GameScreen(String title, String player1, String player2, int gNum, int player1Wins, int player2Wins) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		setSize(800, 500);

		p1 = new Player(player1, player1Wins, "");
		p2 = new Player(player2, player2Wins, "");

		gameNum = gNum;
		game = new JLabel("Game #" + gameNum);

		p1title = new JLabel(p1.getName());
		p2title = new JLabel(p2.getName());

		pickColors();
		updateTurn();

		board = new Board(p1.getName(), p2.getName(), gameNum, p1.getWins(), p2.getWins(), p1.getColor(), p2.getColor());

		add(resign);
		add(draw);
		add(undo);
		add(home);
		add(rules);
		add(game);
		add(turn);
		add(toPlay);
		add(board);
		add(p1title);
		add(p2title);

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

		layout.putConstraint(SpringLayout.WEST, turn, 575, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, turn, 150, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, toPlay, 585, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, toPlay, 200, SpringLayout.NORTH, this);

		board.setPreferredSize(new Dimension(260, 260));

		layout.putConstraint(SpringLayout.WEST, board, 110, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, board, 130, SpringLayout.NORTH, this);

		if (p1.getColor().equals("black")) {
			layout.putConstraint(SpringLayout.WEST, p1title, 140, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, p1title, 100, SpringLayout.NORTH, this);

			layout.putConstraint(SpringLayout.WEST, p2title, 140, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, p2title, 400, SpringLayout.NORTH, this);
		}
		else {
			layout.putConstraint(SpringLayout.WEST, p1title, 140, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, p1title, 400, SpringLayout.NORTH, this);

			layout.putConstraint(SpringLayout.WEST, p2title, 140, SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.NORTH, p2title, 100, SpringLayout.NORTH, this);
		}

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

		getContentPane().setBackground(Colors.GREEN);
		game.setForeground(Color.WHITE);
		turn.setForeground(Color.WHITE);
		toPlay.setForeground(Color.WHITE);
		p1title.setForeground(Color.WHITE);
		p2title.setForeground(Color.WHITE);
	}
	public void updateTurn() {
		if ((move % 2) == 1) {
			toPlay = new JLabel("Black to play!");
			if (p1.getColor() == "black") {
				turn = new JLabel("It is " + p1.getName() + "\'s turn.");
				isP1Turn = true;
				isP2Turn = false;
			}
			else {
				turn = new JLabel("It is " + p2.getName() + "\'s turn.");
				isP2Turn = true;
				isP1Turn = false;
			}
		}
		else {
			toPlay = new JLabel("Red to play!");
			if (p1.getColor() == "black") {
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
			p1.setColor("black");
			p2.setColor("red");
		}
		else {
			p2.setColor("black");
			p1.setColor("red");
		}
	}
	public boolean getP1Turn() {
		return isP1Turn;
	}
	public boolean getP2Turn() {
		return isP2Turn;
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
					whoWins = "p2";
					p2.incrementWins();
					FinalScreen f = new FinalScreen(gameNum, p1.getWins(), p2.getWins(), p1.getName(), p2.getName(), whoWins, p1.getColor(), p2.getColor());
					this.setVisible(false);
				}
				else {
					whoWins = "p1";
					p1.incrementWins();
					FinalScreen f = new FinalScreen(gameNum, p1.getWins(), p2.getWins(), p1.getName(), p2.getName(), whoWins, p1.getColor(), p2.getColor());
					this.setVisible(false);
				}
			}

		}
		if (e.getActionCommand().equals("draw")) {
			int n = JOptionPane.showConfirmDialog(this, "Are you sure you want a draw?", "Message", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				whoWins = "neither";
				FinalScreen f = new FinalScreen(gameNum, p1.getWins(), p2.getWins(), p1.getName(), p2.getName(), whoWins, p1.getColor(), p2.getColor());
				this.setVisible(false);
			}
		}
		if (e.getActionCommand().equals("undo")) {
			int n = JOptionPane.showConfirmDialog(this, "Are you sure you want to undo your move?", "Rules", JOptionPane.YES_NO_OPTION);
		}
		if (e.getActionCommand().equals("rules")) {
			JOptionPane.showMessageDialog(this, "<html> <pre> 1. Checkers is a board game played between 2 people on an 8x8 board. "
			+ "<pre> 2. Each person had 12 pieces." + " <pre> 3. Darker color goes first." +
			"<pre> 4. Pieces are always moved diagonally" +
			" <pre>    a. Pawns can only be moved forward - diagonally <pre>" +
			"    b. Kings can be moved backwards <pre>"+ "5. A King can be made by moving a pawn to the opposite side of the board"


			+ "<pre>6. To capture the opponent pieces your pieces leaps over one of the opponent <pre> pieces and land in straight  diagonal line on the other sides"
			+ "7. If neither player has legal moves, then it is a draw <pre>"
			+ "8. You win the game when the opponent has no more pieces or cannot move"
			+ " </html>", "Message", JOptionPane.OK_OPTION);
		}
		if (e.getActionCommand().equals("home")) {
			HomePage homepage = new HomePage();
			this.setVisible(false);
			homepage.setSize(this.getWidth(), this.getHeight());
			homepage.setVisible(true);
		}
	}
}

