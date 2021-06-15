/* Practice 9-2: Adding Constructors
    add constructors to the classes so that objects can be instantiated and 
    have their data populated in a single line.
*/
package soccer;

public class Player {
    
    private String playerName;
    
    // 2. Add a constructor to the Player class that accepts a String parameter 
    // for the player's name.
    public Player(String playerName) {
        this.playerName = playerName;
    }
    
    // 3. Fix the errors that appear in the League class.
    public Player() {}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
}
