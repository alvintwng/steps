/* Practice 14-1: Overview – Adding Exception Handling
    5a to report the exact problem with PlayerDatabase.
 */
package utility;

public class PlayerDatabaseException extends Exception {
    
    public PlayerDatabaseException() {}
    
    public PlayerDatabaseException(String message) {
        super(message);
    }
}
