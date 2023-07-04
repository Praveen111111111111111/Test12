package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class ExecuteSameTestcaseMultipleTimes {
	// @Test will accept more than one argument
	// invovationCount will accept int as a value and default value is 1
	// this argument will helps in running the same test case for multiple times.
	@Test(priority = 2, invocationCount = 3)
	public void mangoTest() {
		System.out.println("mangoTest");
	}

	@Test(priority = 6)
	public void appleTest() {
		System.out.println("appleTest");
	}

	@Test(priority = 5)
	public void orangeTest() {
		System.out.println("orangeTest");
	}

	@Test(priority = 3)
	public void bananaTest() {
		System.out.println("bananaTest");
	}

	@Test(priority = 4)
	public void grapesTest() {
		System.out.println("grapesTest");
	}

	@Test(priority = 1)
	public void watermelonTest() {
		System.out.println("watermelonTest");
	}
}
