package com.trello.qspiders.endtoend;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.trello.qspiders.pomrepository.TrelloHomePage;

public class TrelloEndToEndScenarios {

WebDriver driver;
@Test
public void createAndDeleteBoard() {
	TrelloHomePage homePage = new TrelloHomePage(driver);
	homePage.getLoginOption().click();
}
}
