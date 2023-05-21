import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

	private int fromRow = 0;
	private int fromCol = 0;
	private int toRow = 0;
	private int toCol = 0;

	private int selectedRow = -1;
	private int selectedCol = -1;

	private int currentPlayer;

	private Move[] legalMoves;

	Player p1;
	Player p2;
	private int gameNum;

	GameScreen game;
	
    public Board(String player1, String player2, int gNum, int player1Wins, int player2Wins, String p1Color, String p2Color, GameScreen g) {
		p1 = new Player(player1, player1Wins, p1Color);
		p2 = new Player(player2, player2Wins, p2Color);
		gameNum = gNum;
		drawBoard();
		addMouseListener(this);
		currentPlayer = black;
		legalMoves = getLegalMoves(currentPlayer);
		game = g;
    }
	public void clickSquare(int row, int col) {
		for (int i = 0; i < legalMoves.length; i++) {
            if (legalMoves[i].getFromRow() == row && legalMoves[i].getFromCol() == col) {
            	selectedRow = row;
                selectedCol = col;
                repaint();
            }
		}
		for (int i = 0; i < legalMoves.length; i++)
            if (legalMoves[i].getFromRow() == selectedRow && legalMoves[i].getFromCol() == selectedCol && legalMoves[i].getToRow() == row && legalMoves[i].getToCol() == col) {
                move(legalMoves[i]);
            }
	}
	public int getPiece(int row, int col) {
		return checkersData[row][col];
	}
	public Move[] getLegalJumpsFrom(int player, int row, int col) {
		if (player != red && player != black)
		   return null;
		int playerKing;
		if (player == red)
		   playerKing = redKing;
		else
		   playerKing = blackKing;
		ArrayList<Move> moves = new ArrayList<Move>(); 
		if (checkersData[row][col] == player || checkersData[row][col] == playerKing) {
		   if (canJump(player, row, col, row+1, col+1, row+2, col+2))
			  moves.add(new Move(row, col, row+2, col+2));
		   if (canJump(player, row, col, row-1, col+1, row-2, col+2))
			  moves.add(new Move(row, col, row-2, col+2));
		   if (canJump(player, row, col, row+1, col-1, row+2, col-2))
			  moves.add(new Move(row, col, row+2, col-2));
		   if (canJump(player, row, col, row-1, col-1, row-2, col-2))
			  moves.add(new Move(row, col, row-2, col-2));
		}
		if (moves.size() == 0)
		   return null;
		else {
			Move[] moveArray = new Move[moves.size()];
		   for (int i = 0; i < moves.size(); i++)
			  moveArray[i] = moves.get(i);
		   return moveArray;
		}
	}
	public Move[] getLegalMoves(int player) {
		ArrayList<Move> moves = new ArrayList<Move>();
		int playerKing;
		if (player == red) {
			playerKing = redKing;
		}
		else {
			playerKing = blackKing;
		}
		for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
               if (checkersData[row][col] == player || checkersData[row][col] == playerKing) {
                  if (canJump(player, row, col, row+1, col+1, row+2, col+2))
                     moves.add(new Move(row, col, row+2, col+2));
                  if (canJump(player, row, col, row-1, col+1, row-2, col+2))
                     moves.add(new Move(row, col, row-2, col+2));
                  if (canJump(player, row, col, row+1, col-1, row+2, col-2))
                     moves.add(new Move(row, col, row+2, col-2));
                  if (canJump(player, row, col, row-1, col-1, row-2, col-2))
                     moves.add(new Move(row, col, row-2, col-2));
               }
            }
        }
		if (moves.size() == 0) {
			for (int row = 0; row < 8; row++) {
				for (int col = 0; col < 8; col++) {
					if (checkersData[row][col] == player || checkersData[row][col] == playerKing) {
						if (canMove(player, row, col, row + 1, col + 1)) {
							moves.add(new Move(row, col, row + 1, col + 1));
						}
						if (canMove(player, row, col, row - 1, col + 1)) {
							moves.add(new Move(row, col, row - 1, col + 1));
						}
						if (canMove(player, row, col, row + 1, col - 1)) {
							moves.add(new Move(row, col, row + 1, col - 1));
						}
						if (canMove(player, row, col, row - 1, col - 1)) {
							moves.add(new Move(row, col, row - 1, col - 1));
						}
					}
				}
			}
		}
		
		if (moves.size() == 0) {
			return null;
		}
		else {
			Move[] moves2 = new Move[moves.size()];
			int i = 0;
			for (Move m : moves) {
				moves2[i] = m;
				i++;
			}
			return moves2;
		}
	}
	public boolean canMove(int player, int fromRow, int fromCol, int toRow, int toCol) {
		if (toRow < 0 || toRow >= 8 || toCol < 0 || toCol >= 8) {
			return false;
		}
		if (checkersData[toRow][toCol] != empty) {
			return false;
		}
		if (player == red) {
			if (checkersData[fromRow][fromCol] == red && toRow > fromRow) {
				return false;
			}
			return true;
		}
		else {
			if (checkersData[fromRow][fromCol] == black && toRow < fromRow) {
				return false;
			}
			return true;
		}
	}
	public boolean canJump(int player, int r1, int c1, int r2, int c2, int r3, int c3) {
         
		if (r3 < 0 || r3 >= 8 || c3 < 0 || c3 >= 8)
		   return false;
		
		if (checkersData[r3][c3] != empty)
		   return false;
		
		if (player == red) {
		   if (checkersData[r1][c1] == red && r3 > r1)
			  return false;
		   if (checkersData[r2][c2] != black && checkersData[r2][c2] != blackKing)
			  return false;
		   return true;
		}
		else {
		   if (checkersData[r1][c1] == black && r3 < r1)
			  return false; 
		   if (checkersData[r2][c2] != red && checkersData[r2][c2] != redKing)
			  return false;
		   return true;
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
                 g.drawString("K", 14 + col*32, 23 + row*32);
                 break;
              case blackKing:
                 g.setColor(Color.BLACK);
                 g.fillOval(6 + col*32, 6 + row*32, 24, 24);
                 g.setColor(Color.WHITE);
                 g.drawString("K", 14 + col*32, 23 + row*32);
                 break;
              }
           }
        }

		if (inProgress) {
		 	g.setColor(Color.cyan);
		 	for (int i = 0; i < legalMoves.length; i++) {
				g.drawRect(2 + legalMoves[i].getFromCol()*32, 2 + legalMoves[i].getFromRow()*32, 32, 32);
				g.drawRect(2 + legalMoves[i].getFromCol()*32, 2 + legalMoves[i].getFromRow()*32, 32, 32);
		 	}

		if (selectedRow >= 0) {
			g.setColor(Color.white);
			g.drawRect(2 + selectedCol*32, 2 + selectedRow*32, 32, 32);
			g.drawRect(2 + selectedCol*32, 2 + selectedRow*32, 32, 32);
			g.setColor(Color.green);
			for (int i = 0; i < legalMoves.length; i++) {
			   if (legalMoves[i].getFromCol() == selectedCol && legalMoves[i].getFromRow() == selectedRow) {
					g.drawRect(2 + legalMoves[i].getToCol()*32, 2 + legalMoves[i].getToRow()*32, 32, 32);
				  	g.drawRect(2 + legalMoves[i].getToCol()*32, 2 + legalMoves[i].getToRow()*32, 32, 32);
			   }
			}
		 }
	  }
    }
	public void move(Move m) {
		checkersData[m.getToRow()][m.getToCol()] = checkersData[m.getFromRow()][m.getFromCol()];
		checkersData[m.getFromRow()][m.getFromCol()] = empty;
		if (m.getFromRow() - m.getToRow() == 2 || m.getFromRow() - m.getToRow() == -2) {
			int midRow = (m.getFromRow() + m.getToRow()) / 2;
			int midCol = (m.getFromCol() + m.getToCol()) / 2;
			checkersData[midRow][midCol] = empty;
		}
		if (m.getToRow() == 0 && checkersData[m.getToRow()][m.getToCol()] == red)
            checkersData[m.getToRow()][m.getToCol()] = redKing;
        if (m.getToRow() == 7 && checkersData[m.getToRow()][m.getToCol()] == black)
            checkersData[m.getToRow()][m.getToCol()] = blackKing;
		
		if (m.isJump()) {
			legalMoves = getLegalJumpsFrom(currentPlayer,m.getToRow(),m.getToCol());
			if (legalMoves != null) {
				selectedRow = m.getToRow();  // Since only one piece can be moved, select it.
				selectedCol = m.getToCol();
				repaint();
			}
		}

		if (currentPlayer == red) {
			currentPlayer = black;
			legalMoves = getLegalMoves(currentPlayer);
			game.updateTurn();
			if (legalMoves == null) {
				if (p1.getColor() == "black") {
					String whoWins = "p2";
					p2.incrementWins();
					FinalScreen f = new FinalScreen(gameNum, p1.getWins(), p2.getWins(), p1.getName(), p2.getName(), whoWins, p1.getColor(), p2.getColor());
					this.setVisible(false);
				}
				else {
					String whoWins = "p1";
					p1.incrementWins();
					FinalScreen f = new FinalScreen(gameNum, p1.getWins(), p2.getWins(), p1.getName(), p2.getName(), whoWins, p1.getColor(), p2.getColor());
					this.setVisible(false);
				}
			}
		}
		else {
			currentPlayer = red;
			legalMoves = getLegalMoves(currentPlayer);
			game.updateTurn();
			if (legalMoves == null) {
				if (p1.getColor() == "red") {
					String whoWins = "p2";
					p2.incrementWins();
					FinalScreen f = new FinalScreen(gameNum, p1.getWins(), p2.getWins(), p1.getName(), p2.getName(), whoWins, p1.getColor(), p2.getColor());
					this.setVisible(false);
				}
				else {
					String whoWins = "p1";
					p1.incrementWins();
					FinalScreen f = new FinalScreen(gameNum, p1.getWins(), p2.getWins(), p1.getName(), p2.getName(), whoWins, p1.getColor(), p2.getColor());
					this.setVisible(false);
				}
			}
		}
			 
		selectedRow = -1;
			 
		if (legalMoves != null) {
			boolean sameStartSquare = true;
			for (int i = 1; i < legalMoves.length; i++)
			   if (legalMoves[i].getFromRow() != legalMoves[0].getFromRow() || legalMoves[i].getFromCol() != legalMoves[0].getFromCol()) {
					sameStartSquare = false;
					break;
				}
				if (sameStartSquare) {
				   selectedRow = legalMoves[0].getFromRow();
				   selectedCol = legalMoves[0].getFromCol();
				}
		}
		
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
        int col = (e.getX() - 2) / 32;
        int row = (e.getY() - 2) / 32;
        if (col >= 0 && col < 8 && row >= 0 && row < 8) {
			clickSquare(row, col);
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
	/*public static void main(String[] args) {
		Board board = new Board();
		JFrame frame = new JFrame();
		frame.add(board);
		frame.setVisible(true);
		frame.setSize(800, 500);
	}*/
}
