package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class salesPage {

	WebDriver driver;

	By productLink = By.xpath("//*[@id=\"listProducts\"]/a");

	By searchBox = By.xpath("//*[@id=\"productListTable_filter\"]/label/input");
	By productName = By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]");
	By productBrand = By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[3]");
	By viewIcon=By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[1]/span");
	By cartIcon=By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/a[1]");
	By continueIcon=By.xpath(" //*[@id=\"cart\"]/tfoot/tr[2]/td[1]/a");
	By buyIcon=By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[2]/span");
	By checkoutIcon=By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[4]/a");

	By addone=By.xpath("//*[@id=\"addressLineOne\"]"); 
	By addtwo=By.id("addressLineTwo");
	By City=By.id("city");
	By Pcode=By.id("postalCode");
	By State=By.id("state");
	By Country=By.id("country");
	By addressTab=By.xpath("//*[@id=\"billingForm\"]/div[7]/div/button");

	By cardNum=By.id("cardNumber");
	By expMM=By.id("expityMonth");
	By expYY=By.id("expityYear");
	By cvCode=By.id("cvCode");

	By payBtn= By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/a");

	//By confirmation=By.xpath("/html/body/div/div[1]/div/div[1]/h3");




	public salesPage(WebDriver driver){

		this.driver = driver;

	} 

	public void viewProduct() throws InterruptedException{
		Thread.sleep(4000);
		driver.findElement(productLink).click();

	}
	public void salebyName() throws InterruptedException{
		driver.findElement(searchBox).sendKeys("Paracetamol"+ "\n");

		String productname=driver.findElement(productName).getText();
		System.out.println("The name column should be displaying" + " " +productname);
		//Thread.sleep(2000);
		//driver.findElement(viewIcon).click();
		Thread.sleep(2000);
		driver.findElement(buyIcon).click();
		//Thread.sleep(8000);
		//driver.findElement(cartIcon).click();
		Thread.sleep(2000);
		driver.findElement(continueIcon).click();

		System.out.println("The shopping list item should be displaying" + " " +productname);
	}

	public void salebyBrand() throws InterruptedException{

		driver.findElement(searchBox).sendKeys("Sun Pharma"+ "\n");

		String productbrand=driver.findElement(productBrand).getText();
		System.out.println("The brand column should be displaying" + " " +productbrand);

		Thread.sleep(2000);
		driver.findElement(buyIcon).click();
		Thread.sleep(2000);

		driver.findElement(checkoutIcon).click();

		System.out.println("The shopping list item should be displaying" + " " +productbrand);
		Thread.sleep(2000);

		//driver.findElement(checkoutIcon).click();

	}

	public void checkoutItem() throws InterruptedException{
		Thread.sleep(2000);

		driver.findElement(addone).sendKeys("123 Test Road");
		driver.findElement(addtwo).sendKeys("QA Lane");
		driver.findElement(City).sendKeys("TestCity");
		driver.findElement(Pcode).sendKeys("12345");
		driver.findElement(State).sendKeys("IN");
		driver.findElement(Country).sendKeys("US");
		driver.findElement(addressTab).click();
		Thread.sleep(2000);

		driver.findElement(cardNum).sendKeys("1234567890");
		driver.findElement(expMM).sendKeys("12");
		driver.findElement(expYY).sendKeys("2025");
		driver.findElement(cvCode).sendKeys("123");
		Thread.sleep(2000);

		driver.findElement(payBtn).click();

	}

	public void saleConfirmation() {
		WebElement confirmation=driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/h3"));
		String cnfNotes=confirmation.getText();
		//Assert.assertEauals("Your Order is Confirmed!!")
		System.out.println("The screen should be displaying:" + cnfNotes);

	}

	public void orderSummary() throws InterruptedException {
		Thread.sleep(2000);

		WebElement orderTable = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div[1]/h3/strong"));

		//To find  rows of table (item name)
		WebElement tableRow1 = orderTable.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[1]"));
		String rowtext1 = tableRow1.getText();
		System.out.println("First Item Purchased is : "+rowtext1);

		WebElement tableRow2 = orderTable.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[1]"));
		String rowtext2 = tableRow2.getText();
		System.out.println("First Item Purchased is : "+rowtext2);

		//to find columns of table (cost price)
		WebElement cellPrice = tableRow1.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div[2]/div/table/tbody/tr[1]/td[2]"));
		String valuePrice = cellPrice.getText();
		System.out.println("Cost of the first purcahsed item is  : " + valuePrice); 

		WebElement cellPrice2 = tableRow2.findElement(By.xpath("/html/body/div/div[1]/div/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[2]"));
		String valuePrice2 = cellPrice2.getText();
		System.out.println("Cost of the first purcahsed item is  : " + valuePrice2);

		System.out.println(rowtext1+ " " + "costs" + valuePrice);
		System.out.println(rowtext2+ " " + "costs" + valuePrice2);

		System.out.println("Congratulations, Your purchase is complete. Thank you for shopping!");


	}


	public void productsSales() throws InterruptedException{

		this.viewProduct();
		this.salebyName();
		this.salebyBrand();
		this.checkoutItem();
		this.saleConfirmation();
		this.orderSummary();
	}
}


