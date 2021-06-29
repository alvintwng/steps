/* 15-DeployingMaintaining */
package play;

public class Player implements Comparable {
    
    private String playerName;
    private int goalsScored;
    
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

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    // TODO - possibly remove this so can sort based on Lambda expression
    // If so, need to use 1.8 Java for GlassFish
    public int compareTo(Object thePlayer){

        if (this.getGoalsScored() < ((Player)thePlayer).getGoalsScored()){
            return 1;
        }
        else {
            return -1;

        }
    }
    
}
