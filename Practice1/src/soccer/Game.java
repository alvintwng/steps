// Practice 8-3: Creating Overloaded Methods
/* To allow for either accepting the default (maximum six goals), or specifying 
    a different maximum, you need to overload the playGame method in Game. 
    This means that there will be two methods, one that receives no parameters,
    and one that receives the parameter specifying the maximum number of goals.
*/
package soccer;

import utility.GameUtils;

public class Game {
    
    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;
    
    public void playGame(int maxGoals) {

        int numberOfGoals = (int)(Math.random() * (maxGoals + 1));
        Goal[] theGoals = new Goal[numberOfGoals];
        this.goals = theGoals;
        GameUtils.addGameGoals(this);        
    }
    
    // 3b. playGame method that is overloaded.
    public void playGame() {
        playGame(6);
    }
    
    public String getDescription() {
        StringBuilder returnString = new StringBuilder();
        for (Goal currGoal: this.goals) {
            returnString.append("Goal scored after "
            + currGoal.theTime + " mins by "
            + currGoal.thePlayer.playerName + " of "
            + currGoal.theTeam.teamName +
              "\n");
        }
        return returnString.toString();
    }
      
}