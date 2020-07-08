package me.glory.externalconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {
//
//    @Value("${glory.name}")
//    private String name;
//
//    @Value("${glory.age}")
//    private int age;

    @Autowired
    GloryProperties gloryProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("====================");
//        System.out.println(name);
//        System.out.println(age);
        System.out.println(gloryProperties.getName());
        System.out.println(gloryProperties.getAge());
        System.out.println("====================");
    }
}
