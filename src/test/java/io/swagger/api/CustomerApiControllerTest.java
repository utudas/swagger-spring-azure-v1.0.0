package io.swagger.api;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for {@link OrderApiController} using mockMvc.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Ignore
    @Test
    public void test_articlePost_created() throws Exception {

        this.mockMvc.perform(post("/article").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "  \"name\": \"Article 1\",\n" +
                "  \"type\": \"Art Type 1\",\n" +
                "  \"price\": 1.4\n" +
                "}"
        )).andExpect(status().isCreated());
    }

    @Ignore
    @Test
    public void test_articlePut_created() throws Exception {
        this.mockMvc.perform(put("/article").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Art 2 update\",\n" +
                "    \"price\": 300,\n" +
                "    \"type\": \"Type 2 update\"\n" +
                "}"
        )).andExpect(status().isOk());
    }


}
