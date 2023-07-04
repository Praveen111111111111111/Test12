package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class UserDefinedOrder {
	// priority is the @Test argument
		// priority will help us to run the script in userdefined order 
		// priority will accept the int values.
		// priority will ignore the defined values if it is -ve or zero>>
		// it will default alphabetical order.
	
	@Test(priority = 2)
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
