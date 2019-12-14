package org.mm.thoracalling;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name="important_dates_per_prayer")
class PrayerImportantDates{

    private @Id @GeneratedValue 
    Long id;

    @Column(nullable = false)
    private String englishName;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ImportantDatesTypes dateType;

    @Column(nullable = false)
    private int hebrewMonth;

    @Column(nullable = false)
    private int dayInMonth;

    PrayerImportantDates(){}

    PrayerImportantDates (String englishName, int hebrewMonth, int dayInMonth, ImportantDatesTypes dateType){
        this.englishName = englishName;
        this.hebrewMonth = hebrewMonth;
        this.dayInMonth = dayInMonth;
        this.dateType = dateType;
    }

    PrayerImportantDates (Long id, String englishName, int hebrewMonth, int dayInMonth, ImportantDatesTypes dateType){
        this(englishName, hebrewMonth, dayInMonth, dateType);
        this.id = id;
    }

}



