// Practice 11-1: Iterating Through Data
package soccer;

import java.util.ArrayList;
import java.util.StringTokenizer;
import utility.PlayerDatabase;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        //6 Modified the call to getTeams to pass in team names and team size.
        Team[] theTeams = theLeague.createTeams("The Robins,The Crows,The Swallows", 5);
        Game[] theGames = theLeague.createGames(theTeams);

        for (Game currGame: theGames){
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }
        
        theLeague.showBestTeam(theTeams);

    }

    // 5. more general-purpose method by passing in team names and team sizes.
    public Team[] createTeams(String teamNames, int teamSize) {
        
        // 4b. Instantiate a new PlayerDatabase object
        PlayerDatabase playerDB = new PlayerDatabase();
        
        // 5b iterate through however many teams have been specified.
        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];
        for (int i = 0; i < theTeams.length; i++) {
            theTeams[i] = new Team(teamNameTokens.nextToken(),
                playerDB.getTeam(teamSize));
        }

        /* Practice 11-1. Remove the code below that creates The Greens and The Reds */

        /* Practice 11-1. Remove the above code that creates The Greens and The Reds */
        
        // 4c. instantiate team1 and team2 to use playerDB for the players. 
//        Team team1 = new Team("The Greens", playerDB.getTeam(3));
//        Team team2 = new Team("The Reds", playerDB.getTeam(3));
//        Team[] theTeams = {team1, team2};

        return theTeams;
    }

    // 7. Generate All-Play-All Set of Games
    public Game[] createGames(Team[] theTeams) {
        /*
        Game theGame = new Game(theTeams[0], theTeams[1]);
        Game theGame2 = new Game(theTeams[1], theTeams[0]);
        Game theGame3 = new Game(theTeams[0], theTeams[1]);
        Game theGame4 = new Game(theTeams[1], theTeams[0]);
        Game[] theGames = {theGame, theGame2, theGame3, theGame4};
        */
        
        // 7b.Instantiate an ArrayList to hold the games that created
        ArrayList<Game> theGames = new ArrayList();
        for (Team homeTeam: theTeams) {
            for (Team awayTeam: theTeams) {
                if (homeTeam!=awayTeam) {
                    theGames.add(new Game(homeTeam, awayTeam));
                }
            } 
        }

        //7f. return an array, not an ArrayList.
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

}
/* console
run:
The Robins vs. The Crows
Goal scored after 3.0 mins by Liam O'Flaherty of The Robins
The Robins win (1 - 0) 

The Robins vs. The Swallows
It's a draw! (0 - 0) 

The Crows vs. The Robins
Goal scored after 1.0 mins by O. Henry of The Crows
Goal scored after 2.0 mins by Brian Moore of The Robins
Goal scored after 7.0 mins by Brian Moore of The Robins
Goal scored after 65.0 mins by Frank O'Connor of The Robins
Goal scored after 69.0 mins by Agatha Christie of The Robins
Goal scored after 79.0 mins by Wilkie Collins of The Crows
The Robins win (2 - 4) 

The Crows vs. The Swallows
Goal scored after 46.0 mins by Leo Tolstoy of The Swallows
Goal scored after 70.0 mins by James Joyce of The Crows
It's a draw! (1 - 1) 

The Swallows vs. The Robins
Goal scored after 5.0 mins by Arthur Conan Doyle of The Robins
Goal scored after 88.0 mins by Frank O'Connor of The Robins
The Robins win (0 - 2) 

The Swallows vs. The Crows
It's a draw! (0 - 0) 


Team Points
The Robins : 4 : 7
The Crows : 2 : 3
The Swallows : 3 : 1
Winner of the League is The Robins
*/