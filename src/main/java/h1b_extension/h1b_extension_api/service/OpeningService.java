package h1b_extension.h1b_extension_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import h1b_extension.h1b_extension_api.repository.OpeningRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OpeningService {
    @Autowired
    private OpeningRepository openingRepository;

    public void addSponsorOpening(String id){
        openingRepository.addSponsorOpening(id);
        /* add caching */
    }
    public void addOpening(String id){
        openingRepository.addOpening(id);
        /* add caching */
    }
}
