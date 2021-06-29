/* 15-DeployingMaintaining */
package play;

public class DisplayString implements IDisplayDataItem {
    
    String displayDetail;
    int id = 0;
    public boolean isDetailAvailable () { return false;}
    public String getDisplayDetail() {return this.displayDetail;}
    public int getID(){return this.id;}
    public String getDetailType(){return "String";}
    
    public void setDisplayDetail(String displayDetail){
            this.displayDetail = displayDetail;
    }
    
    public DisplayString(String displayString){
        this.displayDetail = displayString;
    }
}