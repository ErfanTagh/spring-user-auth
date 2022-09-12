package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UsersRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Users("Bilbo Baggins", "burglar@gmail","123")));
            log.info("Preloading " + repository.save(new Users("Frodo Baggins", "thief","pass123")));
        };

        //mvnw clean spring-boot:run
    }
}