/* Practice 12-1: Creating a Class Hierarchy
    class hierarchies give you a way of not only sharing like behaviors in 
    different classes, but they also allow to use a common reference type 
    for a set of objects of related but different types.
*/
package soccer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import utility.GameUtils;

public class Game {
    
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;
    private LocalDateTime theDateTime;
    
    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = theDateTime;
    }
    
    // 4c Remove the method  //  4d. Delete the GameUtils class in utlity package.
    //public void playGame(int maxGoals) {       
    //    int numberOfGoals = (int)(Math.random() * maxGoals + 1);
    //    Goal[] theGoals = new Goal[numberOfGoals];
    //    this.setGoals(theGoals);
    //    GameUtils.addGameGoals(this);        
    //}
    
    public void playGame() {
        /* Practice 12-1. Remove the following line */
        //playGame(6);
        
        // 3c.c ArrayList useful for adding Goal objects randomly 
        ArrayList <Goal> eventList = new ArrayList();
        Goal currEvent;
        // 3a.  add goals at various (randomly generated) intervals in a game.
        for (int i = 1; i <= 90; i++) {
            if (Math.random() > 0.95) {
                currEvent = new Goal();
                currEvent.setTheTeam(Math.random() > 0.5?homeTeam:awayTeam);
                currEvent.setThePlayer(currEvent.getTheTeam().
                getPlayerArray()[ (int)(Math.random() * 
                        currEvent.getTheTeam().getPlayerArray().length )] );
                currEvent.setTheTime(i);
                eventList.add(currEvent);
                //System.out.println(i); //3b.
            }
            // 3n. create the array (the size based on the size of the ArrayList.),
            // use the ArrayList to copy over the elements from the ArrayList to the array
            this.goals = new Goal[eventList.size()];
            eventList.toArray(goals);
        }
    }
    
    public String getDescription() {
                       
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        StringBuilder returnString = new StringBuilder();
        
        returnString.append(this.getHomeTeam().getTeamName() + " vs. " +
        this.getAwayTeam().getTeamName() + "\n" + 
               "Date: " + this.getTheDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
         
        for (Goal currGoal: this.getGoals()) {
            
            if (currGoal.getTheTeam()== homeTeam) {
                homeTeamGoals++;
                homeTeam.incGoalsTotal(1);
            } else {
                awayTeamGoals++;
                awayTeam.incGoalsTotal(1);
            }
            
            returnString.append("Goal scored after "
            + currGoal.getTheTime() + " mins by "
            + currGoal.getThePlayer().getPlayerName() + " of "
            + currGoal.getTheTeam().getTeamName() +
              "\n");
        }
        
        if (homeTeamGoals == awayTeamGoals) {
            returnString.append("It's a draw!");
            this.homeTeam.incPointsTotal(1);
            this.awayTeam.incPointsTotal(1);
        } else if (homeTeamGoals > awayTeamGoals) {
            returnString.append(homeTeam.getTeamName() + " win");
            this.homeTeam.incPointsTotal(1);
        } else {
            returnString.append(awayTeam.getTeamName() + " win");
            this.awayTeam.incPointsTotal(1);
        }
        returnString.append(" (" + homeTeamGoals + " - " + awayTeamGoals + ") \n");
        
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

    public LocalDateTime getLocalDateTime() {
        return getTheDateTime();
    }

    public void setLocalDateTime(LocalDateTime theDateTime) {
        this.setTheDateTime(theDateTime);
    }

    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }
      
}