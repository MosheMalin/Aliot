package org.mm.kehila.congregant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/*
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedAttributeNode;
*/
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.mm.kehila.common.*;
import org.mm.kehila.importantdates.ImportantDate;

@Data
//@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Congregant")
@Table (name="congregant")

public class Congregant extends BaseEntity{


    public Congregant (String firstName, String lastName, String phone, String email, 
                        Date birthdate, SimpleHebrewDate hebDate ){
        this.firstname = firstName;
        this.lastname = lastName;
        this.phone = phone;
        this.email = email;
        this.calendricBirthDate = birthdate;
        this.hebrewBirthDate = hebDate;
    }

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column
    private String phone;

    @Column
    @Email
    private String email;

    @Column(nullable = false)
    private Date calendricBirthDate;

    @Embedded
    @Valid
    private SimpleHebrewDate hebrewBirthDate;

    @OneToMany (cascade = CascadeType.ALL,  mappedBy = "congregant")
    //exclude to avoid infinete loop
    @JsonIgnoreProperties ("congregant")
    List<ImportantDate> importantDates = new ArrayList<>();

    public void addImportantDate(ImportantDate importantDate){
        importantDates.add(importantDate);
        importantDate.setCongregant(this);
    }

    public void removeImportantDate(ImportantDate importantDate){
        importantDates.remove(importantDate);
        importantDate.setCongregant(null);
    }

}