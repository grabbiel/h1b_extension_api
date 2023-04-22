package h1b_extension.h1b_extension_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "test_table")
public class TestTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String company;

    @Column
    private int code;

    @Column
    private int requests;

    @Column
    private int approvals;

    @Column
    private int fiscal_year;

    @Column
    private int country;


    public TestTable(){}

    public TestTable(int id, String company, int code, int requests, int approvals, int fiscal_year, int country){
        setId(id);
        setCompany(company);
        setCode(code);
        setRequests(requests);
        setApprovals(approvals);
        setYear(fiscal_year);
        setCountry(country);
    }

    public TestTable(String company, int code, int requests, int approvals, int fiscal_year, int country){
        setCompany(company);
        setCode(code);
        setRequests(requests);
        setApprovals(approvals);
        setYear(fiscal_year);
        setCountry(country);
    }

    public int getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public int getCode(){
        return code;
    }
    public void setCode(int code){
        this.code = code;
    }
    public int getRequests(){
        return requests;
    }
    public void setRequests(int requests){
        this.requests = requests;
    }
    public int getApprovals(){
        return approvals;
    }
    public void setApprovals(int approvals){
        this.approvals = approvals;
    }
    public int getYear(){
        return fiscal_year;
    }
    public void setYear(int fiscal_year){
        this.fiscal_year =  fiscal_year;
    }
    public int getCountry(){
        return country;
    }
    public void setCountry(int country){
        this.country = country;
    }

}
