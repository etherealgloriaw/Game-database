package group88.tables;

//Community(CommunityID, HubID) hubID cannot be NULL
//(C12345,H12345)
public class Community {
    private String CommunityID;
    private final String HubID;

    public Community(String communityID, String hubID) {
        this.CommunityID = communityID;
        this.HubID = hubID;
    }

    public String getCommunityID(){
        return CommunityID;
    }

    public String getHubID(){
        return HubID;
    }

    public void setCommunityID(String communityID){
        this.CommunityID = communityID;
    }
}
