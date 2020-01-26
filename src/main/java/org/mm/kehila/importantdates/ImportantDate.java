package  org.mm.kehila.importantdates;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.mm.kehila.common.BaseEntity;
import org.mm.kehila.common.SimpleHebrewDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportantDate extends BaseEntity {

    @Embedded
    private SimpleHebrewDate hebDate;
    
    private DateType dateType;

}