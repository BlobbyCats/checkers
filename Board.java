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
	public int getPiece(int row, int col) {
		return checkersData[row][col];
	}
	public void paintComponent(Graphics g) {
        // Draw a two-pixel black border around the edges of the canvas. 

        g.setColor(Color.black);
        g.drawRect(0,0,getSize().width-1,getSize().height-1);
        g.drawRect(1,1,getSize().width-3,getSize().height-3);

        // Draw the squares of the checkerboard and the checkers.

        for (int row = 0; row < 8; row++) {
           for (int col = 0; col < 8; col++) {
              if ( row % 2 == col % 2 )
                 g.setColor(Colors.DARK_BROWN);
              else
                 g.setColor(Colors.LIGHT_BROWN);
              g.fillRect(2 + col*32, 2 + row*32, 32, 32);
              switch (checkersData[row][col]) {
              case red:
                 g.setColor(Color.RED);
                 g.fillOval(6 + col*32, 6 + row*32, 24, 24);
                 break;
              case black:
                 g.setColor(Color.BLACK);
                 g.fillOval(6 + col*32, 6 + row*32, 24, 24);
                 break;
              case redKing:
                 g.setColor(Color.RED);
                 g.fillOval(6 + col*32, 6 + row*32, 24, 24);
                 g.setColor(Color.WHITE);
                 g.drawString("K", 9 + col*32, 18 + row*32);
                 break;
              case blackKing:
                 g.setColor(Color.BLACK);
                 g.fillOval(6 + col*32, 6 + row*32, 24, 24);
                 g.setColor(Color.WHITE);
                 g.drawString("K", 9 + col*32, 18 + row*32);
                 break;
              }
           }
        }
    }
	public void prepareGame() {
		for (int row = 0; row < checkersData.length; row++) {
			for (int column = 0; column < checkersData[row].length; column++) {
				if (row % 2 != column % 2) {
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
				System.out.print(checkersData[row][column] + " ");
			}
			System.out.println();
		}
	}
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		JFrame frame = new JFrame();
		frame.add(board);
		frame.setVisible(true);
		frame.setSize(800, 500);
	}*/
}
