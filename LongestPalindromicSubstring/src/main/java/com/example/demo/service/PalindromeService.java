package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
	
	public String longestPalindrome(String inputString) {
		int len = inputString.length();
		if (len <= 1)
			return inputString;
		char[] str = inputString.toCharArray();
		int start = 0, end = 0;
		for (int i = 0; i < len; i++) {
			int length1 = expendAroundCenter(str, i, i);
			int length2 = i + 1 < len ? str[i + 1] == str[i] ? expendAroundCenter(str, i, i + 1) : 0 : 0;
			int expendLen = Math.max(length1, length2);
			if (expendLen > end - start) {
				start = i - (expendLen - 1) / 2;
				end = i + expendLen / 2;
			}
		}

		return inputString.substring(start, end + 1);
	}

	private int expendAroundCenter(char[] str, int left, int right) {
		while (left >= 0 && right < str.length && str[left] == str[right]) {
			left--;
			right++;
		}
		return right - left - 1;
	}
}
