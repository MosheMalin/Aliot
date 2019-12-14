package org.mm.thoracalling.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

	private static final String[] parshiotKeys = { "Bereshit", "Noach",
			"LechLecha", "Vayera", "ChayeiSara", "Toldot", "Vayetzei",
			"Vayishlach", "Vayeshev", "Miketz", "Vayigash", "Vayechi",
			"Shemot", "Vaera", "Bo", "Beshalach", "Yitro", "Mishpatim",
			"Terumah", "Tetzaveh", "KiTisa", "Vayakhel", "Pekudei", "Vayikra",
			"Tzav", "Shmini", "Tazria", "Metzora", "AchreiMot", "Kedoshim",
			"Emor", "Behar", "Bechukotai", "Bamidbar", "Nasso", "Behaalotcha",
			"Shlach", "Korach", "Chukat", "Balak", "Pinchas", "Matot", "Masei",
			"Devarim", "Vaetchanan", "Eikev", "Reeh", "Shoftim", "KiTeitzei",
			"KiTavo", "Nitzavim", "Vayeilech", "Haazinu",

			"VayakhelPekudei", "TazriaMetzora", "AchreiMotKedoshim",
			"BeharBechukotai", "ChukatBalak", "MatotMasei",
			"NitzavimVayeilech", };    

    private static List<String> parashot  = Arrays.asList(parshiotKeys);

    private static List<String> getParshot(){
        return parashot;
    }

}