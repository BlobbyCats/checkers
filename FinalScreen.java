import java.awt.* ;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

/**
 * @author Eileen
 */

public class FinalScreen extends JFrame implements ActionListener{
	Font plFont = new Font("Verdana", Font.PLAIN, 16);
	private int gameN;

	Player p1;
	Player p2;
	
	JButton home = new JButton();
	JButton close = new JButton("Exit");
	JButton rematch = new JButton("Rematch");
	JButton reset = new JButton("Reset");

	JLabel p1title = new JLabel();
	JLabel p2title = new JLabel();
	
	JLabel gameNum = new JLabel(); //Game #
	
	JLabel p1Name = new JLabel();
	JLabel p2Name = new JLabel();
	JLabel message = new JLabel();
	JLabel score = new JLabel(); // Scoreboard: 
	
	JLabel p1Score = new JLabel();
	JLabel p2Score = new JLabel();

	Board b2;
	
/**
 * Creates a FinalScreen window displaying the board and a message specifying the victor
 * or whether no one wins
 * 
 * @param gNum - num of how many games have been played including the current game
 * @param score1 - player one's number of wins
 * @param score2 - player two's number of wins
 * @param n1 - player one's name
 * @param n2 - player two's name
 * @param whoWins - string containing which player wins, or if neither wins 
 */
	public FinalScreen(int gNum, int score1, int score2, String n1, String n2, String whoWins, String p1Color, String p2Color) {
		gameN = gNum; 
		p1 = new Player(n1, score1, p1Color);
		p2 = new Player(n2, score2, p2Color);
		b2 = new Board(p1.getName(), p2.getName(), gameN, p1.getWins(), p2.getWins(), p1.getColor(), p2.getColor(), null);
		p1title.setText(n1);
		p1title.setForeground(Color.white);
		p2title.setText(n2);
		p2title.setForeground(Color.white);

		if (p1.getColor().equals("black")) {
			p1title.setBounds(150, 95, 100, 20);
			add(p1title);

			p2title.setBounds(150, 400, 100, 20);
			add(p2title);
		}
		else {
			p2title.setBounds(150, 95, 100, 20);
			add(p2title);

			p1title.setBounds(150, 400, 100, 20);
			add(p1title);
		}
		
        ImageIcon icon = new ImageIcon("homeIcon.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		home.setIcon(icon);
		//home.setBorder(null);
		home.setBackground(null);

		home.setActionCommand("home");
		close.setActionCommand("close");
		rematch.setActionCommand("rematch");
		reset.setActionCommand("reset");

		home.addActionListener(this);
		close.addActionListener(this);
		rematch.addActionListener(this);
		reset.addActionListener(this);
		
		home.setBounds(20, 20, 40, 30);
		home.setMargin(new Insets(0, 0, 0, 0));
		add(home);
		
		close.setBounds(20, 70, 60, 30);
		close.setMargin(new Insets(0, 0, 0, 0));
		add(close);
		
		rematch.setBounds(540, 310, 160, 50);
		rematch.setMargin(new Insets(0, 0, 0, 0));
		add(rematch);
		
		reset.setBounds(540, 380, 160, 50);
		reset.setMargin(new Insets(0, 0, 0, 0));
		add(reset);

		gameNum.setText("Game #" + gameN);
		gameNum.setForeground(Color.white);
        gameNum.setBounds(590, 20, 160, 50);
        add(gameNum);
		score.setText("Scoreboard:");
		score.setForeground(Color.white);
        score.setBounds(580, 70, 160, 50);
        add(score);

		if (whoWins == "p1") {
			message.setText("Congratulations, " + p1.getName() + "! You win!");

			ImageIcon catto = new ImageIcon("partycatcropped.gif");
        	JLabel winCat = new JLabel();
        	winCat.setIcon(catto);
        	winCat.setBounds(525, 190, 300, 100);
        	add(winCat);
		}
		else if (whoWins == "p2") {
			message.setText("Congratulations, " + p2.getName() + "! You win!");
			JLabel winCat2 = new JLabel();
			winCat2.setIcon(new ImageIcon("catk2.gif"));
			winCat2.setBounds(500, 190, 300, 110);
			add(winCat2);
		}
		else {
			message.setText("No one wins!");
			JLabel tie = new JLabel();
			tie.setIcon(new ImageIcon("tiecat2.gif"));
			tie.setBounds(500, 190, 300, 110);
			add(tie);
		}
		message.setForeground(Color.white);
		message.setBounds(520, 150, 500, 50);
		add(message);

		p2Name.setText("p2: " + p2.getName()); 
		p2Name.setForeground(Color.white);
        p2Name.setBounds(630, 100, 100, 50);
        add(p2Name);
		p1Name.setText("p1: " + p1.getName()); 
		p1Name.setForeground(Color.white);
        p1Name.setBounds(520, 100, 100, 50);
        add(p1Name);
		
		p1Score.setText("" + p1.getWins());
        p1Score.setBounds(520, 120, 200, 50);
		p1Score.setForeground(Color.white);
        add(p1Score);
		p2Score.setText("" + p2.getWins());
		p2Score.setForeground(Color.white);
        p2Score.setBounds(630, 120, 200, 50);
        add(p2Score);

		b2.setBounds(110, 130, 260, 260);
		add(b2);
		
		setLayout(null);
		setSize(800, 500);
		setResizable(false);
		getContentPane().setBackground(Colors.GREEN);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	/**
	 * Switches to the home page when the home button or reset button is clicked, game page when the rematch button is clicked, and exits the program if the exit button is clicked
	 * @param evt - ActionEvent that occurs when a user clicks on a JButton
	 */
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("home") || 
            evt.getActionCommand().equals("reset")) {
			HomePage h1 = new HomePage();
            h1.setVisible(false);
            h1.setSize(this.getWidth(), this.getHeight());
			h1.setVisible(true);

		}
		if (evt.getActionCommand().equals("close")) {
			System.exit(0);
		}
		if (evt.getActionCommand().equals("rematch")) {
			gameN++;
            GameScreen g1 = new GameScreen("checkers", p1.getName(), 
            p2.getName() , gameN, p1.getWins(), p2.getWins()); 
            g1.setVisible(true);
			this.setVisible(false);

		}
	}
}
