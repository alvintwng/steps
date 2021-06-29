/* 15-DeployingMaintaining */
package event;

import event.GameEvent;

// Perhaps break this into Tackle and InterceptPass

public class GainPossession extends GameEvent {
    
    public GainPossession(){
        
        super();
        
    }
    
    public String toString() {
        return "Won possession ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = { new GainPossession(), new Pass(), new Dribble(), new Shoot()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return true;
    }
    
    public boolean changeTeam() {
        return true;
    }
    
}