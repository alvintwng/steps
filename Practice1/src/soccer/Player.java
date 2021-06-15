/* Practice 9-1: Encapsulating Attributes
use the NetBeans refactor feature to encapsulate all the classes in application.

2a. Right-click Player and select Refactor > Encapsulate Fields.
2b. In the Encapsulate Fields dialog box, select playerName as the field to 
    encapsulate (it will be selected by default), and check the boxes to create 
    the getPlayerName method and the setPlayerName method. 
2c. Click Refactor (accepting the other options).
*/
package soccer;

public class Player {
    
    private String playerName;

    /**
     * @return the playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @param playerName the playerName to set
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
}
