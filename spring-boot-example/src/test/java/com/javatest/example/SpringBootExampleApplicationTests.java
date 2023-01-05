package com.javatest.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.javatest.example.dto.CurrencyVO;
import com.javatest.example.repository.CoinDeskVORepository;
import com.javatest.example.repository.CurrencyVORepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringBootExampleApplicationTests {
	
	@Autowired
	CurrencyVORepository currRepo;
	
	@Autowired
	CoinDeskVORepository coinRepo;
	
    @Autowired
    private MockMvc mvc;
    
	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getAllCurrency() throws Exception {
	   String uri = "/currency";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   System.out.println(content);
	   assertNotNull( "object is null", content);
	}
	
	@Test
	public void getCurrency() throws Exception {
	   String uri = "/currency/getCurrency/2";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   CurrencyVO data = new Gson().fromJson(content, CurrencyVO.class);
	   assertNotNull( "object is null", data);
	}
	
	@Test
	public void insertCurrency() throws Exception {
	   String uri = "/currency/insert?cname=台幣&ename=TWD&rate=1.206&symbol=$&memo=Taiwan Dollar&rate_float=1.206";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertNotNull( "object is null", content);
	}
	
	@Test
	public void delCurrency() throws Exception {
	   String uri = "/currency/delete/ename?ename=TWD";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   System.out.println(content);
	   String message = "delete the currency is success";
	   assertEquals( "objects aren't identical", content, message);
	}
	
	@Test
	public void getMessage() throws Exception {
	   String uri = "/coinDesk/getMessage?id=1";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertNotNull( "object is null", content);
	}
	
}
