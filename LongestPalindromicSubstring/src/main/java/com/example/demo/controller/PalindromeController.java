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
	public ResponseEntity<Palindrome> getByOriginal(@RequestParam(value ="original") String original) {
		Palindrome palindrome = palindromeRepository.findByOriginal(original)
				.orElseGet(()->createPalindrome(original));
		return ResponseEntity.ok(palindrome);
	}
	
	private Palindrome createPalindrome(String original) {
		System.out.println("!!!!!!!!!!!!!!!!!!!");
		System.out.println(original);
		//lps is short for longest palindromic substring
		String lps=PalindromeService.longestPalindrome(original);
		System.out.println(lps);
		System.out.println("!!!!!!!!!!!!!!!!!!!");
		Palindrome palindrome = new Palindrome(original, lps);
		return palindromeRepository.save(palindrome);
	}
}
