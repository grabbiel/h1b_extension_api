package h1b_extension.h1b_extension_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import h1b_extension.h1b_extension_api.bean.NameMatches;
import h1b_extension.h1b_extension_api.model.TestTable;

@Repository
public interface H1BRecordRepository extends JpaRepository<TestTable, Integer>{    

    @Query(
        value = "SELECT NEW h1b_extension.h1b_extension_api.bean.NameMatches(tt.company, tt.code) FROM TestTable tt WHERE tt.company LIKE CONCAT(?1, ' %') OR tt.company=?1 GROUP BY tt.code"
    )
    List<NameMatches> getNameMatches(String literal);

}
