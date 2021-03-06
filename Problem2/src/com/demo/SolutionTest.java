package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
	private Solution solution;

	@BeforeEach
	public void setUp() throws Exception {
		solution=new Solution();
	}

	@Test
	void testBinaryReversal() {
		assertEquals("244", solution.BinaryReversal("47"));
		assertEquals("235", solution.BinaryReversal("215"));
		assertEquals("245", solution.BinaryReversal("175"));
		assertEquals("2", solution.BinaryReversal("64"));
		assertEquals("16", solution.BinaryReversal("2048"));
		assertEquals("42208644439840", solution.BinaryReversal("5464321345124"));
		assertEquals("128", solution.BinaryReversal("1"));
	}

}
