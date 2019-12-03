package org.mm.thoracalling.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import net.sf.hebcal.*;

public class HebCalendarUtil{

    //get next Parasha based on current date
    public static String getNextParasha () throws HebrewDateException {
        return getNextParasha(LocalDate.now());
    }

    public static String getNextParasha (LocalDate date) throws HebrewDateException {
        Date dateAsDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());        
        HebrewDate hebDate = new HebrewDate(dateAsDate, HebrewDate.DEFAULT_ENGLISH_LOCALE);
        int dayOfWeek = hebDate.getDayOfWeek();
        int gapToShabat = 7-dayOfWeek;
        LocalDate commingShabat = date.plusDays(gapToShabat);
        Date commingShabatAsDate = Date.from(commingShabat.atStartOfDay(ZoneId.systemDefault()).toInstant());        
        JewishHolidaysCalendar jhc  = new JewishHolidaysCalendar(commingShabatAsDate, HebrewDate.DEFAULT_ENGLISH_LOCALE);
        return jhc.getShabbatParsha().getLocalizedString();
    }
}