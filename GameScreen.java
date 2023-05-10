//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
package checkers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameScreen extends JFrame implements ActionListener {
	JButton resign = new JButton("Resign");
	JButton draw = new JButton("Draw");
	JButton undo = new JButton("Undo");
	public GameScreen(String title) {
		super(title);
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		
		add(resign);
		add(draw);
		add(undo);
		
		layout.putConstraint(SpringLayout.WEST, resign, 550, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, resign, 300, SpringLayout.NORTH, getContentPane());
		
		layout.putConstraint(SpringLayout.WEST, draw, 675, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, draw, 300, SpringLayout.NORTH, getContentPane());
		
		layout.putConstraint(SpringLayout.WEST, undo, 610, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, undo, 350, SpringLayout.NORTH, getContentPane());
		
		
		resign.addActionListener(this);
		undo.addActionListener(this);
		draw.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("hi");
	}
	public static void main (String[] args) {
		GameScreen game = new GameScreen("Checkers!");
		game.setSize(800, 500);
		game.setVisible(true);
	}
}

