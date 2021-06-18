package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.StringTokenizer;
import utility.PlayerDatabase;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 5);
        Game[] theGames = theLeague.createGames(theTeams);

        /* Practice 11-2. Print the League announcement here */
        System.out.println(theLeague.getLeagueAnnouncement(theGames));
        for (Game currGame: theGames){
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }
        
        theLeague.showBestTeam(theTeams);

    }

    public Team[] createTeams(String teamNames, int teamSize) {

        PlayerDatabase playerDB = new PlayerDatabase();
        
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        for (int i =0; i < theTeams.length; i++){
             theTeams[i] = new Team(teamNameTokens.nextToken(), playerDB.getTeam(teamSize));
        }
       

        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        /* Practice 11-2. Add a line to declare and initialize daysBetweenGames variable */
        int daysBetweenGames = 0;
        
        ArrayList theGames = new ArrayList();
        
        for (Team homeTeam: theTeams){
            for (Team awayTeam: theTeams){
               if (homeTeam != awayTeam) {
                   /* Practice 11-2. Increment daysBetweenGames here */
                   // 6c. changing the length of time required to run the league changes.
                   daysBetweenGames += 7;
                   /* Practice 11-2. Modify the statement below to add pass LocalDateTime into constructor */
                   theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
               } 
            
            }
        }
        
        
        
        return (Game[]) theGames.toArray(new Game[1]);
    }
    
    public void showBestTeam(Team[] theTeams) {
        Team currBestTeam = theTeams[0];  
        System.out.println("\nTeam Points");       
           
        for (Team currTeam: theTeams){
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : "
                     + currTeam.getGoalsTotal());
            currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal()?currTeam:currBestTeam;
            if (currTeam.getPointsTotal() > currBestTeam.getPointsTotal()){
                currBestTeam = currTeam;
            } else if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()){
                if (currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()){
                currBestTeam = currTeam;
                }
            }
        }
        
        System.out.println("Winner of the League is " + currBestTeam.getTeamName());
        
    }
    
    /* Practice 11-2. Add the getLeagueAnnouncement() method here */
    //  that calculates how long the League lasts.
    public String getLeagueAnnouncement(Game[] theGames){
        
        Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(),
        theGames[theGames.length - 1].getTheDateTime().toLocalDate());

        return "The League is scheduled to run for " +
        thePeriod.getMonths() + " month(s), and " +
        thePeriod.getDays() + " day(s)\n";
    }

}

/* Console
run:
The League is scheduled to run for 1 month(s), and 5 day(s)

The Robins vs. The Crows
Date 2021-06-25
Goal scored after 57.0 mins by Oscar Wilde of The Robins
The Robins win (1 - 0) 

...
*/