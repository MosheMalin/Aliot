package org.mm.kehila.common;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class SimpleHebrewDate{

    private Integer hebrewYear;

    private Integer hebrewMonth;

    private Integer hebrewDay;    
 }