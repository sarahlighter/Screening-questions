package com.demo;
import java.math.BigInteger; 
/*
 * Have the function BinaryReversal(str) take the str parameter being passed, which will be a positive integer, take its binary representation (padded to the nearest N * 8 bits), reverse that string of bits, and then finally return the new reversed string in decimal form. For example: if str is "47" then the binary version of this integer is 101111 but we pad it to be 00101111. Your program should reverse this binary string which then becomes: 11110100 and then finally return the decimal version of this string, which is 244.
 */
public class Solution {
	
	public String BinaryReversal(String str) {
		//Using BigInteger in case of input string is too long
		BigInteger number = new BigInteger(str);
		//convert number into binary 
		String binary=number.toString(2);
		//reverse the binary version of input value
		StringBuffer sb= new StringBuffer(binary);
		sb=sb.reverse();
		//padded to the nearest N * 8 bits
		while(sb.length()%8!=0) {
			sb.append(0);
		}
		//convert value from binary to decimal 
		BigInteger reversedInt=new BigInteger(sb.toString(),2);
		return reversedInt.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution= new Solution();
		String result=solution.BinaryReversal("47");
		System.out.println(result);
	}

}
