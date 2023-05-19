
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
    private String name1; //will be something like getName()
    private String name2;
	private int gScore1;
	private int gScore2;
	
	JButton home = new JButton();
	JButton close = new JButton("exit");
	JButton rematch = new JButton("rematch");
	JButton reset = new JButton("reset");

	JLabel p1title = new JLabel();
	JLabel p2title = new JLabel();
	
	JLabel gameNum = new JLabel(); //game #
	
	JLabel p1Name = new JLabel();
	JLabel p2Name = new JLabel();
	JLabel message = new JLabel();
	JLabel score = new JLabel();
	
	JLabel p1Score = new JLabel();
	JLabel p2Score = new JLabel();
	
	JPanel info = new JPanel();

	Board b2 = new Board();
	
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
		gameN = gNum; //would be set to game number taken from actual game
		gScore1 = score1;
		gScore2 = score2;
        name1 = n1;
        name2 = n2;
		p1title.setText(n1);
		p2title.setText(n2);

		if (p1Color.equals("black")) {
			p1title.setBounds(100, 20, 50, 20);
			add(p1title);
		}
		else {
			p2title.setBounds(100, 380, 50, 20);
			add(p2title);
		}
		
        ImageIcon icon = new ImageIcon("homeIcon.png");
		Image img = icon.getImage();
		img = img.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(img);
		home.setIcon(icon);
		//home.setBorder(null);
		home.setBackground(null);

        /*ImageIcon icon2 = new ImageIcon("exit.png");
		Image img2 = icon2.getImage();
		img2 = img2.getScaledInstance(40, 30, java.awt.Image.SCALE_SMOOTH);
		icon2 = new ImageIcon(img2);
		close.setIcon(icon2);
        close.setBorder(null);
        close.setBackground(null);*/

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
		
		close.setBounds(20, 70, 40,30);
		close.setMargin(new Insets(0, 0, 0, 0));
		add(close);
		
		rematch.setBounds(580, 310, 160, 50);
		rematch.setMargin(new Insets(0, 0, 0, 0));
		add(rematch);
		
		reset.setBounds(580, 380, 160, 50);
		reset.setMargin(new Insets(0, 0, 0, 0));
		add(reset);

		gameNum.setText("Game #" + gameN);
		gameNum.setForeground(Color.white);
        gameNum.setBounds(635, 20, 160, 50);
        add(gameNum);
		score.setText("Scoreboard:");
		score.setForeground(Color.white);
        score.setBounds(625, 70, 160, 50);
        add(score);

		if (whoWins == "p1") {
			message.setText("Congratulations, " + name1 + "! You win!");
		}
		else if (whoWins == "p2") {
			message.setText("Congratulations, " + name2 + "! You win!");
		}
		else {
			message.setText("No one wins!");
		}
		message.setForeground(Color.white);
		message.setBounds(550, 160, 500, 50);
		add(message);

		p2Name.setText("p2: " + name2); //placeholder name, will be set to user's input
		p2Name.setForeground(Color.white);
        p2Name.setBounds(700, 100, 100, 50);
        add(p2Name);
		p1Name.setText("p1: " + name1); //will be set to user's input
		p1Name.setForeground(Color.white);
        p1Name.setBounds(600, 100, 100, 50);
        add(p1Name);
		
		p1Score.setText("" + gScore1);
        p1Score.setBounds(600, 120, 200, 50);
		p1Score.setForeground(Color.white);
        add(p1Score);
		p2Score.setText("" + gScore2);
		p2Score.setForeground(Color.white);
        p2Score.setBounds(700, 120, 200, 50);
        add(p2Score);

        ImageIcon catto = new ImageIcon("partycatcropped.gif");
        Image catImg = catto.getImage();
        //catImg = catImg.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        catto = new ImageIcon(catImg);
        JLabel winCat = new JLabel();
        winCat.setIcon(catto);
        winCat.setBounds(575, 200, 300, 100);
        add(winCat);

		b2.setBounds(230, 250, 164, 164);
		add(b2);
		
		
		setLayout(null);
		setSize(800, 500);
		setResizable(false);
		getContentPane().setBackground(Colors.GREEN);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

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
			//new game screen created, new game
            GameScreen g1 = new GameScreen("checkers", name1 , 
            name2 , 4, 4, 3); // example input
            g1.setVisible(false);
            g1.setSize(this.getWidth(), this.getHeight());
            gameN++;
            gameNum.setText("Game #" + gameN);

		}
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalScreen demo = new FinalScreen(5, 2, 3, "name1", "name2", "p1");
		demo.setVisible(true);*/

}
