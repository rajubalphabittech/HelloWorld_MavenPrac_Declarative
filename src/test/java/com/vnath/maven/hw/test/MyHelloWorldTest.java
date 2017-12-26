package com.vnath.maven.hw.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.vnath.maven.hw.MyHelloWorld;

public class MyHelloWorldTest {
	
	MyHelloWorld mhw=new MyHelloWorld();
	

	@Test
	public void unit1Test1(){
		assertEquals(3, mhw.sum(1, 2));
	}
	
	@Test
	public void unit1Test2(){
		assertEquals(3, mhw.subtract(5, 2));
	}
	
	@Test
	public void unit1Test3(){
		assertEquals(10, mhw.multiply(5, 2));
	}
	
	
	
}