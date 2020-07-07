package me.glory.springapplication;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

public class SampleApplicationStartedEvent implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println("-----------------------");
        System.out.println("Application is started");
        System.out.println("-----------------------");
    }

}
