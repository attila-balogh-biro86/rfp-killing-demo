package com.littlebig.rfpkillingmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages =  "com.littlebig")
public class RfpKillingModelApplication {

  public static void main(String[] args) {
    SpringApplication.run(RfpKillingModelApplication.class, args);
  }

}
