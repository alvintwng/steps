// Practice 11-1: Iterating Through Data

package utility;

import java.util.ArrayList;
import java.util.StringTokenizer;
import soccer.Player;

public class PlayerDatabase {
    
    /* Practice 11-1. 2a.Declare an ArrayList here */
    private ArrayList <Player> players;
    
    /* Practice 11-1. 2e.Add Constructor here */
    public PlayerDatabase() {
        //2d. to iterate through the names and add each to the ArrayList. 
        StringTokenizer authorTokens = new StringTokenizer(authorList, ",");
        players = new ArrayList ();
        while (authorTokens.hasMoreTokens()) {
            players.add(new Player(authorTokens.nextToken()));
        }
    }
    
    // 3. method to return an arbitrarily sized team
    public Player[] getTeam(int numberOfPlayers) {
        Player[] teamPlayers = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            int playerIndex = (int) (Math.random() * players.size());
            teamPlayers[i] = players.get(playerIndex);
            // 3e. Remove the player just selected from the players ArrayList
            players.remove(playerIndex);
        }
        return teamPlayers;
    }
        
String authorList = 
"Agatha Christie," + 
"Alan Patton," +
"Alexander Solzhenitsyn," +
"Arthur Conan Doyle," +
"Anthony Trollope," +
"Baroness Orczy," +          
"Brendan Behan," +      
"Brian Moore," +
"Boris Pasternik," +
"Charles Dickens," +    
"Charlotte Bronte," +
"Dorothy Parker," +
"Emile Zola," +
"Frank O'Connor," +        
"Geoffrey Chaucer," +
"George Eliot," +
"G. K. Chesterton," +
"Graham Green," +
"Henry James," +
"James Joyce," +        
"J. M. Synge," + 
"J. R. Tolkien," +
"Jane Austin," +
"Leo Tolstoy," +
"Liam O'Flaherty," +
"Marcel Proust," +
"Mark Twain," +
"Oscar Wilde," +
"O. Henry," +
"Samuel Beckett," +
"Sean O'Casey," +
"William Shakespeare," +        
"William Makepeace Thackeray," +
"W. B. Yeats," +
"Wilkie Collins";
    
}
