package me.glory.externalconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileRunner implements ApplicationRunner{

    // application.properties 에 원하는 profile을 언급해야함.
    @Autowired
    private String hello;

    @Autowired
    private GloryProperties gloryProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("====================");
        System.out.println(hello);
        System.out.println(gloryProperties.getName());
        System.out.println("====================");
    }
}
