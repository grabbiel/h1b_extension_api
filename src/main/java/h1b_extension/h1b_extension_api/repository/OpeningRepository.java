package h1b_extension.h1b_extension_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import h1b_extension.h1b_extension_api.model.Opening;

public interface OpeningRepository extends JpaRepository<Opening, Integer>{
    
    Opening findById(int id);

    @Modifying
    @Query(value="update Opening o set o.sponsored = o.sponsored + 1 where o.id = :id")
    void addSponsorOpening(@Param(value = "id") String id);

    @Modifying
    @Query(value="update Opening o set o.all = o.all + 1 where o.id = :id")
    void addOpening(@Param(value = "id") String id);
}
