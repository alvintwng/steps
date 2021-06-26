/* Using Interfaces
Practice 13-3: Using a Lambda Expression for Sorting (Optional Practice)

order the players based on their goal scoring. However, 
instead of having Player implement compareTo, you will use a lambda expression.
*/
package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import utility.PlayerDatabase;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 5);
        Game[] theGames = theLeague.createGames(theTeams);

        System.out.println(theLeague.getLeagueAnnouncement(theGames));
        for (Game currGame: theGames){
            currGame.playGame();
            //break;
            System.out.println(currGame.getDescription());
        }
        
        theLeague.showBestTeam(theTeams);
        theLeague.showBestPlayers(theTeams);

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
        int daysBetweenGames = 0;
        
        ArrayList theGames = new ArrayList();
        
        for (Team homeTeam: theTeams){
            for (Team awayTeam: theTeams){
               if (homeTeam != awayTeam) {
                   daysBetweenGames += 7;
                   theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
               } 
            
            }
        }

        return (Game[]) theGames.toArray(new Game[1]);
    }

    public void showBestTeam(Team[] theTeams) {
        
        Arrays.sort(theTeams);
        Team currBestTeam = theTeams[0];  
        System.out.println("\nTeam Points");       
           
        for (Team currTeam: theTeams){
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : "
                     + currTeam.getGoalsTotal());

        }
        
        System.out.println("Winner of the League is " + currBestTeam.getTeamName());
        
    }
 
    public String getLeagueAnnouncement(Game[] theGames){
        
        Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(), 
        theGames[theGames.length - 1].getTheDateTime().toLocalDate());
        
        return "The league is scheduled to run for " +
        thePeriod.getMonths() + " month(s), and " +
        thePeriod.getDays() + " day(s)\n";
    }
    
    //4a. displays players in order by how many goals they scored.
    //4b. There are a number of ways to do this. Here is some code that uses 
    //the addAll method of ArrayList and the asList method of Arrays:
    public void showBestPlayers(Team[] theTeams) {
        ArrayList <Player> thePlayers = new ArrayList();
        for (Team currTeam: theTeams) {
            thePlayers.addAll(Arrays.asList(currTeam.getPlayerArray()));
        }
        
        System.out.println("\n\nBest Players");
        
        //5. lambda expression to pass into the Collections.sort method.
        Collections.sort(thePlayers, (p1, p2) ->
                Double.valueOf(p2.getGoalsScored()).compareTo
                (Double.valueOf(p1.getGoalsScored())));

        
        for (Player currPlayer: thePlayers) {
            System.out.println(currPlayer.getPlayerName() + " : " + 
                    currPlayer.getGoalsScored());
        }
    }
}
/* console
Team Points
The Crows : 3 : 7
The Robins : 2 : 10
The Swallows : 1 : 8
Winner of the League is The Crows


Best Players
Boris Pasternik : 3
Geoffrey Chaucer : 3
James Joyce : 3
J. R. Tolkien : 2
Charlotte Bronte : 2
Alexander Solzhenitsyn : 2
Wilkie Collins : 2
Marcel Proust : 2
J. M. Synge : 1
Leo Tolstoy : 1
Charles Dickens : 1
Agatha Christie : 1
G. K. Chesterton : 1
Baroness Orczy : 1
Alan Patton : 0
BUILD SUCCESSFUL (total time: 0 seconds)
*/