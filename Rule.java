import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Rule class : explain the rule of checkers
public class Rule extends JFrame implements ActionListener {// Rule class
    JButton gameButton = new JButton("Start Game");
    JButton homeButton = new JButton();
    String p1 = "";// player 1 
    String p2 = "";//player 2
   
    JLabel label= new JLabel();// display text of rule 



   // @param p1Name - player 1 name 
   // @param p2Name - player 2 name 
    public Rule(String p1Name, String p2Name) {
        p1 = p1Name;
        p2 = p2Name;
       
        // set the button bound/ location 
        gameButton.setBounds(20, 10, 100,30);
        gameButton.addActionListener(this);
        gameButton.setActionCommand("FirstButton");
        
       
        //set the home button bound/location 
        homeButton.setBounds(680, 10, 100, 30);
        homeButton.addActionListener(this);
        homeButton.setActionCommand("SecondButton");
   
       
       // the rule text 
        label.setText("<html> <pre> 1. Checkers is a board game played between 2 people on an 8x8 board. "
                + "<pre> 2. Each person had 12 pieces." + " <pre> 3. Darker color goes first." +
                "<pre> 4. Pieces are always moved diagonally" +
                " <pre>    a. Pawns can only be moved \forward - diagonally <pre>" +
                "    b. Kings can be moved \backwards <pre>"+ "5. A King can be made by moving a pawn to the opposite side of the board"


                + "<pre>6. To capture the opponent pieces your pieces leaps over one of the opponent <pre> pieces and land in straight  diagonal line on the other sides"
                + "7. If neither player has legal moves, then it is a draw <pre>"
                + "8. You win the game when the opponent has no more pieces or cannot move"
                + " </html>" );


       
       // set the label in the center
    label.setHorizontalAlignment(JLabel.CENTER);

        setSize(800,500);//set the size of the frame
        setTitle(" Rule Page ");// the JFrame title 
        getContentPane().setBackground(Colors.LIGHT_BROWN);// change the JFrame background colors 
        add(gameButton);// add the button
        add(homeButton);// add the home button 
        add(label);// add label
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        setVisible(true);//make frame visible


        rescaleImage("homeIcon.png", homeButton, 55, 47);// set the home icons 
        homeButton.setFocusPainted(true);
     
    }

// @param  fileName - the file name
// @param  button - the button 
// @param  width - the width of the icon that we want to change 
// @param  height - the height of the icon that we want to change
    public void rescaleImage(String fileName, JButton button, int width, int height) {
        ImageIcon icon = new ImageIcon(fileName);
        Image img = icon.getImage();
        img = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        homeButton.setIcon(icon);
    }

// set the action performed when we click the button 
    public void actionPerformed(ActionEvent evt) {
           // if the button is Start Game take the user to the game screen 
if(evt.getActionCommand().equals("Start Game")) {
	GameScreen g= new GameScreen("Checkers!", p1, p2, 0, 0, 0);
        // set the game screen visible 
        g.setVisible(true);
    
        }
        else {
           // take the user back to the home pages 
			HomePage hp= new HomePage();
			hp.setVisible(true);
           
           
           
        }
// make the Rule jFrame invisible 
      setVisible(false);
           
        }
       
   
}
