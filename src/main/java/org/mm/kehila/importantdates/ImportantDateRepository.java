package org.mm.kehila.importantdates;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.mm.kehila.common.SimpleHebrewDate;

@Repository
public interface ImportantDateRepository extends JpaRepository<ImportantDate,Long>{
    List<ImportantDate> findByHebDateHebrewMonth (Integer hebrewMonth);
    Optional<ImportantDate> findById(Long id);
}
