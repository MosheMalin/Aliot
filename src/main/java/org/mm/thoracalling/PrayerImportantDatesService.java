package org.mm.thoracalling;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
class PrayerImportantDatesService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PrayerImportantDatesRepository prayerImportantDatesRepository;

    PrayerImportantDatesService (PrayerImportantDatesRepository prayerImportantDatesRepository){
        this.prayerImportantDatesRepository = prayerImportantDatesRepository;
    }

    List<PrayerImportantDates> getAll(){
        return prayerImportantDatesRepository.findAll();
    }

    Optional<PrayerImportantDates> getById(Long id) {
        return prayerImportantDatesRepository.findById(id);
    }

    List<PrayerImportantDates> getListByEnglishName(String englishName)
    {
        List<PrayerImportantDates> res = prayerImportantDatesRepository.findByEnglishName(englishName);
        if (res.size() >1)
        {
            logger.warn("multiple results with the same name [" + englishName + "].");;
        }
        return res;
    }
    List<PrayerImportantDates> getListByDate(LocalDate date)
    {
        List<PrayerImportantDates> res = prayerImportantDatesRepository.findByDate(date);
        if (res.size() >1)
        {
            logger.warn("multiple results with the same name [" + date + "].");;
        }
        return res;
    }    
}