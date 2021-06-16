package soccer;

public class Team {
    
    private String teamName;
    private Player[] playerArray;
    
    // Determine the League Winner
    // 3. o store the number of points scored in the League
    private int pointsTotal;
    
    // 3c. method that increments the pointsTotal field by the value passed in. 
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

    /**
     * @return the pointsTotal
     */
    public int getPointsTotal() {
        return pointsTotal;
    }

    /**
     * @param pointsTotal the pointsTotal to set
     */
    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

}
