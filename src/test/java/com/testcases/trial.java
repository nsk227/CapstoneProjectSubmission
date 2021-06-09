package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class trial {
	
	public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.get("localhost:8085/medicare/");
	driver.manage().window().maximize();
	WebElement linkLogin = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
    linkLogin.click();
    
    WebElement email = driver.findElement(By.id("username"));
    email.sendKeys("kn@gmail.com");
    WebElement pwd = driver.findElement(By.id("password"));
    pwd.sendKeys("12345");
    WebElement btn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]"));
    btn.click();
    
    WebElement db = driver.findElement(By.id("dropdownMenu1"));
    db.getText();
    
    Assert.assertEquals(db.getText(), "Kavita Nigam");
    
    //Assert.assertEquals("Kavita Nigam", db);
	System.out.println("In the Homepage- It should be displaying: " + db.getText());
	
	Thread.sleep(3000);
    
	WebElement products = driver.findElement(By.xpath("//*[@id=\"listProducts\"]/a"));
    products.click();
    
    WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"productListTable_filter\"]/label/input"));
    searchbox.sendKeys("Paracetamol"+ "\n");
  
    WebElement resultgrid =driver.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr/td[2]"));
    
    String productname=resultgrid.getText();
        
    System.out.println("The name column should be displaying" + " " +productname);
    
    searchbox.clear();
    searchbox.sendKeys("Amoxicillin"+"\n");
    
    WebElement brandgrid =driver.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr/td[3]"));
    
    String brand=brandgrid.getText();
    System.out.println("The brand column should be displaying" + " " +brand);
    
    WebElement viewIcon =driver.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[1]/span"));
    viewIcon.click();
    Thread.sleep(3000);
    
    WebElement cartIcon =driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/a[1]"));
    cartIcon.click();
    
    
    
    
	}
	
	
}
