package org.mm.thoracalling;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;

@RestController
class PrayerController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final PrayerService prayerService;

    PrayerController (PrayerService prayerService){
        this.prayerService = prayerService;
    }


    @RequestMapping("/")
    String index(){
        return "look in Swagger to get list of requests";
    }
 
    @GetMapping("/prayers")
    List<Prayer> getAll (){
        return prayerService.getAll();
    }

    @GetMapping("/prayers/name/{englishName}")
    List<Prayer> getByEnglishName (@PathVariable String englishName){
        List<Prayer> res = prayerService.getPrayerByEnglishName(englishName);
        if (res==null || res.isEmpty()){
            throw new PrayerNotFoundException(englishName);
        }
        return res;
    }

    @GetMapping("/prayers/{id}")
    Prayer getById (@PathVariable Long id){
        return prayerService.getById(id).orElseThrow(()->new PrayerNotFoundException(id.toString()));
    }

    

}
