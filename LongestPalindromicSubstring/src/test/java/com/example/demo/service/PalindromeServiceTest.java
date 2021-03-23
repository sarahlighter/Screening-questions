package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.PalindromeController;
@SpringBootTest
class PalindromeServiceTest {
	PalindromeService  palindromeService;
	@BeforeEach
	public void setUp() throws Exception {
		 palindromeService=new PalindromeService();
	}
	    
	@Test
	void testLongestPalindrome() {
		String input ="bananab";
		String result = palindromeService.longestPalindrome(input);
		assertEquals("bananab",  result);
	}
	@Test
	void testLongestPalindrome2() {
		String input ="abcdefghijklmnmlkjihg";
		String result = palindromeService.longestPalindrome(input);
		assertEquals("ghijklmnmlkjihg",  result);
	}
}
