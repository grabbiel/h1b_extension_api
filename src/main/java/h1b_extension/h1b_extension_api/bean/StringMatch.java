package h1b_extension.h1b_extension_api.bean;

import java.io.Serializable;

public class StringMatch extends ResponseStatus implements Serializable {
    private String match;
    
    public StringMatch(String match){
        super();
        setMatch(match);
        if(this.match==""){
            this.setStatus(0);
        }else{
            this.setStatus(1);
        }
    }
    public String getMatch(){
        return this.match;
    }
    public void setMatch(String match){
        this.match = match;
    }
}
