package org.mm.kehila.importantdates;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class ImportantDateService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ImportantDateRepository importantdateRepository;

    ImportantDateService (ImportantDateRepository importantdateRepository){
        this.importantdateRepository = importantdateRepository;
    }

    List<ImportantDate> getAll(){
        return importantdateRepository.findAll();
    }

    Optional<ImportantDate> getById(Long id) {
        return importantdateRepository.findById(id);
    }

    List<ImportantDate> getImportantDateByHebMonth(Integer hebMonth)
    {
        List<ImportantDate> res = importantdateRepository.findByHebDateHebrewMonth(hebMonth);
        if (res.size() >1)
        {
            logger.warn("multiple results in month [" + hebMonth + "].");;
        }
        return res;
    }
}