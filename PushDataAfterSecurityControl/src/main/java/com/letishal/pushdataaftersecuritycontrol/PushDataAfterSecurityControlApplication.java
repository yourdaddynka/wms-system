package com.letishal.pushdataaftersecuritycontrol;

import com.letishal.pushdataaftersecuritycontrol.security.model.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PushDataAfterSecurityControlApplication {
    public static void main(String[] args) {
        SpringApplication.run(PushDataAfterSecurityControlApplication.class, args);
    }
//    @Bean
//    public CommandLineRunner CommandLineRunnerBean() {
//        return  (args) -> {
//            Client admin;
//        };
//    }
}
