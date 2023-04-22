package h1b_extension.h1b_extension_api.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobPost {
    
    @JsonProperty("position")
    private String position;
    
    @JsonProperty("company")
    private String company;
    
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("platform")
    private int platform;
    
    @JsonProperty("country")
    private int country;
    
    @JsonProperty("status")
    private boolean status;

    // constructors, getters and setters
    
    public JobPost() {
        // default constructor
    }

    public JobPost(String position, String company, String description, int platform, int country, boolean status) {
        this.position = position;
        this.company = company;
        this.description = description;
        this.platform = platform;
        this.country = country;
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPlatform() {
        return platform;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
