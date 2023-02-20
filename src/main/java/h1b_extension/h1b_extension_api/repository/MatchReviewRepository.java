package h1b_extension.h1b_extension_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import h1b_extension.h1b_extension_api.model.MatchReview;

public interface MatchReviewRepository extends JpaRepository<MatchReview, Integer>{
    
    boolean existsMatchReviewByUscis(String uscis_name);

    boolean existsMatchReviewByAlternatename(String alternate_name);

    @Procedure(procedureName = "INSERT_MATCH_REVIEW_RECORD")
    void insertNewRecord(String uscis_name, int job_board_code, String match_name, int h1b_records_id, int country_code);
}
