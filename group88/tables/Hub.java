package group88.tables;

//Hub(HubID, HubArea)
//(H12345, US)
public class Hub {
    private final String HubID;
    private String HubArea;

    public Hub(String hubID, String hubArea) {
        this.HubID = hubID;
        this.HubArea = hubArea;
    }

    public String getHubID(){
        return HubID;
    }

    public String getHubArea(){
        return HubArea;
    }

    public void setHubArea(String HubArea){
        this.HubArea = HubArea;;
    }



}
