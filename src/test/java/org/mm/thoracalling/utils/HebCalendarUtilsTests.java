package org.mm.thoracalling.utils;

import net.sf.hebcal.*;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;

public class HebCalendarUtilsTests{

    @Test
    public void getDate() throws HebrewDateException {
        HebrewDate hd = new HebrewDate(12, 3, 2019, HebrewDate.DEFAULT_ENGLISH_LOCALE);
        assertThat(hd.getDayOfWeek()).isEqualTo(3);

    }

    @Test
    public void getParashah() throws HebrewDateException {
        JewishHolidaysCalendar jhc  = new JewishHolidaysCalendar(1, 4, 2020, HebrewDate.DEFAULT_ENGLISH_LOCALE);
        assertThat(jhc.getShabbatParsha().getLocalizedString()).isEqualTo("Vayigash");

    }

    //will check particular week - 1.12.2019 through 7.12.2019. 
    @Test
    public void getSameAndCorrectParasha_giveAnyOfWeekDays_BasedOnConcreteDate() throws HebrewDateException{
        int startWeekDate = 1;
        for (int i=0; i<7;i++){
            LocalDate localDate = LocalDate.of(2019, Month.DECEMBER, startWeekDate+i);
            assertThat(HebCalendarUtil.getNextParasha(localDate)).isEqualTo("Vayetzei");
        }
    }

    //will check particular week - 29.12.2019 through 4.1.2019. 
    @Test
    public void givenWeekCrossingYear_verifyCorrectParasha() throws HebrewDateException{
        int startWeekDate = 29;
        LocalDate localDate = LocalDate.of(2019, Month.DECEMBER, startWeekDate);
        for (int i=0; i<7;i++){
            assertThat(HebCalendarUtil.getNextParasha(localDate.plusDays(i))).isEqualTo("Vayigash");
        }
    }

}