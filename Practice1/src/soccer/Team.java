package soccer;

public class Team {
    
    private String teamName;
    private Player[] playerArray;
    private int pointsTotal;
    
    /* Practice 10-2. 4a. Add goalsTotal attribute here */
    private int goalsTotal;
    
    /* Practice 10-2. 4b. Add incGoalsTotal() method here */
    public void incGoalsTotal(int goals) {
        this.goalsTotal = this.goalsTotal + goals;
    }
    
    public void incPointsTotal(int pointsTotal) {
        this.pointsTotal += pointsTotal;
    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, Player[] players) {
        this(teamName);       
        this.playerArray = players;
    }

    public Team() {}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    /**
     * @return the goalsTotal
     */
    public int getGoalsTotal() {
        return goalsTotal;
    }

    /**
     * @param goalsTotal the goalsTotal to set
     */
    public void setGoalsTotal(int goalsTotal) {
        this.goalsTotal = goalsTotal;
    }

}
