package group88.tables;

import java.util.Date;

//GetAcheivement(UserID, AchievementName, AchieveDate)
//(U12345, HaveGot100Record, 2016-01-01)
public class GetAcheivement {
    private final String UserID;
    private String AchievementName;
    private java.util.Date AchieveDate;

    public GetAcheivement(String userID, String achievementName, Date achieveDate) {
        this.UserID = userID;
        this.AchievementName = achievementName;
        this.AchieveDate = achieveDate;
    }

    public String getUserID(){
        return UserID;
    }
    public String getAchievementName(){
        return AchievementName;
    }
    public Date getAchieveDate(){ return AchieveDate; }

    public void setAchievementName(String achievementName){
        this.AchievementName = achievementName;;
    }
    public void setDate(Date AchieveDate){
        this.AchieveDate = AchieveDate;
    }
}
