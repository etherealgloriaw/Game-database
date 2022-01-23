package group88.tables;

// Achievement(AchievementName, rareness)(rareness is 0-10)
// (Have100GameRecords, 8)
public class Achievement {
    private String AchievementName;
    private Integer Rareness;

    public Achievement(String AchievementName, Integer rareness) {
        this.AchievementName = AchievementName;
        this.Rareness = rareness;
    }

    public String getAchievementName(){
        return AchievementName;
    }

    public Integer getRareness (){ return Rareness; }

    public void setAchievementName(String AchievementName){
        this.AchievementName = AchievementName;
    }

    public void setRareness(Integer rareness){
        this.Rareness = rareness;
    }

}
