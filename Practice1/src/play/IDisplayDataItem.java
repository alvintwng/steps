/* 15-DeployingMaintaining */
package play;

public interface IDisplayDataItem {
    
    public boolean isDetailAvailable ();
    public String getDisplayDetail();
    public int getID();
    public String getDetailType();    // return simple text String or return the actual object?
    
}