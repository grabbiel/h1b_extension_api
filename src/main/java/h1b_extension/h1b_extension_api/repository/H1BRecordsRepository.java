package h1b_extension.h1b_extension_api.repository;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import h1b_extension.h1b_extension_api.bean.CompanyRecord;
import h1b_extension.h1b_extension_api.model.H1BRecord;
public interface H1BRecordsRepository extends JpaRepository<H1BRecord, Integer>{
    
    @Cacheable(value="exists_by", key="#name")
    boolean existsH1BRecordByCompany(String name);
    
    @Cacheable(value="starts_by", key="#name")
    boolean existsH1BRecordByCompanyStartingWith(String name);

    @Query(
        value="SELECT NEW h1b_extension.h1b_extension_api.bean.CompanyRecord(ROUND(AVG(h.requests),0), ROUND(AVG(h.approvals),0), MIN(h.ranking)) FROM H1BRecord h WHERE h.company LIKE CONCAT(?1, ' %') OR h.company=?1"
    )
    @Cacheable(value="company_record", key="#name")
    CompanyRecord getCompanyRecord(String name);

}
