package org.mm.kehila.congregant;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class CongregantService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CongregantRepository congregantRepository;

    CongregantService (CongregantRepository congregantRepository){
        this.congregantRepository = congregantRepository;
    }

    List<Congregant> getAll(){
        return congregantRepository.findAll();
    }

    Optional<Congregant> getById(Long id) {
        return congregantRepository.findById(id);
    }

    List<Congregant> getCongregantByLastame(String lastname)
    {
        List<Congregant> res = congregantRepository.findByLastnameIgnoreCase(lastname);
        if (res.size() >1)
        {
            logger.warn("multiple results with the same name [" + lastname + "].");;
        }
        return res;
    }
}