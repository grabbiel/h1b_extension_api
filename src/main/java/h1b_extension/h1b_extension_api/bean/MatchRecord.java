package h1b_extension.h1b_extension_api.bean;
/* test later with private + getters */
public class MatchRecord {
    private String uscis;
    private String match;
    private int jobboard;
    private int country;
    
    public String getUscis(){
        return this.uscis;
    }
    public String getMatch(){
        return this.match;
    }
    public int getJobboard(){
        return this.jobboard;
    }
    public int getCountry(){
        return this.country;
    }
    public void setUscis(String uscis){
        this.uscis = uscis;
    }
    public void setMatch(String match){
        this.match = match;
    }
    public void setJobboard(int jobboard){
        this.jobboard = jobboard;
    }
    public void setCountry(int country){
        this.country = country;
    }
}
