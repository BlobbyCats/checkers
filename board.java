import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {
    JPanel board = new JPanel();
    int[][] checkersData = new int[8][8];
    static final int empty = 0;
	static final int red = 1;
	static final int black = 2; 
	static final int redKing = 3;
	static final int blackKing = 4;
    public Board() {
		prepareGame();
    }
    public void paint() {
		board.setLayout(new GridLayout(8,8));
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				JPanel panel = new JPanel();
				if(i%2 == 0) {
					if(j%2 == 0) {
						panel.setBackground(Colors.LIGHT_BROWN);
					} else {
						panel.setBackground(Colors.DARK_BROWN);
					}
				} else {
					if(j%2 == 1) {
						panel.setBackground(Colors.LIGHT_BROWN);
					} else {
						panel.setBackground(Colors.DARK_BROWN);
					}
				}
				board.add(panel);
			}
		}
    }
	public void prepareGame() {
		for (int row = 0; row < checkersData.length; row++) {
			for (int column = 0; column < checkersData[row].length; column++) {
				if (row % 2 == column % 2) {
					if (row < 3) {
						checkersData[row][column] = black;
					}
					else if (row > 4) {
						checkersData[row][column] = red;
					}
					else {
						checkersData[row][column] = empty;
					}
				}
				else {
					checkersData[row][column] = empty;
				}
			}
		}
	}
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();

	}
}