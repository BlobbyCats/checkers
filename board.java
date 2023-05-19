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
		for (int row = 0; row < 8; row++) {
			for(int column = 0; column < 8; column++) {
				JPanel panel = new JPanel();
				if(row%2 == 0) {
					if(column%2 == 0) {
						panel.setBackground(Colors.LIGHT_BROWN);
					} else {
						panel.setBackground(Colors.DARK_BROWN);
					}
				} else {
					if(column%2 == 1) {
						panel.setBackground(Colors.LIGHT_BROWN);
					} else {
						panel.setBackground(Colors.DARK_BROWN);
					}
				}
				if (checkersData[row][column] != empty) {
					if (checkersData[row][column] == black) {
						JButton button = new JButton();
						button.setBackground(Color.black);
					}
					else {
						JButton button = new JButton();
						button.setBackground(Color.red);
					}
				}
				board.add(panel);
			}
		}
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
                 g.setColor(Color.LIGHT_GRAY);
              else
                 g.setColor(Color.GRAY);
              g.fillRect(2 + col*20, 2 + row*20, 20, 20);
              switch (checkersData[row][col]) {
              case red:
                 g.setColor(Color.RED);
                 g.fillOval(4 + col*20, 4 + row*20, 15, 15);
                 break;
              case black:
                 g.setColor(Color.BLACK);
                 g.fillOval(4 + col*20, 4 + row*20, 15, 15);
                 break;
              case redKing:
                 g.setColor(Color.RED);
                 g.fillOval(4 + col*20, 4 + row*20, 15, 15);
                 g.setColor(Color.WHITE);
                 g.drawString("K", 7 + col*20, 16 + row*20);
                 break;
              case blackKing:
                 g.setColor(Color.BLACK);
                 g.fillOval(4 + col*20, 4 + row*20, 15, 15);
                 g.setColor(Color.WHITE);
                 g.drawString("K", 7 + col*20, 16 + row*20);
                 break;
              }
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
				System.out.print(checkersData[row][column] + " ");
			}
			System.out.println();
		}
	}
	public void createPiece() {
		
	}

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		JFrame frame = new JFrame();
		frame.add(board);
		frame.setVisible(true);
		frame.setSize(800, 500);
	}
}