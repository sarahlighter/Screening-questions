package com.example.demo.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Palindrome;
import com.example.demo.repository.PalindromeRepository;
import com.example.demo.service.PalindromeService;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class PalindromeController {
	
	@Autowired
	public PalindromeRepository palindromeRepository;
	
	@Autowired
    private PalindromeService PalindromeService;
	
	
	@GetMapping("/palindromes")
	public ResponseEntity<Palindrome> getByInputString(@RequestParam(value ="inputString") String inputString) {
		if(inputString.length()>1000){
			throw new BadRequestException("THE INPUT IS LONGER THAN 1000");
		}else {
			Palindrome palindrome = palindromeRepository.findByInputString(inputString)
					.orElseGet(()->createPalindrome(inputString));
			return ResponseEntity.ok(palindrome);
		}
		
	}
	
	private Palindrome createPalindrome(String inputString) {
		String lps=PalindromeService.longestPalindrome(inputString);//lps is short for longest palindromic substring
		Palindrome palindrome = new Palindrome(inputString, lps);
		return palindromeRepository.save(palindrome);
	}
}
