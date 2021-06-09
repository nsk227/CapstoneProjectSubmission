package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	
	WebDriver driver;

    By homePageUserName = By.id("dropdownMenu1");

    

    public homePage(WebDriver driver){

        this.driver = driver;

    }

           public String getHomePageDashboardUserName(){

         return    driver.findElement(homePageUserName).getText();

        }

}
