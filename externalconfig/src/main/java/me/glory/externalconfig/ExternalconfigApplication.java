package me.glory.externalconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(GloryProperties.class)
public class ExternalconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalconfigApplication.class, args);
    }

}
