package group88.tables;

//MakeComment(UserID, CommunityID, CommentID, Comments)
//(U12345,C12345,CO123, Awful game)
public class MakeComment {
    private final String UserID;
    private final String CommunityID;
    private String CommentID;
    private String Comment;

    public MakeComment(String userID, String communityID, String commentID, String comment) {
        this.UserID = userID;
        this.CommunityID = communityID;
        this.CommentID = commentID;
        this.Comment = comment;
    }
    public String getUserID(){
        return UserID;
    }
    public String getCommunityID(){
        return CommunityID;
    }
    public String getCommentID(){
        return CommentID;
    }
    public String getComment(){
        return Comment;
    }

    public void setCommentID(String CommentID){
        this.CommentID = CommentID;
    }
    public void setComment(String Comment){
        this.Comment = Comment;
    }

}
