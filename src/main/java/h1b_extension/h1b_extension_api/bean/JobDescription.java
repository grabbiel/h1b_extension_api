package h1b_extension.h1b_extension_api.bean;

public class JobDescription {
    public String name;
    public String description;
    public boolean dstatus;

    public JobDescription(){}
    public JobDescription(String name, String description, boolean dstatus){
        setName(name);
        setDescription(description);
        setDstatus(dstatus);
    }

    public String getName(){return this.name;}
    public String getDescription(){return this.description;}
    public boolean getDstatus(){return this.dstatus;}

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDstatus(boolean dstatus){
        this.dstatus = dstatus;
    }
}
