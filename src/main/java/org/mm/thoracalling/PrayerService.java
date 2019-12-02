package org.mm.thoracalling;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
class PrayerService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PrayerRepository prayerRepository;

    PrayerService (PrayerRepository prayerRepository){
        this.prayerRepository = prayerRepository;
    }

    List<Prayer> getAll(){
        return prayerRepository.findAll();
    }

    Optional<Prayer> getById(Long id) {
        return prayerRepository.findById(id);
    }

    List<Prayer> getPrayerByEnglishName(String englishName)
    {
        List<Prayer> res = prayerRepository.findByEnglishName(englishName);
        if (res.size() >1)
        {
            logger.warn("multiple results with the same name [" + englishName + "].");;
        }
        return res;
    }
}