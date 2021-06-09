package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	
	WebDriver driver;
	
	//By linkLogin =By.xpath("//*[@id=\"login\"]/a");

    By userName = By.name("username");

    By password = By.id("password");

    By login = By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]");

    public loginPage(WebDriver driver){

        this.driver = driver;

    }
    
     public void userName(String strUserName){

        driver.findElement(userName).sendKeys(strUserName);

    }

   
    public void password(String strPassword){

         driver.findElement(password).sendKeys(strPassword);

    }

   
    public void login(){

            driver.findElement(login).click();

    }

     public String getLoginTitle(){

     return driver.getTitle();

    }

       public void loginToMedicare(String strUserName,String strPasword){

    	this.loginLink();
    

        this.userName(strUserName);

             this.password(strPasword);

                this.login();        
    }

	private void loginLink() {
		
		
	}

	
}
