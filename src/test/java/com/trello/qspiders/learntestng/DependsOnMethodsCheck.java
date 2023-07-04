package com.trello.qspiders.learntestng;

import org.testng.annotations.Test;

public class DependsOnMethodsCheck {
	@Test(dependsOnMethods = "signIn")
	public void login() {
		System.out.println("login");
	}
	@Test(dependsOnMethods = "login")
	public void logout() {
		System.out.println("logout");
		//int a[] = {1,2,3};
		//System.out.println(a[1]);
	}

	@Test
	public void signIn() {
		System.out.println("signIn");
		//int a[] = {1,2,3};
		//System.out.println(a[2]);
	}

	@Test(dependsOnMethods = "login")
	public void uploadProfilePic() {
		System.out.println("uploadProfilePic");
	}

	@Test(dependsOnMethods = {"login","uploadProfilePic"})
	public void sendFriendRequest() {
		System.out.println("sendFriendRequest");
		//int a[] = {1,2,3};
		//System.out.println(a[2]);
	}

	@Test(dependsOnMethods = {"login", "uploadProfilePic", "sendFriendRequest"})
	public void acceptFriendRequest() {
		System.out.println("acceptFriendRequest");
	}

}
