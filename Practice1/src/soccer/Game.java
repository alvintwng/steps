/* Using Inheritance
Practice 12-2: Add a GameEvent Hierarchy
Will make the application more flexible by adding other event types (currently 
there is only the Goal class). Goal as one type of event, and will create 
`Possession` as another type of event. 
`Possession` will be used to represent the time that one or other of the teams
has possession of the ball and as such would need to store Team and Player just
like Goal does.
Both Goal and Possession will extend a new abstract GameEvent class that will 
also create.
*/
package soccer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
    
    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] goals;
    private LocalDateTime theDateTime;
    
    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDateTime = theDateTime;
    }
    
    //3b. replace all occurrences of Goal with GameEvent. Click Edit > Replace.
    //3c. EXCEPT for the occurrence immediately after new 
     //3f. replace  currGoal with currEvent; getGoal with getEvent; setGoals with setEvent
    public void playGame() {
        ArrayList <GameEvent> eventList = new ArrayList();
        GameEvent currEvent;
        for (int i = 1; i <=90; i++){
            
            if (Math.random() > 0.95){
                //4b. Replace the current line that instantiates a Goal
                currEvent = Math.random() > 0.6?new Goal():new Possession();
                currEvent.setTheTeam(Math.random() > 0.5?homeTeam: awayTeam);
                currEvent.setThePlayer(currEvent.getTheTeam().
                getPlayerArray()[(int)(Math.random() * currEvent.getTheTeam().getPlayerArray().length)]);
                currEvent.setTheTime(i);
                eventList.add(currEvent);
                //System.out.println(i);
            }
            this.goals = new GameEvent[eventList.size()];
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
         
        for (GameEvent currEvent: this.getEvents()) {
            
            if (currEvent.getTheTeam()== homeTeam) {
                homeTeamGoals++;
                homeTeam.incGoalsTotal(1);
            } else {
                awayTeamGoals++;
                awayTeam.incGoalsTotal(1);
            }
            
            /* Practice 12-2. Modify the text printed */
            returnString.append(currEvent +" after "
            + currEvent.getTheTime() + " mins by "
            + currEvent.getThePlayer().getPlayerName() + " of "
            + currEvent.getTheTeam().getTeamName() +
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

    public GameEvent[] getEvents() {
        return goals;
    }

    public void setEvents(GameEvent[] goals) {
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

// 4d. since currEvent does not have a toString method, it is being called on
// Object (the parent of all objects). The toString method on Object tells us
// the name of the class (fully qualified plus a hex value). 

/* console
...

The Swallows vs. The Crows
Date: 2021-08-04
soccer.Goal@3159c4b8 after 34.0 mins by Boris Pasternik of The Crows
soccer.Goal@73846619 after 55.0 mins by Wilkie Collins of The Crows
The Crows win (0 - 2) 


Team Points
The Robins : 1 : 7
The Crows : 2 : 6
The Swallows : 3 : 9
Winner of the League is The Swallows
*/