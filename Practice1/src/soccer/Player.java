package soccer;

public class Player {
    
    private String playerName;
    // 2a. Add an int goalsScored to Player.
    private int goalsScored;
    
    // 2c. increments the goals scored by a player.
    public void incGoalsScored() {
        this.goalsScored++;
    }
    
    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player() {}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * @return the goalsScored
     */
    public int getGoalsScored() {
        return goalsScored;
    }
    
}
