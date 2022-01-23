package group88.tables;

import java.util.Date;

//DevelopGame(GameID, CompanyName, ReleaseDate)
//(G12345,EA GAMES,2015-01-01)
public class DevelopGame {
    private final String GameID;
    private final String CompanyName;
    private Date ReleaseDate;

    public DevelopGame(String GameID, String CompanyName, Date ReleaseDate) {
        this.ReleaseDate = ReleaseDate;
        this.GameID = GameID;
        this.CompanyName = CompanyName;
    }

    public String getCompanyName(){
        return CompanyName;
    }

    public String getGameID(){ return GameID; }

    public Date getReleaseDate(){ return ReleaseDate; }

    public void setReleaseDate(Date ReleaseDate){
        this.ReleaseDate = ReleaseDate;
    }


}
