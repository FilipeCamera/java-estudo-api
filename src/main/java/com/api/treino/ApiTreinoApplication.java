package com.api.treino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ApiTreinoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiTreinoApplication.class, args);
  }

}
