public class Move {
    private int fromRow;
    private int fromCol;
    private int toRow;
    private int toCol;
    /**
     * Constructor that fills in the instance variables with the designated arguments
     * @param fromRow - int that describes the current row of the piece
     * @param fromCol - int that describes the current column of the piece
     * @param toRow - int that describes the desired row of the piece
     * @param toCol - int that describes the desire column of the piece
     */
    public Move(int fromRow, int fromCol, int toRow, int toCol) {
        this.fromRow = fromRow;
        this.fromCol = fromCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }
    /**
     * Returns whether or not a certain move is a jump or not
     * @return boolean that describes if the move is a jump or not
     */
    public boolean isJump() {
		return (fromRow - toRow == 2 || fromRow - toRow == -2);
 	}
    /**
     * Returns the current row of the piece
     * @return fromRow - int that describes the current row of the piece
     */
    public int getFromRow() {
        return fromRow;
    }
    /**
     * Returns the current column of the piece
     * @return fromCol - int that describes the current column of the piece
     */
    public int getFromCol() {
        return fromCol;
    }
    /**
     * Returns the desired row of the piece
     * @return toRow - int that describes the desired row of the piece
     */
    public int getToRow() {
        return toRow;
    }
    /**
     * Returns the desired column of the piece
     * @return toCol - int that describes the desire column of the piece
     */
    public int getToCol() {
        return toCol;
    }
}
