package org.mm.kehila.common;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class SimpleHebrewDate{

    @Max(6000)
    @Min(5660)
    private int hebrewYear;

    @Max(12)
    @Min(1)
    private int hebrewMonth;

    @Max(30)
    @Min(1)
    private int hebrewDay;    
 }