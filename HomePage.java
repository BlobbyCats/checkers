import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 

/**
 * @author anushka
 *
 */
public class HomePage extends JFrame implements ActionListener {

	JButton startGame;
	JButton rules;
	JButton exit;
	JLabel tle;
	JLabel pl1Lbl;
	JLabel pl2Lbl;
	JLabel warning1;
	JLabel warning2;
	JTextField pl1;
	JTextField pl2;
	String p1;
	String p2;
	//HomePageBkgd d;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		super("Checkers");
		//d = new HomePageBkgd();
		//d.paint();
		
		startGame = new JButton("Start Game");
		startGame.setActionCommand("start"); //set the command  
		startGame.addActionListener(this);
		startGame.setBounds(300, 325, 200, 50);
		
		rules = new JButton("Rules");
		rules.setActionCommand("rules"); //set the command 
		rules.addActionListener(this);
		rules.setBounds(300, 375, 200, 50);
		
		exit = new JButton("Exit Game");
		exit.setActionCommand("exit"); //set the command 
		exit.addActionListener(this);
		exit.setBounds(700, 450, 75, 20);
		
		// Player stuff
		Font plFont = new Font("Verdana", Font.PLAIN, 20);
		
		// Player 1
		pl1Lbl = new JLabel("Player 1 Name:");
		pl1Lbl.setFont(plFont);
		pl1Lbl.setBounds(325, 100, 225, 100);
		
		pl1 = new JTextField(50);
		pl1.setBounds(275, 175, 250, 20);
		
		//Player 2
		pl2Lbl = new JLabel("Player 2 Name:");
		pl2Lbl.setFont(plFont);
		pl2Lbl.setBounds(325, 200, 225, 100);
		
		pl2 = new JTextField(50);
		pl2.setBounds(275, 275, 250, 20);

		tle = new JLabel("Checkers");
		Font tleFont = new Font("Verdana", Font.BOLD, 50);
		tle.setFont(tleFont);
		tle.setBounds(275, 25, 300, 120);
		
		warning1 = new JLabel("");
		warning1.setFont(plFont);
		warning1.setBounds(300, 155, 225, 100);
		
		warning2 = new JLabel("");
		warning2.setFont(plFont);
		warning2.setBounds(300, 255, 225, 100);
        
        add(tle);
        add(pl1Lbl);
        add(pl1);
        add(pl2);
        add(pl2Lbl);
        add(startGame);
        add(rules);
        add(exit); 
        add(warning1);
        add(warning2);
        
        setLayout(null);
	    setSize(800,500);
	    setVisible(true);
       
	    getContentPane().setBackground(Colors.LIGHT_BROWN);
	    
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getActionCommand().equals("start")) {
			if (checkNames()) {
				System.out.println("Let the game begin");
				GameScreen gs = new GameScreen("Checkers", p1, p2, 0, 0, 0);
				gs.setVisible(true);
				this.setVisible(false);
			}
		} else if(evt.getActionCommand().equals("rules")) {
			if(checkNames()) {
				System.out.println("Here are the rules");
				Rule r = new Rule(p1, p2);
				this.setVisible(false);
			}
		} else if(evt.getActionCommand().equals("exit")) {
			System.exit(0);
		}
	}
	
	public boolean checkNames() {
		p1 = pl1.getText();
		p2 = pl2.getText();
		if (p1.isEmpty() && p2.isEmpty()) {
			warning1.setText("Please enter a name");
			warning2.setText("Please enter a name");
			return false;
		} else if(p1.isEmpty()) {
			warning1.setText("Please enter a name");
			warning2.setText("");
			return false;
		} else if(p2.isEmpty()) {
			warning1.setText("");
			warning2.setText("Please enter a name");
			return false;
		} else if(p1.equals(p2)) {
			warning1.setBounds(275, 155, 350, 100);
			warning2.setBounds(275, 255, 350, 100);
			warning1.setText("Please enter a new name");
			warning2.setText("Please enter a new name");
			return false;
		} else if(p1.length() >= 12 && p2.length() >= 12){
			int n = JOptionPane.showConfirmDialog(this, "The both names are too long, so it is taking the first 12 characters! "
					+ "\n" + "Would you like to continue?", "Warning", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				p1 = p1.substring(0, 11);
				p2 = p2.substring(0, 11);
				return true;
			} else {
				warning1.setBounds(275, 155, 350, 100);
				warning2.setBounds(275, 255, 350, 100);
				warning1.setText("Please enter a new name");
				warning2.setText("Please enter a new name");
				return false;
			}
		} else if(p1.length() >= 12) {
			int n = JOptionPane.showConfirmDialog(this, "The player 1's name is too long, so it is taking the first 12 characters! "
					+ "\n" + "Would you like to continue?", "Warning", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				p1 = p1.substring(0, 11);
				return true;
			} else {
				warning1.setBounds(275, 155, 350, 100);
				warning1.setText("Please enter a new name");
				warning2.setText("");
				return false;
			}
		} else if (p2.length() >= 12) {
			int n = JOptionPane.showConfirmDialog(this, "The player 2's name too long, so it is taking the first 12 characters! "
					+ "\n" + "Would you like to continue?", "Warning", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				p2 = p2.substring(0, 11);
				return true;
			} else {
				warning1.setText("");
				warning2.setBounds(275, 155, 350, 100);
				warning2.setText("Please enter a new name");
				return false;
			}
		} else {
			return true;
		}
	}
	
	public String getP1() {
		return p1;
	}

	public String getP2() {
		return p2;
	}
	
}
