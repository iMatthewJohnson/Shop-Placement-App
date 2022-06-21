package info.oldcolony.shopplacementapp;

import info.oldcolony.shopplacementapp.cruds.StudentEntity;
import info.oldcolony.shopplacementapp.cruds.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    @Autowired
    CommandLineRunner initDatabase(StudentRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new StudentEntity(5,"Bilbo", "Baggins")));
            log.info("Preloading " + repository.save(new StudentEntity(6,"Frodo", "Baggins")));
        };
    }
}
