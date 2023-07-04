package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class WhatIfMultipleTestAnnotationsINTheClass {
	// Test Annotation can be used for any no of times in the given class upon
	// tests.
	// By default it will make the tests to execute in the alphabetical order
	//Upon each test/method we can call @test only for once.
	@Test
	public void mangoTest() {
		System.out.println("mangoTest");
	}

	@Test
	public void appleTest() {
		System.out.println("appleTest");
	}

	@Test
	public void orangeTest() {
		System.out.println("orangeTest");
	}

	@Test
	public void bananaTest() {
		System.out.println("bananaTest");
	}

	@Test
	public void grapesTest() {
		System.out.println("grapesTest");
	}

	@Test
	public void watermelonTest() {
		System.out.println("watermelonTest");
	}
}
