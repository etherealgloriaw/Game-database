package group88.tables;

//professionalUser(UserID, GameID, ranking)
//(U12345, G12345, 12345)
public class ProfessionalUser extends User {
    private final String GameID;
    private Integer Ranking;

    public ProfessionalUser(String userID, Integer age, Float accountBalance,String gameID,Integer ranking) {
        super(userID,age,accountBalance);
        this.GameID = gameID;
        this.Ranking = ranking;
    }
    public String getGameID(){ return GameID; }
    public Integer getRanking(){ return Ranking; }

    public void setRanking(Integer Ranking){
        this.Ranking = Ranking;
    }
}
