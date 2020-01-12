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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.mm.kehila.common.BaseEntity;
import org.mm.kehila.congregant.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CongregantsFamily")
@Table (name="congregants_family")
public class Family extends BaseEntity {

    @Column(nullable = false)
    String lastname;

    @Column(nullable = false)
    String homeAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "congregants_family_id" )
    List<Congregant> familyMembers = new ArrayList<>();

}