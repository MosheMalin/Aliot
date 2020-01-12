package org.mm.kehila.congregant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.mm.kehila.FamilyPosition;
import org.mm.kehila.common.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Congregant")
@Table (name="congregant")
public class Congregant extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    FamilyPosition position;

    @Column(nullable = false)
    String firstname;

    @Column(nullable = false)
    String lastname;

    String phone;

    @Email
    String email;

    @Column(nullable = false)
    Date calendricBirthDate;

    @Column(nullable = false)
    Integer hebrewBirthYear;

    @Column(nullable = false)
    Integer hHebrewBirthMonth;

    @Column(nullable = false)
    Integer hebrewBirthDay;

}