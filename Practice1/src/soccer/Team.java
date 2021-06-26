/* Using Interface
Practice 13-2: Implementing an Interface

implement the Comparable interface so that you can order the elements in an array.

2a. In Javadocs, look up the sort method of the Arrays class. 
Notice that it is an overloaded method. 
look at the sort method that takes an Object array (sort(Object[] a)).
Click the link to the Comparable interface. 
In order for the sort method to be able to determine the correct order for, say, the Team array, 
must implement the Comparable interface in the Team class.

*/
package soccer;

/* Practice 13-2. Change class declaration so that it implements Comparable */
// 2. Implement the Comparable interface for the Team class.
public class Team implements Comparable {
    
    private String teamName;
    private Player[] playerArray;
    private int pointsTotal;
    private int goalsTotal;

    /* Practice 13-2. Add the compareTo() method here */
    //2g. cast the Object reference theTeam to a Team reference
    public int compareTo(Object theTeam){
        int returnValue = -1;
        if (this.getPointsTotal()< ((Team)theTeam).getPointsTotal()) {
            returnValue = 1;
        } else if (this.getPointsTotal() == ((Team)theTeam).getPointsTotal()){
            if (this.getGoalsTotal()< ((Team)theTeam).getGoalsTotal()) {
                returnValue = 1;
            } 
        }
        return returnValue;
    }
    
    public void incGoalsTotal(int goals){
        this.setGoalsTotal(this.getGoalsTotal() + goals);
    }

    public void incPointsTotal(int points){
        this.pointsTotal += points;
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

    public int getGoalsTotal() {
        return goalsTotal;
    }

    public void setGoalsTotal(int goalsTotal) {
        this.goalsTotal = goalsTotal;
    }

}
