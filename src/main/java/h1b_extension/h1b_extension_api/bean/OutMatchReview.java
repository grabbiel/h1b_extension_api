package h1b_extension.h1b_extension_api.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OutMatchReview {
    private String name_original;
    private String name_match;
    private int code;
    private int platform;
    private int country;

    public OutMatchReview(){}

    public OutMatchReview(MatchReview inMatchReview, String name_match, int code){
        setOriginalName(inMatchReview.getName());
        setMatchName(name_match);
        setCode(code);
        setPlatform(inMatchReview.getPlatform());
        setCountry(inMatchReview.getCountry());
    }

    public void setOriginalName(String name){
        this.name_original = name;
    }
    public String getOriginalName(){
        return this.name_original;
    }
    public void setMatchName(String name){
        this.name_match = name;
    }
    public String getMatchName(){
        return this.name_match;
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }
    public void setPlatform(int platform){
        this.platform = platform;
    }
    public int getPlatform(){
        return this.platform;
    }
    public void setCountry(int country){
        this.country = country;
    }
    public int getCountry(){
        return this.country;
    }

    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try{
            json = mapper.writeValueAsString(this);
        } catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }
}
