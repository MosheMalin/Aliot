package org.mm.kehila.congregant;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongregantRepository extends JpaRepository<Congregant,Long>{
    List<Congregant> findByLastname (String lastname);
    Optional<Congregant> findById(Long id);
}
