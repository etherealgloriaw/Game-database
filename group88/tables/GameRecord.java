package group88.tables;

import java.util.Date;

//GameRecord(GameID, UserID, RecordID, Date)
//(G12345, U12345, 2015-01-01G12345U12345)
public class GameRecord {
    private final String GameID;
    private final String UserID;
    private String RecordID;
    private Date Date;

    public GameRecord(String gameID, String userID, String RecordID, java.util.Date date) {
        this.GameID = gameID;
        this.UserID = userID;
        this.RecordID = RecordID;
        this.Date = date;
    }

    public String getGameID(){ return GameID; }

    public String getUserID(){
        return UserID;
    }

    public String getRecordID(){
        return RecordID;
    }

    public Date getDate(){ return Date; }

    public void setRecordID(String RecordID){
        this.RecordID = RecordID;;
    }

    public void setDate(Date Date){
        this.Date = Date;
    }
}
