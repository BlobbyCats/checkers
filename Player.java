/**
 * @author ruthwika
 *
 */
public class Player {
    private String name = "";
    private int wins = 0;
    private String color = "";

    /**
     * Constructor that fills in the instance variables with the designated arguments
     * @param n - name of the player
     * @param w - number of wins the player has
     * @param c - the color of the pieces for the player
     */
    public Player(String n, int w, String c) {
        name = n;
        wins = w;
        color = c;
    }
    /**
     * Returns the player's name
     * @return name - the name of the player
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the player's wins
     * @return wins - number of wins the player has
     */
    public int getWins() {
        return wins;
    }

    /**
     * Returns the player's color
     * @return color - the color of the pieces for the player
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the number of wins to w
     * @param w - the number of wins
     */
    public void setWins(int w) {
        wins = w;
    }
    
    /**
     * Sets the color of the player's pieces to c
     * @param c - the color of the pieces for the player
     */
    public void setColor(String c) {
        color = c;
    }
    
    /**
     * Increments the number of wins by 1
     */
    public void incrementWins() {
        wins++;
    }
}
