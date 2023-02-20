package h1b_extension.h1b_extension_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import h1b_extension.h1b_extension_api.model.Ranking;

public interface RankingRepository extends JpaRepository<Ranking, Integer>{
    @Procedure(procedureName = "UPDATE_RANKINGS")
    void updateRankings(int new_year);

    Ranking findById(int id);
}
