package soccer;

import utility.GameUtils;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams();
        Game[] theGames = theLeague.createGames(theTeams);

        for (Game currGame: theGames){
            currGame.playGame();
            System.out.println(currGame.getDescription());
        }
        
        // 5d. a call to the showBestTeam method.
        theLeague.showBestTeam(theTeams);

    }

    public Team[] createTeams() {

        Player player1 = new Player("George Eliot");
        Player player2 = new Player("Graham Greene");
        Player player3 = new Player("Geoffrey Chaucer");
        Player[] thePlayers = {player1, player2, player3};

        Team team1 = new Team("The Greens", thePlayers);

        // Create team2
        Team team2 = new Team();
        team2.setTeamName("The Reds");
        team2.setPlayerArray(new Player[3]);
        team2.getPlayerArray()[0] = new Player("Robert Service");
        team2.getPlayerArray()[1] = new Player("Robbie Burns");
        team2.getPlayerArray()[2] = new Player("Rafael Sabatini");

        Team[] theTeams = {team1, team2};
        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {
        Game theGame = new Game(theTeams[0], theTeams[1]);
        Game theGame2 = new Game(theTeams[1], theTeams[0]);
        Game theGame3 = new Game(theTeams[0], theTeams[1]);
        Game theGame4 = new Game(theTeams[1], theTeams[0]);
        Game[] theGames = {theGame, theGame2, theGame3, theGame4};
        return theGames;
    }
    
    //5. method in League to show the points scored by each team.
    public void showBestTeam(Team[] theTeams) {
        // 6 to determine which team actually won the league.
        Team currBestTeam = theTeams[0];
        System.out.println("Winner of the league is " + 
                currBestTeam.getTeamName());
        
        System.out.println("\nTeam Points");
        for (Team currTeam: theTeams) {
            System.out.println(currTeam.getTeamName() + ":" +
                    currTeam.getPointsTotal());
        }
    }

}

/* console
run:
The Greens vs. The Reds
Goal scored after 31.0 mins by Robert Service of The Reds
Goal scored after 43.0 mins by Robert Service of The Reds
The Reds win (0 - 2) 

The Reds vs. The Greens
It's a draw! (0 - 0) 

The Greens vs. The Reds
It's a draw! (0 - 0) 

The Reds vs. The Greens
It's a draw! (0 - 0) 

Winner of the league is The Greens

Team Points
The Greens:3
The Reds:5
*/