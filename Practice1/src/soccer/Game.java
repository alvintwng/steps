package soccer;

import utility.GameUtils;

public class Game {
    
    public Team homeTeam;
    public Team awayTeam;
    public Goal[] goals;
    
    public void playGame() {
        /* Practice 8-2, Step 1e. Add code to initialize the array currGame.goals to a random size */
        int numberOfGoals = (int)(Math.random() * 7);
        Goal[] theGoals = new Goal[numberOfGoals];
        this.goals = theGoals;
        GameUtils.addGameGoals(this);        
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