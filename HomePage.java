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
        
        getContentPane().setBackground(Color.red);    
       
        
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

}
