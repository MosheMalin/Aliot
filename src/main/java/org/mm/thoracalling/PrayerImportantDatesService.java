package org.mm.thoracalling;

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

    List<PrayerImportantDates> getListByHebDate(int hebMonth, int dayInMonth) {
        return prayerImportantDatesRepository.findByHebrewMonthAndDayInMonth(hebMonth, dayInMonth);
    }

}