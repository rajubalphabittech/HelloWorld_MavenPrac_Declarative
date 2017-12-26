package com.vnath.maven.hw.test.categories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ SlowRunningTests.class })
public class Tests2 {

	@Test
	public void unit2Test1() {
		System.out.println("SlowRunningTests- unit2Test1");
		Assert.assertTrue(true);
	}

	@Test
	public void unit2Test2() {
		System.out.println("SlowRunningTests- unit2Test2");
		Assert.assertTrue(true);
	}
	
	@Test
	public void unit2Test3() {
		System.out.println("SlowRunningTests- unit2Test3");
		Assert.assertTrue(true);
	}
}
