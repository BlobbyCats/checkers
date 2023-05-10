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
	JButton enter1;
	JButton enter2;
	JLabel tle;
	JLabel pl1Lbl;
	JLabel pl2Lbl;
	JLabel warning1;
	JLabel warning2;
	JTextField pl1;
	JTextField pl2;
	String p1;
	String p2;
	
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		super("Checkers");
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
		
		
		
		enter1 = new JButton("Save");
		enter1.setActionCommand("save1"); //set the command 
		enter1.addActionListener(this);
		enter1.setBounds(500, 175, 75, 20);
		
		pl1 = new JTextField(50);
		pl1.setBounds(300, 175, 250, 20);
		
		//Player 2
		pl2Lbl = new JLabel("Player 2 Name:");
		pl2Lbl.setFont(plFont);
		pl2Lbl.setBounds(325, 200, 225, 100);
		
		
		enter2 = new JButton("Save");
		enter2.setActionCommand("save2"); //set the command 
		enter2.addActionListener(this);
		enter2.setBounds(500, 275, 75, 20);
		
		pl2 = new JTextField(50);
		pl2.setBounds(300, 275, 250, 20);


		tle = new JLabel("Checkers");
		Font tleFont = new Font("Verdana", Font.BOLD, 30);
		tle.setFont(tleFont);
		tle.setBounds(325, 25, 225, 100);
				
		
        
        add(tle);
        add(pl1Lbl);
        add(enter1);
        add(enter2);
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
        
        getContentPane().setBackground(Color.red);    
       
        
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public void actionPerformed( ActionEvent evt) {
		Font plFont = new Font("Verdana", Font.PLAIN, 20);
		if(evt.getActionCommand().equals("start")) {
			System.out.println("Let the game begin");
		} else if (evt.getActionCommand().equals("rules")) {
			System.out.println("Here are the rules");
		} else if(evt.getActionCommand().equals("exit")) {
			System.exit(0);
		} else if(evt.getActionCommand().equals("save1")) {
			if(pl1.getText().isEmpty()) {
				warning1 = new JLabel("Please enter a name");
				warning1.setFont(plFont);
				warning1.setBounds(325, 100, 225, 100);
			}
			p1 = pl1.getText();
			System.out.println("Player 1's Name:" + p1);
		} else if(evt.getActionCommand().equals("save2")) {
			if(pl2.getText().isEmpty()) {
				warning2 = new JLabel("Please enter a name");
				warning2.setFont(plFont);
				warning2.setBounds(325, 100, 225, 100);
			}
			p2 = pl2.getText();
			System.out.println("Player 2's Name:" + p2);
		}
	}

}
