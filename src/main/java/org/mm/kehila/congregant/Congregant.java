package org.mm.kehila.congregant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
/*
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedAttributeNode;
*/
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.mm.kehila.common.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Congregant")
@Table (name="congregant")
/*
@NamedEntityGraphs({
    @NamedEntityGraph(name="fullItem", attributeNodes = {
            @NamedAttributeNode("id"),
            @NamedAttributeNode("firstname"),
            @NamedAttributeNode("lastname"),
            @NamedAttributeNode("phone"),
            @NamedAttributeNode("email"),
            @NamedAttributeNode("calendricBirthDate"),
            @NamedAttributeNode("hebrewBirthYear"),
            @NamedAttributeNode("hebrewBirthMonth"),
            @NamedAttributeNode("hebrewBirthDay")
    }),
    @NamedEntityGraph(name="baseItem", attributeNodes = {
        @NamedAttributeNode("id"),
        @NamedAttributeNode("firstname"),
        @NamedAttributeNode("lastname")
    })
})
*/
public class Congregant extends BaseEntity{

/*
    public Congregant (String firstName, String lastName, String phone, String email, 
                        Date birthdate, Integer hebBirthYear, Integer hebBirthMonth, Integer hebBirthDay){
        this.firstname = firstName;
        this.lastname = lastName;
        this.phone = phone;
        this.email = email;
        this.calendricBirthDate = birthdate;
        this.hebrewBirthYear = hebBirthYear;
        this.hebrewBirthMonth = hebBirthMonth;
        this.hebrewBirthDay = hebBirthDay;
        
    }

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id;
*/
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

    @Column(nullable = false)
    private Integer hebrewBirthYear;

    @Column(nullable = false)
    private Integer hebrewBirthMonth;

    @Column(nullable = false)
    private Integer hebrewBirthDay;

}