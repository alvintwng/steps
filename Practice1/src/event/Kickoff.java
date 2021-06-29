/* 15-DeployingMaintaining */
package event;

public class Kickoff extends GameEvent {  // Really it's a special Pass
    
    public Kickoff() {

    }

    public String toString() {
        return "Kickoff ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = {new ReceivePass(), new GainPossession()};
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
       //super.setBallPos(50);
       super.ballPos = 50;
    }
    
}