import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements MouseListener {
    JPanel board = new JPanel();
	private boolean inProgress = true;
    private int[][] checkersData = new int[8][8];
    static final int empty = 0;
	static final int red = 1;
	static final int black = 2; 
	static final int redKing = 3;
	static final int blackKing = 4;

	int fromRow = 0;
	int fromCol = 0;
	int toRow = 0;
	int toCol = 0;

	int selectedRow = -1;
	int selectedCol = -1;

	int currentPlayer;
    public Board() {
		drawBoard();
		board.addMouseListener(this);
		currentPlayer = black;
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
	public void move(int fromRow, int fromCol, int toRow, int toCol) {
		checkersData[toRow][toCol] = checkersData[fromRow][fromCol];
		checkersData[fromRow][fromCol] = empty;
		if (fromRow - toRow == 2 || fromRow - toRow == -2) {
			int midRow = (fromRow + toRow) / 2;
			int midCol = (fromCol + toCol) / 2;
			checkersData[midRow][midCol] = empty;
		}
		if (toRow == 0 && checkersData[toRow][toCol] == red)
            checkersData[toRow][toCol] = redKing;
        if (toRow == 7 && checkersData[toRow][toCol] == black)
            checkersData[toRow][toCol] = blackKing;
		repaint();
	}
	public void drawBoard() {
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
			}
		}
	}
    public void mousePressed(MouseEvent e) {
        int col = (e.getX() - 2) / 20;
        int row = (e.getY() - 2) / 20;
        if (col >= 0 && col < 8 && row >= 0 && row < 8) {
			move(1, 0, 2, 0);
		}
    }
	public void mouseClicked(MouseEvent e) {
    }
	public void mouseEntered(MouseEvent e) {
    }
	public void mouseReleased(MouseEvent e) {
    }
	public void mouseExited(MouseEvent e) {
	}
	public static void main(String[] args) {
		Board board = new Board();
		JFrame frame = new JFrame();
		frame.add(board);
		frame.setVisible(true);
		frame.setSize(800, 500);
	}
}
