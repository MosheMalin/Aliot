package org.mm.thoracalling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
class DbManaging {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    CommandLineRunner initDb (PrayerRepository prayerRepository){
        return args -> {
            logger.info("Preloading: " + prayerRepository.save(new Prayer("MosheMalin","משה מלין")));
            logger.info("Preloading: " + prayerRepository.save(new Prayer("NissimDerdiger","ניסים דרדיגר")));
        };
    }

}