package com.jpmc.midascore;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MidasCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MidasCoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            UserRecord waldorf = new UserRecord();
            waldorf.setId("waldorf");  // Set the ID as String
            waldorf.setBalance(1000.00f);  // Use 'f' suffix for float
            userRepository.save(waldorf);

            // Add other test users if needed
            UserRecord statler = new UserRecord();
            statler.setId("statler");
            statler.setBalance(500.00f);
            userRepository.save(statler);
        };
    }
}