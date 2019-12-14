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
@Table (name="important_parashot_per_prayer")
class PrayerImportantParashot{
    private @Id @GeneratedValue 
    Long id;

    @Column(nullable = false)
    private String englishName;

    @Column(nullable = false)
    private String parasha;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private ImportantParashaTypes type;

    PrayerImportantParashot(){}

    PrayerImportantParashot (String englishName, String parasha, ImportantParashaTypes type){
        this.englishName = englishName;
        this.parasha = parasha;
        this.type = type;
    }

    PrayerImportantParashot (Long id, String englishName, String parasha, ImportantParashaTypes type){
        this(englishName, parasha, type);
        this.id = id;
    }


}