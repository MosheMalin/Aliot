package org.mm.kehila.family;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family,Long>{
    List<Family> findByLastname (String lastname);
    Optional<Family> findById(Long id);
}
