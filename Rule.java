import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Rule extends JFrame implements ActionListener {
	JButton button = new JButton(" Start Game");
	JButton home = new JButton(" Home ");
	String p1 = "";
	String p2 = "";
	
    JLabel label= new JLabel();// display area of String of text


	public Rule(String p1Name, String p2Name) {
		p1 = p1Name;
		p2 = p2Name; 
		
		button.setBounds(20, 10, 100,30);
		button.addActionListener(this);
		
		home.setBounds(870,10,100,30);
		home.addActionListener(this);
	
		
       // label.setText(" Checkers is a board game played between 2 people on an 8x8 board. Each person had 12 pieces." );
        
        label.setText("<html> <pre> 1. Checkers is a board game played between 2 people on an 8x8 board. "
        		+ "<pre> 2. Each person had 12 pieces." + " <pre> 3. Darker color goes first." + 
        		"<pre> 4. Pieces are always moved diagonally" + 
        		" <pre>    a. Pawns can only be moved \forward - diagonally <pre>" +
        		"    b. Kings can be moved \backwards <pre>"+ "5. A King can be made by moving a pawn to the opposite side of the board"

        		+ "<pre>6. To capture the opponent pieces your pieces leaps over one of the opponent <pre> pieces and land in straight  diagonal line on the other sides"
        		+ "7. If neither player has legal moves, then it is a draw <pre>"
        		+ "8. You win the game when the opponent has no more pieces or cannot move"
        		+ " </html>" );

        
		
	label.setHorizontalAlignment(JLabel.CENTER);

     	setSize(1000 ,600);//set the size of the frame
        setTitle(" Rule Page ");
     	getContentPane().setBackground(Colors.LIGHT_BROWN);
     	add(button);// add the button 
     	add(home);
     	add(label);// add label
     	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application 
     	setVisible(true);//make frame visible
     
	}
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
	
if(evt.getActionCommand().equals("Home")) {
	HomePage hp= new HomePage();
			
		}
		else {
			
	GameScreen g= new GameScreen("Checkers!", p1, p2, 0, 0, 0);
			
		g.setVisible(true);
			
			
			
		}
      setVisible(false);
			
		}
		
	
}
