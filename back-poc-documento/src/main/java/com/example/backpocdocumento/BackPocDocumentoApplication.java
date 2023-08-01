package com.example.backpocdocumento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.backpocdocumento.models")
public class BackPocDocumentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackPocDocumentoApplication.class, args);
    }

}
