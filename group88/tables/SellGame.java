package group88.tables;

// SellGame(GameID, HubID, price)
// (G12345,H12345, 49.99)
public class SellGame {
    private final String GameID;
    private final String HubID;
    private Float Price;

    public SellGame(String gameID, String hubID, Float price) {
        this.GameID = gameID;
        this.HubID = hubID;
        this.Price = price;
    }

    public String getGameID(){ return GameID; }
    public String getHubID(){ return HubID; }
    public Float getPrice(){ return Price; }

    public void setPrice(Float Price){
        this.Price = Price;
    }

}
