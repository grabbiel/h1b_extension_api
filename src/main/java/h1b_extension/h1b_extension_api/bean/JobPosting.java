package h1b_extension.h1b_extension_api.bean;

public class JobPosting {
    private String description;
    private String name;
    private int jobboard;
    private int status;

    public JobPosting(String description, String name, int jobboard, int status){
        setDescription(description);
        setName(name);
        setJobboard(jobboard);
        setStatus(status);
        /* delete job_board_code it is not relevant u fucker */
    }

    private void setDescription(String description){
        this.description = description;
    }
    private void setName(String name){
        this.name = name;
    }
    private void setJobboard(int jobboard){
        this.jobboard = jobboard;
    }
    private void setStatus(int status){
        this.status = status;
    }
    public String getDescription(){
        return this.description;
    }
    public String getName(){
        return this.name;
    }
    public int getJobboard(){
        return this.jobboard;
    }
    public int getStatus(){
        return this.status;
    }
}
