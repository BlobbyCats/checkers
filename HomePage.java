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
	JPanel panel1;
	JPanel panel2;
	JLabel tle;
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		super("Checkers");
		startGame = new JButton("Start Game");
		startGame.setActionCommand("start"); //set the command  
		startGame.addActionListener(this);
		startGame.setBounds(150, 125, 200, 50);
		
		rules = new JButton("Rules");
		rules.setActionCommand("rules"); //set the command 
		rules.addActionListener(this);
		rules.setBounds(150, 175, 200, 50);
		
		exit = new JButton("Exit Game");
		exit.setActionCommand("exit"); //set the command 
		exit.addActionListener(this);
		exit.setBounds(400, 250, 75, 20);
		
		tle = new JLabel("Checkers");
		Font tleFont = new Font("Verdana", Font.BOLD, 30);
		tle.setFont(tleFont);
		tle.setBounds(175, 25, 225, 100);
				
		setLayout(null);
        	setSize(500,300);
        	setVisible(true);
        
        	add(tle);
        	add(startGame);
        	add(rules);
        	add(exit);
        
        	getContentPane().setBackground(Color.red);    
       
        
	    	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public void actionPerformed( ActionEvent evt) {
		if(evt.getActionCommand().equals("start")) {
			System.out.println("Let the game begin");
		} else if (evt.getActionCommand().equals("rules")) {
			System.out.println("Here are the rules");
		} else if(evt.getActionCommand().equals("exit")) {
			System.exit(0);
		}
	}

}
