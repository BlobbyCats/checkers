//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameScreen extends JFrame implements ActionListener {
	JButton resign = new JButton("Resign");
	JButton draw = new JButton("Draw");
	JButton undo = new JButton("Undo");

	JButton board = new JButton("Board");

	JButton rules = new JButton("Rules");

	JButton home = new JButton("Home");

	JPanel boardHolder = new JPanel();
	JPanel homeRow = new JPanel();
	JPanel rulesRow = new JPanel();

	JPanel rightPanel = new JPanel();
	JPanel stats = new JPanel();
	JPanel buttonsHolder = new JPanel();

	public GameScreen(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		boardHolder.add(board);
		stats.add(new JLabel("YOOOOO"));
		buttonsHolder.add(resign);
		buttonsHolder.add(draw);
		buttonsHolder.add(undo);
		rightPanel.add(stats);
		rightPanel.add(buttonsHolder);
		homeRow.add(home);
		rulesRow.add(rules);

		setLayout(new BorderLayout());
		add(boardHolder, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(homeRow, BorderLayout.NORTH);
		add(rulesRow, BorderLayout.SOUTH);
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

