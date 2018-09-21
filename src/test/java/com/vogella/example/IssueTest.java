package com.vogella.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.vogella.example.controller.IssueRestController;

@RunWith(SpringRunner.class)
@WebMvcTest(IssueRestController.class)
public class IssueTest {
	
    @Autowired
    private MockMvc mvc;
    @MockBean
    private IssueRestController userService;

    @Test
    public void loginTest() throws Exception {
        mvc.perform(get("/issuereport"))
            .andExpect(status().isOk())
            .andExpect(view().name("/oi"));
    }
}