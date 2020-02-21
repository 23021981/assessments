package com.barclays.assessment.controller;

import com.barclays.assessment.controllers.BankBalanceController;
import com.barclays.assessment.reporting.Report;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BankBalanceControllerTest {

    @Mock
    private Report report;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    BankBalanceController bankBalanceController;

    @Test
    public void shouldCallPdfReport() throws Exception{
        this.mockMvc.perform(get("/pdfreport")).andDo(print()).andExpect(status().isOk());
    }

}
