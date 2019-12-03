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
        JewishHolidaysCalendar jhc  = new JewishHolidaysCalendar(12, 7, 2019, HebrewDate.DEFAULT_ENGLISH_LOCALE);
        assertThat(jhc.getShabbatParsha().getLocalizedString()).isEqualTo("Vayetzei");

    }

    //will check particular week - 1.12.2019 through 7.12.2019. 
    @Test
    public void getSameAndCorrectParasha_giveAnyOfWeekDays_BasedOnConcreteDate() throws HebrewDateException{

        int startWeekDate = 1;
        LocalDate localDate = LocalDate.of(2019, Month.DECEMBER, 1);
        assertThat(HebCalendarUtil.getNextParasha(localDate)).isEqualTo("Vayetzei");


    }


}