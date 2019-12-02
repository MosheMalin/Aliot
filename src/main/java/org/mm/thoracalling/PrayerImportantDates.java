package org.mm.thoracalling;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class PrayerImportantDates{

    private @Id @GeneratedValue 
    Long id;

    @Column(nullable = false)
    private String englishName;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    ImportantDatesTypes dateType;

    PrayerImportantDates(){}

    PrayerImportantDates (String englishName, LocalDate date, ImportantDatesTypes dateType){
        this.englishName = englishName;
        this.date = date;
        this.dateType = dateType;
    }

    PrayerImportantDates (Long id, String englishName, LocalDate date, ImportantDatesTypes dateType){
        this(englishName, date, dateType);
        this.id = id;
    }

}



