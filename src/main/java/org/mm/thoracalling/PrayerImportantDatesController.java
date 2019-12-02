package org.mm.thoracalling;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        List<PrayerImportantDates> res = prayerImportantDatesService.getPrayerByEnglishName(englishName);
        if (res.size()>0){
            return res;
        }
        else{
            throw new PrayerNotFoundException(englishName);
        }

    }

    @GetMapping("/prayersImportantDates/{id}")
    PrayerImportantDates getById (@PathVariable Long id){
        return prayerImportantDatesService.getById(id).orElseThrow(()->new PrayerNotFoundException(id.toString()));
    }

    

}
