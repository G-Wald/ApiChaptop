package com.openclassroom.ApiChatop.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.openclassroom.ApiChatop.controller.RentalsController;
import com.openclassroom.ApiChatop.service.RentalsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = RentalsController.class)
public class RentalsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RentalsService rentalsService;

    @Test
    public void testGetRentals() throws Exception {
        mockMvc.perform(get("/rentals"))
                .andExpect(status().isOk());
    }
}
