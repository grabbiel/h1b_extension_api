package h1b_extension.h1b_extension_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import h1b_extension.h1b_extension_api.repository.RankingRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RankingService {
    @Autowired
    private RankingRepository rankingRepository;

    public void updateRankings(String year){
        rankingRepository.updateRankings(Integer.parseInt(year));
        /* add caching */
    }
}
