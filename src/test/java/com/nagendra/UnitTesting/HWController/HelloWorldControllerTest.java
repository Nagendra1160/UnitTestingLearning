package com.nagendra.UnitTesting.HWController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.net.ssl.SSLEngineResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UnitTestingApplication.HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mc;
    @Test
    public void helloWorldBasic() throws Exception  {
        RequestBuilder rb = MockMvcRequestBuilders.get("/Hello-World").accept(MediaType.APPLICATION_JSON);
        //ResultMatcher mr =
        MvcResult mr=     mc.perform(rb)
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("Hello"))
                .andReturn();

        System.out.println("Actual Response Content: " + mr.getResponse().getContentAsString());

       // assertEquals("Hello World", mr.getResponse().getContentAsString());
    }


}
