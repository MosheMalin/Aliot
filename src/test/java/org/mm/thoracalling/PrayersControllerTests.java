package org.mm.thoracalling;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
@WebMvcTest(PrayerController.class)
@ActiveProfiles("test")
public class PrayersControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PrayerService prayerService;

  @Test
  public void whenThereIsOnlyoneUser_shoudlReturnSingleUser() throws Exception {
      
    List<Prayer> retPrayers = new ArrayList<>();
    retPrayers.add(new Prayer("a","א"));
    when(prayerService.getAll()).thenReturn(retPrayers);

    mockMvc.perform(get("/prayers"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$",org.hamcrest.Matchers.hasSize (1) ));

        // net.minidev.json.JSONArray jsonArray  = com.jayway.jsonpath.JsonPath.read(res.getResponse().getContentAsString(), "$");
        // assertThat(jsonArray.size()).isEqualTo(1);

        // ObjectMapper mapper  = new ObjectMapper();
        // Map <String, Prayer> map = mapper.readValue(jsonArray.get(0).toString(), Map.class);
        // assertThat(map.size()).isEqualTo(1);
  }

  @Test
  public void whenThereAre2Users_shoudlReturn2Users() throws Exception {
      
    List<Prayer> retPrayers = new ArrayList<>();
    retPrayers.add(new Prayer("a","א"));
    retPrayers.add(new Prayer("b","ב"));
    when(prayerService.getAll()).thenReturn(retPrayers);

    mockMvc.perform(get("/prayers"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$",org.hamcrest.Matchers.hasSize (2) ));
    }

    @Test
    public void getPrayerById_whenProvidingValidId() throws Exception {
        Optional<Prayer> aPrayer = Optional.of(new Prayer(1L, "a","א"));
        when(prayerService.getById(1L)).thenReturn(aPrayer);

        mockMvc.perform(get("/prayers/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.englishName", org.hamcrest.Matchers.equalTo("a")));
    }

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

}
