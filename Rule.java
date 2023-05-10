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
        
        label.setText("<html> 1. Checkers is a board game played between 2 people on an 8x8 board. "
        		+ "<br/> 2. Each person had 12 pieces." + " <br/> 3. Darker color goes first." + 
        		"<br/> 4.Pieces are always moved diagonally" + 
        		"<br/> </t> a. Pawns can only be moved forward - diagonally" + " .</html>" );

        
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
		
		
	public static void main(String[] args) {
		new Rule();
		
	}

	
}