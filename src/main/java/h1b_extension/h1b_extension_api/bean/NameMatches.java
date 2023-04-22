package h1b_extension.h1b_extension_api.bean;

public class NameMatches {
    
    private String name;
    private int code;

    public NameMatches(String name, int code){
        setName(name);
        setCode(code);
    }

    private void setName(String name){
        this.name = name;
    }
    private void setCode(int code){
        this.code = code;
    }
    public String getName(){
        return this.name;
    }
    public int getCode(){
        return this.code;
    }


}
