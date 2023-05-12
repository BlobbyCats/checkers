import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Rule extends JFrame implements ActionListener {
	JButton button = new JButton(" Start Game");
	JButton home = new JButton(" Home ");
	
    JLabel label= new JLabel();// display area of String of text

    JFrame frame = new JFrame();// create Frameuy

	public Rule() {
		button.setBounds(20, 10, 100,30);
		button.addActionListener(this);
		
		home.setBounds(570,10,100,30);
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
		
        
     	frame.setSize(800,500);//set the size of the frame
     	frame.setTitle(" Rule Page ");
     	frame.add(button);// add the button 
     	frame.add(home);
     	frame.add(label);// add label
     	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application 
     	frame.setVisible(true);//make frame visible
     
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
		}
	

	
}
