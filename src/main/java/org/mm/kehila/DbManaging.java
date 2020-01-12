package org.mm.kehila;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.mm.kehila.congregant.Congregant;
import org.mm.kehila.congregant.CongregantRepository;
import org.mm.kehila.family.Family;
import org.mm.kehila.family.FamilyController;
import org.mm.kehila.family.FamilyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
class DbManaging {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDb (CongregantRepository congregantRepository, 
                                FamilyRepository familyRepository){
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");

        Family f =new Family("Malin","5 Meshorer st.", new ArrayList<>(){})

        return args -> {
            logger.info("Preloading: " + congregantRepository.save (
                new Congregant(FamilyPosition.husband,"Moshe","Malin","0541111111","moshe@gmail.com",objSDF.parse("16-08-1978"),5738,10,16) ) ); 
            logger.info("Preloading: " + congregantRepository.save (
                new Congregant(FamilyPosition.husband,"Anat","Malin","054000000","anat@gmail.com",objSDF.parse("15-04-1981"),5738,7,11) ) ); 
            logger.info("Preloading: " + congregantRepository.save (
                new Congregant(FamilyPosition.husband,"Nissim","Derdiger","0542222222","nissim@gmail.com",objSDF.parse("16-08-1981"),5741,10,16) ) ); 
            logger.info("Preloading: " + congregantRepository.save (
                new Congregant(FamilyPosition.husband,"Yehuda","Zilberfarb","05433333","yehuda@gmail.com",objSDF.parse("16-08-1981"),5741, 10,16) ) ); 

            logger.info("Preloading: " + familyRepository.save (
                new Family() )); 
    

            };
    }

}