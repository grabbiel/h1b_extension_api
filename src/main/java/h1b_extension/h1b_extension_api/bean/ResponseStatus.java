package h1b_extension.h1b_extension_api.bean;

public class ResponseStatus {
    private int status;
    public ResponseStatus(int status){
        setStatus(status);
    }
    public int getStatus(){
        return this.status;
    }
    public void setStatus(int status){
        this.status = status;
    }
}
