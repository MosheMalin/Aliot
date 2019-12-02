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
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ActiveProfiles("test")
public class PrayerServiceTests{

     @Autowired
     private PrayerRepository prayerRepository;

    @Autowired
    private PrayerService prayerService;

    @Test
    public void whenAskingForAllPrayers_getFullList(){
        Prayer p = new Prayer("aaa","שש שש");
        prayerRepository.save(p);
        List<Prayer> prayers = prayerService.getAll();
        assertThat(prayers.size()).isEqualTo(1);
    }

    @Test
    public void returnSinglePrayerByEnglishName_givenThereIsOnlyOne(){
        prayerRepository.save(new Prayer("aaa","heb1"));
        prayerRepository.save(new Prayer("bbb","heb2"));
        prayerRepository.save(new Prayer("ccc","heb3"));
        List<Prayer> prayers = prayerService.getPrayerByEnglishName("bbb");
        assertThat(prayers.size()).isEqualTo(1);
        assertThat(prayers.get(0).getEnglishName().contentEquals("bbb"));
    }

    @Test
    public void return2PrayersByEnglishName_givenThereAre2WithSameName(){
        prayerRepository.save(new Prayer("aaa","heb1"));
        prayerRepository.save(new Prayer("bbb","heb2"));
        prayerRepository.save(new Prayer("bbb","heb3"));
        List<Prayer> prayers = prayerService.getPrayerByEnglishName("bbb");
        assertThat(prayers.size()).isEqualTo(2);
        assertThat(prayers).extracting("englishName").containsOnly("bbb");
    }

}