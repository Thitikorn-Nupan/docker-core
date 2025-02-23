package com.ttknp.springbootondockerapp;


import com.ttknp.springbootondockerapp.controller.ControlApi;
import com.ttknp.springbootondockerapp.entity.Romance;
import com.ttknp.springbootondockerapp.service.BooksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ControlApi.class)
public class ControlApiTest {

    // *** using MockMvc class to make REST API calls.
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean // @MockBean is duplicate use @MockitoBean instead
    private BooksService<Romance> booksService;

    @Test
    public void testRomanceReadsApi() throws Exception {
        // ** provider
        given(booksService.reads()).willReturn(getRomances());

        // ** call the provider ** and set basic authenticate on http header
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/romance/reads");

        // ** ResultActions class to handle the response of the REST API.
        ResultActions response = mockMvc.perform(request);

        // then - verify the output
        response
                .andExpect(status().isAccepted())
                .andExpect(header().exists("Data"))
                .andExpect(header().string("Data","total of romances book is 3"));
    }

    @Test
    public void testRomanceReadApi() throws Exception {
        given(booksService.read("R001")).willReturn(getRomance());

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/romance/read/{id}","R001");

        ResultActions response = mockMvc.perform(request);

        response
                .andExpect(status().isAccepted())
                .andExpect(header().exists("Data"))
                .andExpect(header().string("Data","romance id R001 exists true"));
    }

    private Iterable<Romance> getRomances() {
        // i want only list size
        return List.of(new Romance(), new Romance(), new Romance());
    }

    private Romance getRomance() {
        return new Romance("R001","",0);
    }


}
