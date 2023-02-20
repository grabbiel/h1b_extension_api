package h1b_extension.h1b_extension_api.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "h1b_records")
public class H1BRecord{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToMany(mappedBy = "uscisid", cascade = CascadeType.REMOVE)
    private Set<MatchReview> match_review;

    @Column
    private String company;

    @Column
    private int code;

    @Column
    private int requests;

    @Column
    private int approvals;

    @Column
    private int ranking;

    @Column
    private int fiscal_year;

    @Column
    private int country;

    @Column
    private int sponsor_openings;

    @Column
    private int openings;

    public H1BRecord(){}
    public H1BRecord(int id, String company, int code, int requests, int approvals, int ranking, int fiscal_year, int country, int sponsor_openings, int openings){
        setId(id);
        setCompany(company);
        setCode(code);
        setRequests(requests);
        setApprovals(approvals);
        setRanking(ranking);
        setYear(fiscal_year);
        setCountry(country);
        setSponsorOpenings(sponsor_openings);
        setOpenings(openings);
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
    public int getRanking(){
        return ranking;
    }
    public void setRanking(int ranking){
        this.ranking = ranking;
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
    public int getSponsorOpenings(){
        return sponsor_openings;
    }
    public void setSponsorOpenings(int sponsor_openings){
        this.sponsor_openings =  sponsor_openings;
    }
    public int getOpenings(){
        return openings;
    }
    public void setOpenings(int openings){
        this.openings =  openings;
    }
}
