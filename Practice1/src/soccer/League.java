/* 7.
This class needs to have a method main so that it can be run as a console application.
a. Right-click the soccer package and select New > Other.
b. In the New File dialog box, select Categories > Java, then 
    select File Types: > Java Main Class, and click Next.
8.
Using the classes that you have created means populating them with data. So you need to:
- Instantiate a number of Player objects for each Team.
- Instantiate some Team objects to play games.
- Instantiate some Game objects to represent those games.
- For each goal in a game, instantiate a Goal object and add it to the Goal array in the appropriate Game object.
*/
package soccer;

public class League {

    public static void main(String[] args) {
  
        // Create team1      
        Player player1 = new Player();
        player1.playerName = "George Eliot";
        Player player2 = new Player();
        player2.playerName = "Graham Greene";
        Player player3 = new Player();
        player3.playerName = "Geoffrey Chaucer";
        Player[] thePlayers = {player1, player2, player3 };
        
        Team team1 = new Team();
        team1.teamName = "The Greens";
        team1.playerArray = thePlayers;
        
        
        // Create team2
        Team team2 = new Team();
        team2.teamName = "The Reds";
        team2.playerArray = new Player[3];
        team2.playerArray[0] = new Player();
        team2.playerArray[0].playerName = "Robert Service";
        team2.playerArray[1] = new Player();
        team2.playerArray[1].playerName = "Robbie Burns";
        team2.playerArray[2] = new Player();
        team2.playerArray[2].playerName = "Rafael Sabatini";
        
        
        for (Player thePlayer: team1.playerArray) {
            System.out.println(thePlayer.playerName);
        }  
        for (Player thePlayer: team2.playerArray) {
            System.out.println(thePlayer.playerName);
        } 

    }   
}