package org.mm.kehila;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.mm.kehila.common.SimpleHebrewDate;
import org.mm.kehila.congregant.Congregant;
import org.mm.kehila.congregant.CongregantRepository;
import org.mm.kehila.congreganttofamily.CongregantToFamily;
import org.mm.kehila.family.Family;
import org.mm.kehila.family.FamilyRepository;
import org.mm.kehila.importantdates.DateType;
import org.mm.kehila.importantdates.ImportantDate;
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
    CommandLineRunner initDb(CongregantRepository congregantRepository, FamilyRepository familyRepository)
            throws ParseException {
        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");

        //list of congregants
        //+ relations between congregants and families
        Congregant mosheMalin = new Congregant("Moshe", "Malin", "0000", "moshemalin@gmail.com",objSDF.parse("16-08-1978"), 
                new SimpleHebrewDate(5738,10,16), new ArrayList<>() );
        mosheMalin.getImportantDate().add(new ImportantDate(new SimpleHebrewDate(5000,1,1),DateType.other));
        
        Congregant anatMalin = new Congregant("Anat", "Malin", "0000", "anatvishne@gmail.com",objSDF.parse("15-04-1981"), 
                new SimpleHebrewDate(5738,10,16), new ArrayList<>() );        
        anatMalin.getImportantDate().add(new ImportantDate(new SimpleHebrewDate(5000,1,1),DateType.other));

        Congregant zeevVishne = new Congregant("Zeev", "Vishne", "0000", "zeevvishne@gmail.com",objSDF.parse("15-04-1945"), 
                new SimpleHebrewDate(5738,10,16), new ArrayList<>() );
        Congregant gadiVishne = new Congregant("Gadi", "Vishne", "0000", "gadivishne@gmail.com",objSDF.parse("15-04-1975"), 
                new SimpleHebrewDate(5738,10,16), new ArrayList<>() );

        Congregant nissimDerdiger =  new Congregant("Nissim","Derdiger","0542222222","nissim@gmail.com",objSDF.parse("16-08-1981"), 
                new SimpleHebrewDate(5741,10,16), new ArrayList<>() ); 
        Congregant yehudaZilberfarb =  new Congregant("Yehuda","Zilberfarb","05433333","yehuda@gmail.com",objSDF.parse("16-08-1981"), 
                new SimpleHebrewDate(5741, 10,16), new ArrayList<>()); 

        //congrenants
        logger.info("Preloading: " + congregantRepository.save (mosheMalin)); 
        logger.info("Preloading: " + congregantRepository.save (anatMalin)); 
        logger.info("Preloading: " + congregantRepository.save (gadiVishne)); 
        logger.info("Preloading: " + congregantRepository.save (zeevVishne)); 
        logger.info("Preloading: " + congregantRepository.save (nissimDerdiger)); 
        logger.info("Preloading: " + congregantRepository.save (yehudaZilberfarb)); 

        congregantRepository.flush();

        //list of families
        Family malinFamily = new Family("Malin", "5 Meshorer St.");
        Family derdigerFamiliy = new Family("Derdiger", "5 Hanasih St.");
        Family zilberfarbFamiliy = new Family("Zilberfarb", "19 Ha'Inbal st.");
        Family vishneFamiliy = new Family("Vishne", "23 Meshorer st.");

        //bind congregants to families
        malinFamily.getFamilyMembers().add(new CongregantToFamily(mosheMalin,FamilyPosition.husband));
        malinFamily.getFamilyMembers().add(new CongregantToFamily(anatMalin,FamilyPosition.wife));
        malinFamily.getFamilyMembers().add(new CongregantToFamily(zeevVishne,FamilyPosition.wifesFather));

        vishneFamiliy.getFamilyMembers().add(new CongregantToFamily(zeevVishne,FamilyPosition.husbandsFather));
        vishneFamiliy.getFamilyMembers().add(new CongregantToFamily(gadiVishne,FamilyPosition.husband));

        zilberfarbFamiliy.getFamilyMembers().add(new CongregantToFamily(yehudaZilberfarb,FamilyPosition.husband));

        derdigerFamiliy.getFamilyMembers().add(new CongregantToFamily(nissimDerdiger,FamilyPosition.husband));

        logger.info("Preloading: " + familyRepository.save (malinFamily)); 
        logger.info("Preloading: " + familyRepository.save (derdigerFamiliy)); 
        logger.info("Preloading: " + familyRepository.save (vishneFamiliy)); 
        logger.info("Preloading: " + familyRepository.save (zilberfarbFamiliy));         

        return args -> {

            };
    }

}