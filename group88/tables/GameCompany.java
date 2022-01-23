package group88.tables;


//GameCompany(CompanyName, country)
//(EA GAMES, US)
public class GameCompany {
    private final String CompanyName;
    private String Country;

    public GameCompany(String CompanyName, String Country) {
        this.CompanyName = CompanyName;
        this.Country = Country;
    }

    public String getCompanyName(){
        return CompanyName;
    }

    public String getCountry(){
        return Country;
    }

    public void setCountry(String Country){
        this.Country = Country;
    }

}
