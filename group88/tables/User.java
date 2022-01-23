package group88.tables;

//User(UserID, Age, AccountBalance)
//(U12334, 25, 100.0)
public class User {
    private final String UserID;
    private Integer Age;
    private Float AccountBalance;

    public User(String userID, Integer age, float accountBalance) {
        this.UserID = userID;
        this.Age = age;
        this.AccountBalance = accountBalance;
    }

    public String getUserID(){
        return UserID;
    }

    public Integer getAge (){ return Age; }

    public Float getAccountBalance (){ return AccountBalance; }

    public void setAge(Integer age){
        this.Age = age;
    }

    public void setAccountBalance(Float AccountBalance){
        this.AccountBalance = AccountBalance;
    }

}
