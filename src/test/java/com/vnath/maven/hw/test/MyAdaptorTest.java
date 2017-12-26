package com.vnath.maven.hw.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vnath.maven.hw.MyAdaptor;

public class MyAdaptorTest {
	MyAdaptor adaptor=new MyAdaptor();
	
	
	@Test
	public void testSayHello(){
		assertEquals("Hello Vishwa", adaptor.sayHello("Vishwa"));
	}
	
	@Test
	public void testSayHi(){
		assertEquals("Hi Vishwa", adaptor.sayHi("Vishwa"));
	}
}
