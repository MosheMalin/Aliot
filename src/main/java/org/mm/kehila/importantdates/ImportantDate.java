package  org.mm.kehila.importantdates;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.mm.kehila.common.BaseEntity;
import org.mm.kehila.common.SimpleHebrewDate;
import org.mm.kehila.congregant.Congregant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportantDate extends BaseEntity {

    public ImportantDate (SimpleHebrewDate hebDate, DateType dateType){
        this.hebDate = hebDate;
        this.dateType= dateType;
    }

    @Embedded
    @Valid
    private SimpleHebrewDate hebDate;
    
    @Enumerated(EnumType.ORDINAL)    
    private DateType dateType;

    @ManyToOne
    @JsonIgnoreProperties ("importantdates")
    @ToString.Exclude
    private Congregant congregant;

}