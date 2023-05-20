/**
 * @author ruthwika
 *
 */
public class Player {
    private String name = "";
    private int wins = 0;
    private String color = "";

    public Player(String n, int w, String c) {
        name = n;
        wins = w;
        color = c;
    }
    public String getName() {
        return name;
    }
    public int getWins() {
        return wins;
    }
    public String getColor() {
        return color;
    }
    public void setWins(int w) {
        wins = w;
    }
    public void setColor(String c) {
        color = c;
    }
    public void incrementWins() {
        wins++;
    }
}
