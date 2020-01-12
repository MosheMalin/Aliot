package org.mm.kehila.family;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class FamilyService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final FamilyRepository familyRepository;

    FamilyService (FamilyRepository familyRepository){
        this.familyRepository = familyRepository;
    }

    List<Family> getAll(){
        return familyRepository.findAll();
    }

    Optional<Family> getById(Long id) {
        return familyRepository.findById(id);
    }

    List<Family> getFamilyByLastame(String lastname)
    {
        List<Family> res = familyRepository.findByLastname(lastname);
        if (res.size() >1)
        {
            logger.warn("multiple results with the same name [" + lastname + "].");;
        }
        return res;
    }
}