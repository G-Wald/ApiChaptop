package com.openclassroom.ApiChatop;

import com.openclassroom.ApiChatop.controller.RentalsController;
import com.openclassroom.ApiChatop.model.Rentals;
import com.openclassroom.ApiChatop.repository.RentalsRepository;
import com.openclassroom.ApiChatop.service.FileSystemStorageService;
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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
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

	@Test
	void TestSaveFile(){

		String name = "galaxie.png";
		Path path = Paths.get("");
		String s = path.toAbsolutePath().toString();
		path = Paths.get(s+"/src/test/java/com/openclassroom/ApiChatop/resources/"+name);
		System.out.println("path");
		System.out.println(path);
		String originalFileName = "galaxie.png";
		String contentType = "png";
		byte[] content = null;
		try {
			content = Files.readAllBytes(path);
		} catch (final IOException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		MultipartFile result = new MockMultipartFile(name,
				originalFileName, contentType, content);
		Rentals rental = new Rentals();
		rental.setId(1);
		FileSystemStorageService fileSystemStorageService1 = new FileSystemStorageService();

		fileSystemStorageService1.store(rental,result);
	}

	/*
	@BeforeEach
	void initData() {
		rentals = new Rentals("1", "toto", 150, 2000000, "picture", "une belle maison", "1", new Date(28021999), new Date(28051999));
		Mockito.when(rentalsService.saveRental(any(Rentals.class))).thenReturn(rentals);
	}

	@Test
	//@WithMockUser(username="testTEST",password="test!31", roles= "USER")
	void testGetRental() throws Exception {
		Mockito.when(rentalsRepository.findById("1")).thenReturn(Optional.ofNullable(rentals));

		Optional<Rentals> rentalsOptional = rentralsController.getRental("1");
		Rentals rental;
		if(rentalsOptional.isPresent()){
			 rental = rentalsOptional.get();
			Assertions.assertEquals("toto", rental);
		};

		mockMvc.perform(get("/rentals/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath(".name", is("villa")));
	}




	@Test
	//@WithMockUser(username="testTEST",password="test!31", roles= "USER")
	void testGetRentals() throws Exception{
		mockMvc.perform(get("/rentals"));
	}*/
}
