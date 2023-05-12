//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameScreen extends JFrame implements ActionListener {
	Color background = new Color(138, 189, 227);
	Font plFont = new Font("Verdana", Font.PLAIN, 20);

	JButton resign = new JButton("Resign");
	JButton draw = new JButton("Draw");
	JButton undo = new JButton("Undo");

	JButton board = new JButton("Board");

	JButton rules = new JButton("Rules");

	JButton home = new JButton();

	JPanel boardHolder = new JPanel();
	JPanel homeRow = new JPanel();
	JPanel rulesRow = new JPanel();

	JPanel rightPanel = new JPanel();
	JPanel stats = new JPanel();
	JPanel buttonsHolder = new JPanel();

	JPanel empty = new JPanel();

	public GameScreen(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homeRow.setBackground(background);
		stats.setBackground(background);
		buttonsHolder.setBackground(background);
		rightPanel.setBackground(background);
		rulesRow.setBackground(background);
		boardHolder.setBackground(background);
		empty.setBackground(background);

		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		homeRow.setLayout(new BoxLayout(homeRow, BoxLayout.X_AXIS));
		rulesRow.setLayout(new BoxLayout(rulesRow, BoxLayout.X_AXIS));

		ImageIcon homeIcon = new ImageIcon("homeIcon.png");
		Image homeImg = homeIcon.getImage();
		homeImg = homeImg.getScaledInstance(70, 40, java.awt.Image.SCALE_SMOOTH);
		homeIcon = new ImageIcon(homeImg);
		home.setIcon(homeIcon);

		resign.setFont(plFont);
		resign.setPreferredSize(new Dimension(100, 35));
		draw.setFont(plFont);
		draw.setPreferredSize(new Dimension(100, 35));
		undo.setFont(plFont);
		undo.setPreferredSize(new Dimension(100, 35));
		
		rules.setFont(plFont);
		rules.setPreferredSize(new Dimension(100, 50));

		homeRow.setPreferredSize(new Dimension(800, 70));
		rulesRow.setPreferredSize(new Dimension(800, 70));

		boardHolder.add(board);
		stats.add(new JLabel("YOOOOO"));
		buttonsHolder.add(resign);
		buttonsHolder.add(draw);
		buttonsHolder.add(undo);
		rightPanel.add(stats);
		rightPanel.add(buttonsHolder);
		homeRow.add(Box.createRigidArea(new Dimension(20, 20)));
		homeRow.add(Box.createVerticalGlue());
		homeRow.add(home);
		rulesRow.add(Box.createHorizontalGlue());
		rulesRow.add(rules);
		rulesRow.add(Box.createRigidArea(new Dimension(20, 20)));
		rulesRow.add(Box.createVerticalGlue());

		setLayout(new BorderLayout());
		add(boardHolder, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		add(homeRow, BorderLayout.NORTH);
		add(rulesRow, BorderLayout.SOUTH);
		add(empty, BorderLayout.CENTER);
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

