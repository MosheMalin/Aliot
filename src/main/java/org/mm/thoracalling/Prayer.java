package org.mm.thoracalling;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table (name="prayers")
class Prayer{

    private @Id @GeneratedValue 
    Long id;

    @Column(nullable = false)
    private String englishName;

    @Column(nullable = false)
    private String hebrewName;

    Prayer(){}

    Prayer (String englishName, String hebrewName){
        this.englishName = englishName;
        this.hebrewName = hebrewName;
    }

    Prayer (Long id, String englishName, String hebrewName){
        this.id = id;
        this.englishName = englishName;
        this.hebrewName = hebrewName;
    }

}



