package group88.tables;

//Game(GameID,gameName,rate,version) rate is from 0-5
//(G12345, THE SIMES 4, 4.5, 12.0)
public class Game {
    private final String GameID;
    private String gameName;
    private Float Rate;
    private Float Version;

    public Game(String GameID, String gameName, Float Rate, Float Version) {
        this.GameID = GameID;
        this.gameName = gameName;
        this.Rate = Rate;
        this.Version = Version;
    }

    public String getGameID(){ return GameID; }

    public String getGameName(){
        return gameName;
    }

    public Float getRate(){
        return Rate;
    }

    public Float getVersion(){
        return Version;
    }

    public void setRate(Float Rate){
        this.Rate = Rate;
    }

    public void setgameName(String gameName){
        this.gameName = gameName;
    }

    public void setVersion(Float Version){
        this.Version = Version;
    }

}
