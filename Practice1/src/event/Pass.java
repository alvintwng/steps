/* 15-DeployingMaintaining */
package event;

public class Pass extends GameEvent {
    
    public Pass(){
        
        super();
        
    }
    
    public String toString() {
        return "Pass attempt ";
    }
    
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = { new ReceivePass(), new GainPossession()};
        return theEvent;
    }
    
    public boolean changePlayer() {
        return false;
    }
    
    public boolean changeTeam() {
        return false;
    }
    
}