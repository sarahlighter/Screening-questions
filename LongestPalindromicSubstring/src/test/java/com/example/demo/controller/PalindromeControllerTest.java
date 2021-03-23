package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.demo.model.Palindrome;
import com.example.demo.repository.PalindromeRepository;
import com.example.demo.service.PalindromeService;

@RunWith(SpringRunner.class)
@WebMvcTest(PalindromeController.class)
class PalindromeControllerTest{
	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
	public PalindromeRepository palindromeRepository;
	
    @MockBean
    private PalindromeService palindromeService;

    private PalindromeController palindromeController;
    
    @BeforeEach
	public void setUp() throws Exception {
    	palindromeController=new PalindromeController();
	}
    
    //regular test
	@Test
	void testGetByInputString() throws Exception {
		String inputString="banana";
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/palindromes").param("inputString", inputString))
		.andDo(print())
	    .andExpect(status().isOk());
	}
	//test for long input which length >1000
	@Test
	void testGetByInputString2() throws Exception {
		String inputString="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/palindromes").param("inputString", inputString))
		.andDo(print())
	    .andExpect(status().isBadRequest());
	}
	//test for long input within 1 to 1000, but longer than 255 
	//Since in MySQL default length of varchar is 255, we need to make sure the setting of database is correct
	@Test
	void testGetByInputString3() throws Exception {
		String inputString="nrakjvyjdmwkgyknrbtarcuiymxgltnefhxzebzfwuvjhudnbhssysbhvwqgsbkhzayquhhamlfkevbrmvuxlxnrmnnhkctckktvcirkvbbcndxuqojlsvxvgfslkukcsplxalfscreenyzziwahyohelaotyvriaalkyhcatmiwlduwpewljjihkebpuawfemolgiitoljqyizkfeimvjdqpxiiwfnrjblnzxywyicmuckrzvxwxpdqqkrkjuohtuuthoujkrkqqdpxwxvzrkcumciywyxznlbjrnfwiixpqdjvmiefkziyqjlotiiglomefwaupbekhijjlwepwudlwimtachyklaairvytoalehoyhawizzyneercsflaxlpsckuklsfgvxvsljoquxdncbbvkricvtkkctckhnnmrnxlxuvmrbvekflmahhuqyazhkbsgqwvhbsysshbnduhjvuwfzbezxhfentlgxmyiucratbrnkygkwmdjyvjkarn";
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/palindromes").param("inputString", inputString))
		.andDo(print())
	    .andExpect(status().isOk());
	}
	
	
}
