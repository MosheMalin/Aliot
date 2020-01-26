package org.mm.kehila.congreganttofamily;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.mm.kehila.FamilyPosition;
import org.mm.kehila.common.BaseEntity;
import org.mm.kehila.congregant.Congregant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CongregantToFamily")
@Table (name="CongregantToFamily")
public class CongregantToFamily extends BaseEntity {

    @OneToOne
    Congregant congregant;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    FamilyPosition position;

}