package com.vnath.maven.hw.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vnath.maven.hw.MyAdaptor;

public class MyAdaptorIT {
	private MyAdaptor adaptor = new MyAdaptor();
	
	@Test
	public void testSayHello(){
		assertEquals("Hello Vish",adaptor.sayHello("Vish"));
	}

}
