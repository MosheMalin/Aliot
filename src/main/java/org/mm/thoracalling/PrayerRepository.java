package org.mm.thoracalling;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PrayerRepository extends JpaRepository<Prayer,Long>{
    List<Prayer> findByEnglishName (String englishName);
    Optional<Prayer> findById(Long id);
}

