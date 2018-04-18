package com.richway.basic;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.richway.basic.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {
	private MockMvc mvc;

	@InjectMocks
	UserController userController;

	@Before
	public void setup() {
		// MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testUserController() throws Exception {
		Matcher<String> matchSuc = equalTo("success");

		RequestBuilder request = null;
		request = get("/users/");

		ResultActions act = mvc.perform(request);
		String strInfo = act.andReturn().getResponse().getContentAsString();
		System.out.println(strInfo);
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

		request = post("/users/").param("id", "1").param("name", "测试的人").param("age", "20");
		mvc.perform(request).andExpect(content().string(matchSuc));

		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试的人\",\"age\":20}]")));

		// 4put修改id为1的user
		request = put("/users/1").param("name", "我的测试").param("age", "50");
		mvc.perform(request).andExpect(content().string(matchSuc));

		// 5获取user为1的
		request = get("/users/1");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"我的测试\",\"age\":50}")));

		// 6删除id为1的user
		request = delete("/users/1");
		mvc.perform(request).andExpect(content().string(matchSuc));

		// 7获取列表
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
	}
}
