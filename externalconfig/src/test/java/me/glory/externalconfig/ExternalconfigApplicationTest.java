package me.glory.externalconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "glory.name=youngkwangsong")
public class ExternalconfigApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void contestLoads(){
        assertThat(environment.getProperty("glory.name"))
                .isEqualTo("testyoungkwang");
    }

}