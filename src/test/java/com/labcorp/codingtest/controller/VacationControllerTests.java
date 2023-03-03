package com.labcorp.codingtest.controller;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.google.gson.Gson;
import com.labcorp.codingtest.domain.RequestParameter;
import com.labcorp.codingtest.service.VacationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(VacationController.class)
public class VacationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VacationService vacationService;



    @Test
    public void setWorkedDays_shouldReturnSuccess() throws Exception {
        RequestParameter param = new RequestParameter();
        param.setName("Test");
        param.setNumberOfDays("1");
        Gson gson = new Gson();
        String jsonString = gson.toJson(param);

        this.mockMvc.perform(post("/vacation/worked-days")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Success!")));
    }

    @Test
    public void takeVacation_shouldReturnSuccess() throws Exception {

        RequestParameter param = new RequestParameter();
        param.setName("Test");
        param.setNumberOfDays("1");
        Gson gson = new Gson();
        String jsonString = gson.toJson(param);


        this.mockMvc.perform(post("/vacation/take-vacation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Success!")));
    }

    @Test
    public void invokeReport_shouldEmployeeStatus() throws Exception {

        this.mockMvc.perform(get("/vacation/report"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
