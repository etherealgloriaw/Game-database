package group88.delegates;

import group88.tables.*;

import java.sql.SQLException;
import java.util.List;

public interface OperationsDelegate {
    public List<String> viewActiveUsers(String CommunityID);
    public boolean deleteComment(String text, String text1, String text2) throws SQLException;
    public List<String> viewUsersWithFullAcheivement();
    public boolean addGameRecords(String GameID, String UserID) throws SQLException;
    public List<String[]> findMasterComment(String GameID);
    public List<String[]> getearlistdevelopedGame();
    public List<String[]> sortGameofInputYear(String year);
    public List<Game> viewGames();
    public List<User> viewUsers();
    public List<GameRecord> viewGameRecord();
    public List<MakeComment> viewComments();
    public List<SellGame> viewSellGame();
    public boolean updatePrice(String text, String text1, String text2) throws SQLException;
    public List<String[]> gethighestageineachGame();
}
