// Practice 10-2: Debugging
/* resolved the report the first one found. would be to use the number of goals
    scored by a team to differentiate between two teams which are otherwise equal.
*/
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
    
    //2. Use the debugger to follow the execution of the showBestTeam method.
    public void showBestTeam(Team[] theTeams) {
        Team currBestTeam = theTeams[0]; 
        
        // 2a. To debug. Set the breakpoint 
        System.out.println("\nTeam Points");
        //2c. Variables: `this` (the `League` object), `theTeams` (the `Team` array passed
        //  into the method), and `currBestTeam` (a local variable in the method).
        
        //2e. Click Step Over (F8) 
        
        //3. Set Watch variables for currTeam.pointsTotal and currBestTeam.pointsTotal.
        //3a. Click Create New Watch and, in the dialog box, type in currTeam.teamName. 
        
        for (Team currTeam: theTeams){
            /* Practice 10-2. Modify the line below to print out the goalsTotal for the current team also */
            // 5d. now prints the goalsTotal
            System.out.println(currTeam.getTeamName() + " : " +
                    currTeam.getPointsTotal() + ":" + currTeam.getGoalsTotal());
            //currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal()?currTeam:currBestTeam;
            /* Practice 10-2. 5. Remove ternary statement above then add a replacement if statement here */
            if (currTeam.getPointsTotal() > currBestTeam.getPointsTotal()) {
                currBestTeam = currTeam;
            }
            else if (currTeam.getPointsTotal() == currBestTeam.getPointsTotal()) {
                if (currTeam.getGoalsTotal() > currBestTeam.getGoalsTotal()) {
                    currBestTeam = currTeam;
                }
            }
        }
        //6b. try debugging, add Watch Variables for currTeam.goalsTotal and currBestTeam.goalsTotal 
        
        System.out.println("Winner of the League is " + currBestTeam.getTeamName());
        
        
    }

}

/* console
debug:
The Greens vs. The Reds
It's a draw! (0 - 0) 

The Reds vs. The Greens
Goal scored after 27.0 mins by Robert Service of The Reds
Goal scored after 42.0 mins by Graham Greene of The Greens
Goal scored after 54.0 mins by Graham Greene of The Greens
The Greens win (1 - 2) 

The Greens vs. The Reds
Goal scored after 10.0 mins by Graham Greene of The Greens
Goal scored after 47.0 mins by Robert Service of The Reds
Goal scored after 59.0 mins by Rafael Sabatini of The Reds
Goal scored after 85.0 mins by George Eliot of The Greens
It's a draw! (2 - 2) 

The Reds vs. The Greens
Goal scored after 38.0 mins by Robert Service of The Reds
The Reds win (1 - 0) 


Team Points
The Greens : 4 : 4
The Reds : 4 : 4
Winner of the League is The Greens
*/