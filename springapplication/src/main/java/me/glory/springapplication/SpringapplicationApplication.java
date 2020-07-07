package me.glory.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringapplicationApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringapplicationApplication.class);

        // ApplicationContext가 만들어지기 전에 event가 발생해야 하므로 addListeners가 필요하다.
        app.addListeners(new SampleApplicationStartingEvent());

        // ApplicationContext가 만들어진 후에 event가 발생하므로 아래 코드는 작성할 필요 없다.
        // app.addListeners(new SampleApplicationStartedEvent());
        app.run(args);
    }

}
