package org.mm.kehila.family;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.mm.kehila.common.BaseEntity;
import org.mm.kehila.congreganttofamily.CongregantToFamily;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Family")
@Table (name="family")
public class Family extends BaseEntity {

    public Family(String lastName, String homAddress){
        this.lastname =  lastName;
        this.homeAddress = homAddress;
    }

    @Column(nullable = false)
    @NotNull
    private String lastname;

    @Column(nullable = false)
    @NotNull
    private String homeAddress;

    @OneToMany(cascade = CascadeType.ALL)
    List<CongregantToFamily> familyMembers = new ArrayList<>();
}