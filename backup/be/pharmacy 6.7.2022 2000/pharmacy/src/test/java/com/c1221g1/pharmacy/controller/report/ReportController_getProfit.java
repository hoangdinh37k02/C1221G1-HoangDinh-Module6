package com.c1221g1.pharmacy.controller.report;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReportController_getProfit {
    @Autowired
    private MockMvc mockMvc;
    /**
     * this method to test method getProfit with param "startTime" that you input is null
     * @author DinhH
     * @Time 13:30 30/06/2022
     */
    @Test
    public void getProfit_startTime_7() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/profit").
                param("startTime","null")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this method to test method getProfit with param "startTime" that you input is empty
     * @author DinhH
     * @Time 13:30 30/06/2022
     */
    @Test
    public void getProfit_startTime_8() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/profit").
                param("startTime","")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this method to test method getProfit that the result return is empty
     * @author DinhH
     * @Time 13:30 30/06/2022
     */
    @Test
    public void getProfit_startTime_endTime_10() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/profit").
                param("startTime","2022-05-01").
                param("endTime","2022-05-01")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this method to test method getProfit with param "endTime" that you input is null
     * @author DinhH
     * @Time 13:30 30/06/2022
     */
    @Test
    public void getProfit_endTime_7() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/profit").
                param("endTime","null")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this method to test method getProfit with param "endTime" that you input is empty
     * @author DinhH
     * @Time 13:30 30/06/2022
     */
    @Test
    public void getProfit_endTime_8() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/profit").
                param("endTime","")
        ).andDo(print()).andExpect(status().is4xxClientError());
    }

    /**
     * this method to test method getProfit that the result return is not empty
     * @author DinhH
     * @Time 13:30 30/06/2022
     */
    @Test
    public void getRevenue_startTime_endTime_11() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.
                get("/api/manager_report/report/profit").
                param("startTime","2022-05-01").
                param("endTime","2021-05-01")
        ).andDo(print()).andExpect(status().is2xxSuccessful());
    }
}
