package org.mm.thoracalling;

import java.time.LocalDate;
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
        prayerImportantDatesRepository.save(new PrayerImportantDates("aaa",LocalDate.parse("2017-02-13"), ImportantDatesTypes.YAHRZEIHT));
        prayerImportantDatesRepository.save(new PrayerImportantDates("bbb",LocalDate.parse("2018-02-13"), ImportantDatesTypes.YAHRZEIHT));
        List<PrayerImportantDates> prayerImportantDates = prayerImportantDatesService.getAll();
        assertThat(prayerImportantDates.size()).isEqualTo(2);
    }

    @Test
    public void whenAskingForPrayersInGivenImportantDate_returnListOfAllPrayersWithThisDate(){
        prayerImportantDatesRepository.save(new PrayerImportantDates("aaa",LocalDate.parse("2017-02-13"), ImportantDatesTypes.YAHRZEIHT));
        prayerImportantDatesRepository.save(new PrayerImportantDates("bbb",LocalDate.parse("2018-02-13"), ImportantDatesTypes.YAHRZEIHT));
        List<PrayerImportantDates> prayerImportantDates = prayerImportantDatesService.getPrayerByDate(LocalDate.parse("2017-02-13"));
        assertThat(prayerImportantDates.size()).isEqualTo(1);
        assertThat(prayerImportantDates.get(0).getEnglishName().contentEquals("aaa"));
    }

}