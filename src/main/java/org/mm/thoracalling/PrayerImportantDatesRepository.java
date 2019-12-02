package org.mm.thoracalling;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PrayerImportantDatesRepository extends JpaRepository<PrayerImportantDates,Long>{
    List<PrayerImportantDates> findByEnglishName (String englishName);
    Optional<PrayerImportantDates> findById(Long id);
    List<PrayerImportantDates> findByDate (LocalDate date);
}

