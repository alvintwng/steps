/* Using Interfaces
Practice 13-1: Overriding the toString Method

The new class hierarchy with a GameEvent superclass and two subclasses
Possession and Goal. 
One of the advantages of this approach is that common code can be put in the 
superclass and code specific to either Possession or Goal can be put in the 
class itself. 
Then, by using GameEvent as the reference to objects of either subclass, 
polymorphism ensures that the method will be called on the actual object.
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
    
    public void playGame() {
        ArrayList <GameEvent> eventList = new ArrayList();
        GameEvent currEvent;
        for (int i = 1; i <=90; i++){
            // 3c. Goal or Possession are only being chosen WAS 95% of the time.
            /* Practice 13-1. Change expression to Math.random > 0.8 */
            if (Math.random() > 0.8){
                currEvent = Math.random() > 0.8?new Goal():new Possession();
                /* Practice 13-1. Change first part of ternary operator toMath.random > 0.8 */
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
            
            // 3. so that it correctly totals only Goal objects as goals.
            /* Practice 13-1. Start if block here to determine if currEvent is a Goal */
            if (currEvent instanceof Goal) {
                if (currEvent.getTheTeam()== homeTeam) {
                    homeTeamGoals++;
                    homeTeam.incGoalsTotal(1);
                } else {
                    awayTeamGoals++;
                    awayTeam.incGoalsTotal(1);
                }
            /* Practice 13-1. End if block here to determine if currEvent is a Goal */
            }
            
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
/* Console
The league is scheduled to run for 1 month(s), and 4 day(s)

The Robins vs. The Crows
Date: 2021-07-01
Possession after 4.0 mins by O. Henry of The Crows
Possession after 11.0 mins by Leo Tolstoy of The Robins
Goal scored after 13.0 mins by Frank O'Connor of The Robins
Possession after 26.0 mins by Wilkie Collins of The Robins
Possession after 39.0 mins by Frank O'Connor of The Robins
Goal scored after 41.0 mins by Brendan Behan of The Crows
Possession after 42.0 mins by Brendan Behan of The Crows
Possession after 51.0 mins by Wilkie Collins of The Robins
Goal scored after 53.0 mins by Wilkie Collins of The Robins
Possession after 55.0 mins by Oscar Wilde of The Crows
Possession after 57.0 mins by Sean O'Casey of The Crows
Possession after 65.0 mins by Leo Tolstoy of The Robins
Possession after 66.0 mins by O. Henry of The Crows
Possession after 68.0 mins by Sean O'Casey of The Crows
Goal scored after 79.0 mins by Geoffrey Chaucer of The Robins
Possession after 85.0 mins by Geoffrey Chaucer of The Robins
The Robins win (3 - 1) 

...
*/