package h1b_extension.h1b_extension_api.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import h1b_extension.h1b_extension_api.bean.CompanyRecord;
import h1b_extension.h1b_extension_api.model.H1BRecord;
public interface H1BRecordsRepository extends JpaRepository<H1BRecord, Integer>{
    
    boolean existsH1BRecordByCompany(String name);
    
    boolean existsH1BRecordByCompanyStartingWith(String name);

    @Query(
        value="SELECT NEW h1b_extension.h1b_extension_api.bean.CompanyRecord(ROUND(AVG(h.requests),0), ROUND(AVG(h.approvals),0), MIN(h.ranking)) FROM H1BRecord h WHERE h.company LIKE CONCAT(?1, ' %') OR h.company=?1"
    )
    CompanyRecord getCompanyRecord(String name);

    @Query(value="SELECT h.code FROM H1BRecord h WHERE h.company=?1")
    int getCompanyCode(String name);

    @Query(value = "SELECT h.company FROM H1BRecord h WHERE h.company LIKE CONCAT(?1, ' %') OR h.company=?1")
    Set<String> getCompaniesLike(String name);

    @Procedure(procedureName = "INSERT_NEW_YEAR_RECORD")
    void addNewYearRecord(
        String company,
        int requests,
        int approvals,
        int fiscal_year,
        int country
    );
}
