package org.mm.thoracalling;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;;

@RestController
class PrayerImportantDatesController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final PrayerImportantDatesService prayerImportantDatesService;

    PrayerImportantDatesController (PrayerImportantDatesService prayerImportantDatesService){
        this.prayerImportantDatesService = prayerImportantDatesService;
    }


    @GetMapping("/prayersImportantDates")
    List<PrayerImportantDates> getAll (){
        return prayerImportantDatesService.getAll();
    }

    @GetMapping("/prayersImportantDates/name/{englishName}")
    List<PrayerImportantDates> getByEnglishName (@PathVariable String englishName){
        List<PrayerImportantDates> res = prayerImportantDatesService.getListByEnglishName(englishName);
        if (res==null || res.isEmpty()){
            throw new PrayerNotFoundException(englishName);
        }
        return res;
    }

    @GetMapping("/prayersImportantDates/date/{date}")
    List<PrayerImportantDates> getByDate (@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        List<PrayerImportantDates> res = prayerImportantDatesService.getListByDate(date);
        if (res==null || res.isEmpty()){
            throw new PrayerNotFoundException(date.toString());
        }
        return res;
    }
    @GetMapping("/prayersImportantDates/{id}")
    PrayerImportantDates getById (@PathVariable Long id){
        return prayerImportantDatesService.getById(id).orElseThrow(()->new PrayerNotFoundException(id.toString()));
    }

    

}
