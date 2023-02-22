package h1b_extension.h1b_extension_api.bean;

import java.io.Serializable;

public class StringMatch extends ResponseStatus implements Serializable {
    private String match;
    public StringMatch(){
        super(0);
        setMatch("");
    }
    public StringMatch(String match){
        super(1);
        setMatch(match);
    }
    public String getMatch(){
        return this.match;
    }
    public void setMatch(String match){
        this.match = match;
    }
}
