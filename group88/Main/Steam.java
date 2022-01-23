package group88.Main;


import group88.Handle.ConnectionHandler;
import group88.delegates.LoginWindowDelegate;
import group88.delegates.OperationsDelegate;
import group88.tables.*;
import group88.ui.LoginWindow;
import group88.ui.Options;

import java.sql.SQLException;
import java.util.List;

public class Steam implements LoginWindowDelegate, OperationsDelegate {
    private static ConnectionHandler ch;
    private final Options options;
    private LoginWindow loginWindow;

    public Steam(){
        ch = new ConnectionHandler();
        options = new Options();
    }

    public static void main(String args[]) {
        Steam steam = new Steam();
        steam.start();
    }

    private void start(){
        loginWindow = new LoginWindow();
        loginWindow.showFrame(this);

    }
    @Override
    public List<String> viewActiveUsers(String CommunityID){
        return ch.viewActiveUsers(CommunityID);
    }
    @Override
    public boolean deleteComment(String UserID, String CommunityID, String CommentID) throws SQLException {
        return ch.deleteComment(UserID, CommunityID, CommentID);
    }
    @Override
    public List<String> viewUsersWithFullAcheivement() {
        return ch.viewUsersWithFullAcheivement();
    }
    @Override
    public boolean addGameRecords(String GameID, String UserID) throws SQLException{
        return ch.addGameRecords(GameID,UserID);
    }
    @Override
    public List<String[]> findMasterComment(String GameID){
        return ch.findMasterComment(GameID);
    }

    @Override
    public List<String[]> getearlistdevelopedGame() {
        return ch.getearlistdevelopedGame();
    }

    @Override
    public List<String[]> sortGameofInputYear(String year) {
        return ch.sortGameofInputYear(year);
    }

    @Override
    public List<Game> viewGames(){
        return ch.viewGames();
    }

    @Override
    public List<User> viewUsers() {
        return ch.viewUsers();
    }

    @Override
    public List<GameRecord> viewGameRecord() {
        return ch.viewGameRecord();
    }

    @Override
    public List<MakeComment> viewComments() {
        return ch.viewComments();
    }

    @Override
    public List<SellGame> viewSellGame() {
        return ch.viewSellGame();
    }

    @Override
    public boolean updatePrice(String text, String text1, String text2) throws SQLException {
        return ch.updatePrice(text,text1,text2);
    }

    @Override
    public List<String[]> gethighestageineachGame() {
        return ch.gethighestageineachGame();
    }

    @Override
    public void login(String username, String password) {
        boolean didConnect = ch.login(username, password);

        if (didConnect) {
            // Once connected, remove login window and start text transaction flow
            loginWindow.dispose();

            //start ui
            options.main(this);
        } else {
            loginWindow.handleLoginFailed();

            if (loginWindow.hasReachedMaxLoginAttempts()) {
                loginWindow.dispose();
                System.out.println("You have exceeded your number of allowed attempts");
                System.exit(-1);
            }
        }
    }


}

