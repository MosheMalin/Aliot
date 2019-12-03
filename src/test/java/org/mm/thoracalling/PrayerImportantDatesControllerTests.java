package org.mm.thoracalling;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@WebMvcTest(PrayerImportantDatesController.class)
@ActiveProfiles("test")
public class PrayerImportantDatesControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PrayerImportantDatesService prayerImportantDatesService;

  @Test
  public void whenThereIsAListOfDates_shoudlReturnAll() throws Exception {
      
    List<PrayerImportantDates> retPrayerImportantDates = new ArrayList<>();
    retPrayerImportantDates.add(new PrayerImportantDates("aaa",LocalDate.parse("2017-02-13"), ImportantDatesTypes.YAHRZEIHT));
    retPrayerImportantDates.add(new PrayerImportantDates("bbb",LocalDate.parse("2018-02-13"), ImportantDatesTypes.YAHRZEIHT));
    when(prayerImportantDatesService.getAll()).thenReturn(retPrayerImportantDates);

    mockMvc.perform(get("/prayersImportantDates"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$",org.hamcrest.Matchers.hasSize (2) ));
  }

    @Test
    public void whenProvidingValidId_getPrayerImportantDatesById() throws Exception {
        Optional<PrayerImportantDates> retPrayerImportantDates = 
                Optional.of(new PrayerImportantDates(1L, "aaa",LocalDate.parse("2017-02-13"), ImportantDatesTypes.YAHRZEIHT));
        when(prayerImportantDatesService.getById(1L)).thenReturn(retPrayerImportantDates);

        mockMvc.perform(get("/prayersImportantDates/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.englishName", org.hamcrest.Matchers.equalTo("aaa")))
        .andExpect(jsonPath("$.date", org.hamcrest.Matchers.equalTo("2017-02-13")));
    }
    
    @Test
    public void whenProvidingExistingDate_getPrayerImportantDatesByDate() throws Exception {
        List<PrayerImportantDates> retPrayerImportantDates = new ArrayList<>();
        retPrayerImportantDates.add(new PrayerImportantDates("aaa",LocalDate.parse("2017-02-13"), ImportantDatesTypes.YAHRZEIHT));
        retPrayerImportantDates.add(new PrayerImportantDates("bbb",LocalDate.parse("2018-02-13"), ImportantDatesTypes.YAHRZEIHT));
        when(prayerImportantDatesService.getListByDate(LocalDate.parse("2017-02-13"))).thenReturn(retPrayerImportantDates.subList(0, 1));
        mockMvc.perform(get("/prayersImportantDates/date/2017-02-13"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$",org.hamcrest.Matchers.hasSize (1)))
        .andExpect(jsonPath("$[0].englishName", org.hamcrest.Matchers.equalTo("aaa")))
        .andExpect(jsonPath("$[0].date", org.hamcrest.Matchers.equalTo("2017-02-13")));
    }    

    @Test
    public void whenProvidingNonExistingDate_get404() throws Exception {
        List<PrayerImportantDates> retPrayerImportantDates = new ArrayList<>();
        retPrayerImportantDates.add(new PrayerImportantDates("aaa",LocalDate.parse("2017-02-13"), ImportantDatesTypes.YAHRZEIHT));
        retPrayerImportantDates.add(new PrayerImportantDates("bbb",LocalDate.parse("2018-02-13"), ImportantDatesTypes.YAHRZEIHT));
        when(prayerImportantDatesService.getListByDate(LocalDate.parse("2017-02-13"))).thenReturn(null);
        mockMvc.perform(get("/prayersImportantDates/date/2017-02-13"))
        .andExpect(status().isNotFound())
        .andExpect(content().string("Prayer not found"));
    }    
    /*
    @Test
    public void getPrayerNotFound_whenAskingForNotExistingId() throws Exception {
        when(prayerService.getById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/prayers/1"))
        .andExpect(status().isNotFound())
        .andExpect(content().string("Prayer not found"));
    }

    @Test
    public void getPrayerByEnglishName_whenProvidingValidName() throws Exception {
        List<Prayer> retPrayers = new ArrayList<>();
        retPrayers.add(new Prayer("a","א"));
        when(prayerService.getPrayerByEnglishName(anyString())).thenReturn(retPrayers);
    
        mockMvc.perform(get("/prayers/name/Moshe"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].englishName", org.hamcrest.Matchers.equalTo("a")));
    }

    //todo: list with same name

    @Test
    public void getPrayerNotFound_whenNameDoesNotExist() throws Exception {
        List<Prayer> retPrayers = new ArrayList<>();
        when(prayerService.getPrayerByEnglishName(anyString())).thenReturn(retPrayers);
    
        mockMvc.perform(get("/prayers/name/Moshe"))
        .andExpect(status().isNotFound())
        .andExpect(content().string("Prayer not found"));
    }
*/
}
