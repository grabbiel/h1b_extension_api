package h1b_extension.h1b_extension_api.bean;

public class CompanyRecord {
    private int requests;
    private int ranking;
    private int approvals;
    public CompanyRecord(){}
    public CompanyRecord(double requests, double approvals, int ranking){
        setRequests(requests);
        setRanking(ranking);
        setApprovals(approvals);
    }
    public int getRequests(){
        return this.requests;
    }
    public int getRanking(){
        return this.ranking;
    }
    public int getApprovals(){
        return this.approvals;
    }
    public void setRequests(double requests){
        this.requests = (int) requests;
    }
    public void setRanking(int ranking){
        this.ranking = ranking;
    }
    public void setApprovals(double approvals){
        this.approvals = (int) approvals;
    }
}
