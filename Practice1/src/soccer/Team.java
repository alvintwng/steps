package soccer;

public class Team {
    
    private String teamName;
    private Player[] playerArray;
    
    // 5. Add two constructors to the Team class—the first for setting the team
    //  name and the second to pass in the array of players.
    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, Player[] players) {
        // 5d.  call the previously written constructor
        this(teamName);
        // 5c. Note that the this keyword is not necessary in this case, because
        // the names are different, but it aids readability.        
        this.playerArray = players;
    }
    
    // 5e. Add a default no-argument constructor below this constructor.
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

}
