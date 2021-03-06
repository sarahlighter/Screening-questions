package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "palindrome", uniqueConstraints = { @UniqueConstraint(columnNames = { "inputString" }) })
public class Palindrome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@NaturalId
	@NotBlank
	public String inputString;
	
	public String longestPalindrome;

	public Palindrome() {

	}

	public Palindrome(@NotBlank String inputString, String longestPalindrome) {
		this.inputString = inputString;
		this.longestPalindrome = longestPalindrome;
	}

	public Palindrome(long id, @NotBlank String inputString, String longestPalindrome) {
		this.id = id;
		this.inputString = inputString;
		this.longestPalindrome = longestPalindrome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}

	public String getLongestPalindrome() {
		return longestPalindrome;
	}

	public void setLongestPalindrome(String longestPalindrome) {
		this.longestPalindrome = longestPalindrome;
	}

}
