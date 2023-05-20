import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 

/**
 * @author anushka
 *
 */
public class HomePage extends JFrame implements ActionListener {

	// Creating the buttons in the class
	JButton startGame;
	JButton rules;
	JButton exit;
	// Creating the labels in the class
	JLabel tle; // title
	JLabel pl1Lbl; // Player 1 
	JLabel pl2Lbl; // Player 2
	JLabel warning1; // Player 1's warning
	JLabel warning2; // Player 2's warning
	// Creating the text inputs
	JTextField pl1; // Player 1's input
	JTextField pl2; // Player 2's input
	// Creating the instance variables 
	String p1; // Stores player 1's name
	String p2; // Stores player 2's name
	
	public HomePage() {
		// Sets the title of the JFrame Checkers
		super("Checkers");
		
		// Sets up the start button
		startGame = new JButton("Start Game");
		startGame.setActionCommand("start"); //set the command  
		startGame.addActionListener(this);
		startGame.setBounds(300, 325, 200, 50); // sets the location of the button
		
		// Sets up the rules button
		rules = new JButton("Rules");
		rules.setActionCommand("rules"); //set the command 
		rules.addActionListener(this);
		rules.setBounds(300, 375, 200, 50); // sets the location of the button
		
		// Sets up the exit button
		exit = new JButton("Exit Game");
		exit.setActionCommand("exit"); //set the command 
		exit.addActionListener(this);
		exit.setBounds(700, 450, 75, 20); // sets the location of the button
		
		// Sets the font of the player text and size
		Font plFont = new Font("Verdana", Font.PLAIN, 20);
		
		// Player 1
		pl1Lbl = new JLabel("Player 1 Name:"); // Creates the label with the message 
		pl1Lbl.setFont(plFont); // Sets the font 
		pl1Lbl.setBounds(325, 100, 225, 100); // Sets the location of the label
		
		// Sets the text field size and location for player 1
		pl1 = new JTextField(50);
		pl1.setBounds(275, 175, 250, 20);
		
		//Player 2
		pl2Lbl = new JLabel("Player 2 Name:"); // Creates the label with the message 
		pl2Lbl.setFont(plFont); // Sets the font 
		pl2Lbl.setBounds(325, 200, 225, 100); // Sets the location of the label
		
		// Sets the text field size and location for player 2
		pl2 = new JTextField(50);
		pl2.setBounds(275, 275, 250, 20);
		
		// Sets the title, location, and font of the title
		tle = new JLabel("Checkers");
		Font tleFont = new Font("Verdana", Font.BOLD, 50);
		tle.setFont(tleFont);
		tle.setBounds(275, 25, 300, 120);
		
		// Sets the warning to an empty string, font, and the location
		warning1 = new JLabel("");
		warning1.setFont(plFont);
		warning1.setBounds(300, 155, 225, 100);
		
		// Sets the warning to an empty string, font, and the location
		warning2 = new JLabel("");
		warning2.setFont(plFont);
		warning2.setBounds(300, 255, 225, 100);
		
		
        // Adds all of the buttons, labels, and textfields to the JFrame
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
        
        //
        setLayout(null);
	    setSize(800,500);
	    setVisible(true);
       
	    // Sets the background
	    getContentPane().setBackground(Colors.LIGHT_BROWN);
	    
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public void actionPerformed(ActionEvent evt) {
		if(evt.getActionCommand().equals("start")) {
			if (checkNames()) {
				System.out.println("Let the game begin");
				// Sets the screen to Game Screen
				GameScreen gs = new GameScreen("Checkers", p1, p2, 1, 0, 0);
				// Shows the game screen
				gs.setVisible(true);
				// Hides the home page
				this.setVisible(false);
			}
		} else if(evt.getActionCommand().equals("rules")) {
			if(checkNames()) {
				System.out.println("Here are the rules");
				// Sets the screen to Rules page
				Rule r = new Rule(p1, p2);
				// Shows the rules page
				r.setVisible(true);
				// Hides the home page
				this.setVisible(false);
			}
		} else if(evt.getActionCommand().equals("exit")) {
			// Closes the application
			System.exit(0);
		}
	}
	
	public boolean checkNames() {
		// Takes the user input from the text fields
		p1 = pl1.getText();
		p2 = pl2.getText();
		// Displays a warning to the user if there is no input in both text fields
		if (p1.isEmpty() && p2.isEmpty()) {
			warning1.setText("Please enter a name");
			warning2.setText("Please enter a name");
			return false;
		} 
		// Displays a warning to player 1 if there is no input in their text field
		else if(p1.isEmpty()) {
			warning1.setText("Please enter a name");
			warning2.setText("");
			return false;
		} 
		// Displays a warning to player 2 if there is no input in their text field
		else if(p2.isEmpty()) {
			warning1.setText("");
			warning2.setText("Please enter a name");
			return false;
		} 
		// Checks to make sure if player 1 and 2 have the same name
		else if(p1.equals(p2)) {
			warning1.setBounds(275, 155, 350, 100);
			warning2.setBounds(275, 255, 350, 100);
			warning1.setText("Please enter a new name");
			warning2.setText("Please enter a new name");
			return false;
		} 
		// Checks to see if both players names are larger than 12 characters
		else if(p1.length() >= 12 && p2.length() >= 12){
			// Displays a warning message
			int n = JOptionPane.showConfirmDialog(this, "Both names are too long, so we will take the first 12 characters! "
					+ "\n" + "Would you like to continue?", "Warning", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				// takes the users first 12 characters 
				p1 = p1.substring(0, 11);
				p2 = p2.substring(0, 11);
				return true;
			} else {
				// if no, user must input a new name
				warning1.setBounds(275, 155, 350, 100);
				warning2.setBounds(275, 255, 350, 100);
				warning1.setText("Please enter a new name");
				warning2.setText("Please enter a new name");
				return false;
			}
		}
		// Checks to see if  player 1's name is larger than 12 characters
		else if(p1.length() >= 12) {
			// Displays a warning message
			int n = JOptionPane.showConfirmDialog(this, "Player 1's name is too long, so we will take the first 12 characters! "
					+ "\n" + "Would you like to continue?", "Warning", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				// takes the player 1's first 12 characters of their name
				p1 = p1.substring(0, 11);
				return true;
			} else {
				// if no, user must input a new name
				warning1.setBounds(275, 155, 350, 100);
				warning1.setText("Please enter a new name");
				warning2.setText("");
				return false;
			}
		}
		// Checks to see if  player 2's name is larger than 12 characters
		else if (p2.length() >= 12) {
			// Displays a warning message
			int n = JOptionPane.showConfirmDialog(this, "Player 2's name is too long, so we will take the first 12 characters! "
					+ "\n" + "Would you like to continue?", "Warning", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				// takes the player 2's first 12 characters of their name
				p2 = p2.substring(0, 11);
				return true;
			} else {
				// if no, user must input a new name
				warning1.setText("");
				warning2.setBounds(275, 255, 350, 100);
				warning2.setText("Please enter a new name");
				return false;
			}
		} else {
			// If nothing else, the user can continue to the following screen
			return true;
		}
	}
	
	// returns player 1's name
	public String getP1() {
		return p1;
	}

	// returns player 2's name
	public String getP2() {
		return p2;
	}
	
}
