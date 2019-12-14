package org.mm.thoracalling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith (SpringRunner.class)
@ComponentScan
@DataJpaTest
@ActiveProfiles("test")
public class PrayerImportantDatesServiceTests{

     @Autowired
     private PrayerImportantDatesRepository prayerImportantDatesRepository;

    @Autowired
    private PrayerImportantDatesService prayerImportantDatesService;

    @Test
    public void whenAskingForAllPrayersImportantDates_getFullList(){
        prayerImportantDatesRepository.save(new PrayerImportantDates("aaa",1,1, ImportantDatesTypes.YAHRZEIHT));
        prayerImportantDatesRepository.save(new PrayerImportantDates("bbb",2,12, ImportantDatesTypes.YAHRZEIHT));
        List<PrayerImportantDates> prayerImportantDates = prayerImportantDatesService.getAll();
        assertThat(prayerImportantDates.size()).isEqualTo(2);
    }

    @Test
    public void whenAskingForImportantDateByName_returnListOfAllPrayersWithThisName(){
        prayerImportantDatesRepository.save(new PrayerImportantDates("aaa",1, 3, ImportantDatesTypes.YAHRZEIHT));
        prayerImportantDatesRepository.save(new PrayerImportantDates("bbb",2, 12, ImportantDatesTypes.YAHRZEIHT));
        List<PrayerImportantDates> prayerImportantDates = prayerImportantDatesService.getListByEnglishName("bbb");
        assertThat(prayerImportantDates.size()).isEqualTo(1);
        assertThat(prayerImportantDates.get(0).getEnglishName().contentEquals("bbb"));
    }    

    @Test
    public void whenQueringByHebDate_getAllItemsInThisDate(){
        prayerImportantDatesRepository.save(new PrayerImportantDates("aaa",1, 3, ImportantDatesTypes.YAHRZEIHT));
        prayerImportantDatesRepository.save(new PrayerImportantDates("aaa",2, 2, ImportantDatesTypes.YAHRZEIHT));
        prayerImportantDatesRepository.save(new PrayerImportantDates("bbb",5, 3, ImportantDatesTypes.YAHRZEIHT));
        prayerImportantDatesRepository.save(new PrayerImportantDates("bbb",2, 12, ImportantDatesTypes.YAHRZEIHT));
        prayerImportantDatesRepository.save(new PrayerImportantDates("ccc",1, 3, ImportantDatesTypes.YAHRZEIHT));
        List<PrayerImportantDates> prayerImportantDates = prayerImportantDatesService.getListByHebDate(1,3);
        assertThat(prayerImportantDates.size()).isEqualTo(2);
        assertThat(prayerImportantDates.get(0).getEnglishName().contentEquals("aaa"));
        assertThat(prayerImportantDates.get(1).getEnglishName().contentEquals("ccc"));                        
    }
}