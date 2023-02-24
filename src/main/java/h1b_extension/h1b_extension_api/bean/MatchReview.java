package h1b_extension.h1b_extension_api.bean;

public class MatchReview {
    private String name;
    private String literal;

    public MatchReview(String name, String literal){
        setName(name);
        setLiteral(literal);
    }

    private void setName(String name){
        this.name = name;
    }
    private void setLiteral(String literal){
        this.literal = literal;
    }
    public String getName(){
        return this.name;
    }
    public String getLiteral(){
        return this.literal;
    }
}
