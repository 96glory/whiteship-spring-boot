package me.glory.springwebmvc2;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        // 요청 "/hello"
        // 응답
        //      - 모델 name : glory
        //      - 뷰 이름 : hello

        mockMvc.perform(get("/hello"))
                // 요청 결과가 200이니?
                .andExpect(status().isOk())
                // view의 이름이 hello니?
                .andExpect(view().name("hello"))
                // model 안에 ("name", "glory")라는 attribute가 있니?
                .andExpect(model().attribute("name", "glory"))
                // view 안에 glory라는 content가 있니?
                .andExpect(content().string(containsString("glory")))
                .andDo(print())
        ;
    }

}