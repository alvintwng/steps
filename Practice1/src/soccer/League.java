package soccer;

import utility.GameUtils;

public class League {

    public static void main(String[] args) {
        
        League theLeague = new League();

        Team[] theTeams = theLeague.createTeams();
        Game[] theGames = theLeague.createGames(theTeams);

        // 8. Modify the main method of League to play all games.
        for (Game currGame: theGames) {
            currGame.playGame(); 
            System.out.println(currGame.getDescription());
        }
        
    }

    public Team[] createTeams() {

        // 4. Modify the League class to use the Player constructor. 
        Player player1 = new Player("George Eliot");
        Player player2 = new Player("Graham Greene");
        Player player3 = new Player("Geoffrey Chaucer");
        Player[] thePlayers = {player1, player2, player3};

        // 5f. the team name, the Player array are passed into the Team constructor
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

    // 7. add some more games to the Game array so that four games are played
    //  in total . Because there are only two teams, the teams will play each 
    //  other four times.
    public Game[] createGames(Team[] theTeams) {
        // 6b. createGames method of League to use this constructor.
        Game theGame = new Game(theTeams[0], theTeams[1]);
        Game theGame2 = new Game(theTeams[1], theTeams[0]);
        Game theGame3 = new Game(theTeams[0], theTeams[1]);
        Game theGame4 = new Game(theTeams[1], theTeams[0]);        
        Game[] theGames = {theGame, theGame2, theGame3, theGame4};
        return theGames;
    }

}
/* console
run:
Goal scored after 3.0 mins by Geoffrey Chaucer of The Greens
Goal scored after 5.0 mins by Robert Service of The Reds
Goal scored after 54.0 mins by Robbie Burns of The Reds
Goal scored after 57.0 mins by Rafael Sabatini of The Reds
Goal scored after 77.0 mins by Robert Service of The Reds

Goal scored after 2.0 mins by Robert Service of The Reds
Goal scored after 7.0 mins by Robbie Burns of The Reds

Goal scored after 8.0 mins by Graham Greene of The Greens
Goal scored after 43.0 mins by George Eliot of The Greens
Goal scored after 46.0 mins by Graham Greene of The Greens

Goal scored after 18.0 mins by Robbie Burns of The Reds
Goal scored after 34.0 mins by Robbie Burns of The Reds
*/