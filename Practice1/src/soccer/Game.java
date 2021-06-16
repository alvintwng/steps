// Practice 10-1: Using Conditionals
package soccer;

import utility.GameUtils;

public class Game {

    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;

    public Game (Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    
    public void playGame(int maxGoals) {

        int numberOfGoals = (int)(Math.random() * (maxGoals + 1));
        Goal[] theGoals = new Goal[numberOfGoals];
        this.setGoals(theGoals);
        GameUtils.addGameGoals(this);        
    }
    
    public void playGame() {
        playGame(6);
    }
    
    public String getDescription() {
        // 2. Set up variables to hold the number of goals scored for each team.
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        StringBuilder returnString = new StringBuilder();
        
        //2f. to show which teams are playing.
        returnString.append(homeTeam.getTeamName() + " vs. " + 
        awayTeam.getTeamName() + "\n");
        
        for (Goal currGoal: this.getGoals()) {
            
            //2b. test to determine which team scored each goal
            if (currGoal.getTheTeam() == homeTeam) {
                homeTeamGoals++;
            }
            else {
                awayTeamGoals++;
            }
            
            returnString.append("Goal scored after "
            + currGoal.getTheTime() + " mins by "
            + currGoal.getThePlayer().getPlayerName() + " of "
            + currGoal.getTheTeam().getTeamName() +
              "\n");   
        }
        
        //2c. if the game was a draw or, if there was a winner, who the winner was.
        if (homeTeamGoals == awayTeamGoals) {
            returnString.append("It's a draw!");
            //4. to increment this field when you have determined a game winner.
            homeTeam.incPointsTotal(1);
            awayTeam.incPointsTotal(1);
        } else if (homeTeamGoals > awayTeamGoals) {
            returnString.append(homeTeam.getTeamName() + " win");
            homeTeam.incPointsTotal(2);
        } else {
            returnString.append(awayTeam.getTeamName() + " win");
            awayTeam.incPointsTotal(2);
        }

        returnString.append(" ("+ homeTeamGoals + " - " + awayTeamGoals + ") \n");
        
        return returnString.toString();
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Goal[] getGoals() {
        return goals;
    }

    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }
    
}