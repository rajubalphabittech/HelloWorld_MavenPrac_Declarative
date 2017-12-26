package com.vnath.maven.hw.test.categories;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ FastRunningTests.class })
public class Tests1 {

	@Test
	public void unit1Test1() {
		System.out.println("FastRunningTests- unit1Test1");
		assertTrue(true);
	}

	@Test
	public void unit1Test2() {
		System.out.println("FastRunningTests- unit1Test2");
		assertTrue(true);
	}
	
	@Test
	public void unit1Test3() {
		System.out.println("FastRunningTests- unit1Test3");
		assertTrue(true);
	}

}