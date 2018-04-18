package com.richway.basic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.richway.basic.controller.BaseController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RichBusiBaseApplicationTests {

	private MockMvc mvc;
	
	@InjectMocks
	BaseController baseController;
	
	@Before
	public void setup() {
		//MockitoAnnotations.initMocks(this);
		mvc=MockMvcBuilders.standaloneSetup(baseController).build();
	}
	
	@Test
	public void contextLoads() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/basic/hello").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("hello world!")));
	}

}
