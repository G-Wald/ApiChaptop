package com.openclassroom.ApiChatop;

import com.openclassroom.ApiChatop.controller.RentalsController;
import com.openclassroom.ApiChatop.model.Rentals;
import com.openclassroom.ApiChatop.repository.RentalsRepository;
import com.openclassroom.ApiChatop.service.RentalsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ApiChatopApplicationTests {

	@InjectMocks
	RentalsController rentralsController;

	@Mock
	RentalsRepository rentalsRepository;

	@Autowired
	public MockMvc mockMvc;

	private Rentals rentals;

	@Mock
	RentalsService rentalsService;

	@BeforeEach
	void initData() {
		rentals = new Rentals("1", "toto", .... );

		Mockito.when(rentalsService.saveRental(any(Rentals.class))).thenReturn(rentals);
	}

	@Test
	//@WithMockUser(username="testTEST",password="test!31", roles= "USER")
	void testGetRental() throws Exception {

		Mockito.when(rentalsRepository.findById("1")).thenReturn(rentals);


		Optional<Rentals> rentalsOptional = rentralsController.getRental("1");

		Assertions.assertEquals("toto", rentalsOptional.get().getName());

		mockMvc.perform(get("/rentals/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath(".name", is("villa")));
	}
	@Test
	//@WithMockUser(username="testTEST",password="test!31", roles= "USER")
	void testGetRentals() throws Exception{
		mockMvc.perform(get("/rentals"));
	}
}
