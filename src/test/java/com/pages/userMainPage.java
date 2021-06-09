package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userMainPage {

	WebDriver driver;

	//By viewProductList = By.xpath("(\"//*[@id=\\\"listProducts\\\"]/a");



	public userMainPage(WebDriver driver){

		this.driver = driver;

	}


	
	public void ProductList() throws InterruptedException{
		
			driver.navigate().refresh();
		WebElement productList=driver.findElement(By.xpath("//*[@id=\"listProducts\"]/a"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", productList);
		productList.click();
		System.out.println("1");
				
		WebElement table = driver.findElement(By.className("table table-striped table-borderd dataTable"));
		List<WebElement> rows = table.findElements(By.tagName("td"));

		//we loop throw all the rows - then with respect to each row, we get the cell values

		for(WebElement row : rows)
		{
		  List<WebElement> cols = row.findElements(By.tagName("td"));
		  for(WebElement col : cols)
		   {
		      System.out.print(col.getText() + "\t");
		   }
		   System.out.print("\n"); 
		}

		}
	}



