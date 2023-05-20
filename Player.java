/**
 * @author ruthwika
 *
 */
public class Player {
    private String name = "";
    private int wins = 0;
    private String color = "";

    /*
     * @param n - name of the player 
     * @param w - number of win
     * @param c - color 
     */
    public Player(String n, int w, String c) {
        name = n;
        wins = w;
        color = c;
    }
    // return the player name
    public String getName() {
        return name;
    }
    // return the numbers of win
    public int getWins() {
        return wins;
    }

    // return the color 
    public String getColor() {
        return color;
    }

    /*
     * @param w - number of win
     * set the number of win to w
     */
    public void setWins(int w) {
        wins = w;
    }
    /*
     * @param c - color 
     * set the color to c
     */
    public void setColor(String c) {
        color = c;
    }
    // increase number of win by 1 
    public void incrementWins() {
        wins++;
    }
}
