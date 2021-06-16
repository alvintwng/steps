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
        System.out.println("\nTeam Points");       
        
        // 6b.  check whether currTeam has more points than currBestTeam.
        //      Use the ternary operator for this operation.
        for (Team currTeam: theTeams){
            System.out.println(currTeam.getTeamName() + " : " + currTeam.getPointsTotal());
            currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal()?currTeam:currBestTeam;
        }
        
        System.out.println("Winner of the League is " + currBestTeam.getTeamName());
        
    }

}
/* console
run:
The Greens vs. The Reds
It's a draw! (0 - 0) 

The Reds vs. The Greens
Goal scored after 60.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 65.0 mins by George Eliot of The Greens
Goal scored after 70.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 84.0 mins by Graham Greene of The Greens
The Greens win (0 - 4) 

The Greens vs. The Reds
Goal scored after 40.0 mins by Rafael Sabatini of The Reds
Goal scored after 48.0 mins by Geoffrey Chaucer of The Greens
It's a draw! (1 - 1) 

The Reds vs. The Greens
It's a draw! (0 - 0) 


Team Points
The Greens : 5
The Reds : 3
Winner of the League is The Greens

*/