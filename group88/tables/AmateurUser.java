package group88.tables;

//amateurUser(UserID, GameID, collectionRate)
//(U12345,G10000,25%)
public class AmateurUser extends User{
    private Float CollectionRate;
    private final String GameID;

    public AmateurUser(String userID, Integer age, Float accountBalance, Float CollectionRate, String GameID) {
        super(userID, age,accountBalance);
        this.CollectionRate = CollectionRate;
        this.GameID = GameID;
    }

    public Float getCollectionRate(){ return CollectionRate; }

    public String getGameID(){ return GameID; }

    public void setCollectionRate(Float CollectionRate){
        this.CollectionRate = CollectionRate;
    }


}
