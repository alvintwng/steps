/* 15-DeployingMaintaining */
package event;

import play.Player;
import play.Team;
import util.Settings;

public abstract class GameEvent {
    
    private Team theTeam;
    private Player thePlayer;
    private double theTime;
    int ballPos;

    
    public GameEvent(){
        
        // Eventually only for Dribble?

        
    }

    public Team getTheTeam() {
        return theTeam;
    }

    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public double getTheTime() {
        return theTime;
    }

    public void setTheTime(double theTime) {
        this.theTime = theTime;
    }
    
    public abstract GameEvent[] getNextEvents();
    
    public abstract boolean changePlayer();
    
    public abstract boolean changeTeam();

    public int getBallPos() {
        return ballPos;
    }

    public void setBallPos(int ballPos) {
        this.ballPos = ballPos + (Settings.PITCH_LENGTH - ballPos)/8;
    }
    
    public void reverseBallPos(){
        this.ballPos = Settings.PITCH_LENGTH - this.ballPos;
    }

}