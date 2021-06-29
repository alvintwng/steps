/* 15-DeployingMaintaining */
package event;

public class Kickout extends GameEvent { // Special type of Pass
    
    public Kickout(){
     
    }
    
    public String toString() {
        return "Saved. Kickout ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = {new GainPossession(), new ReceivePass()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return true;
    }
    
        // Little bit of a hack maybe as ballPos not used.
    public void setBallPos(int ballPos) {
       //super.setBallPos(95); // relative to other team as team change not set yet (TODO should set teamchange first?)
       super.ballPos = 95;
    }
    
}