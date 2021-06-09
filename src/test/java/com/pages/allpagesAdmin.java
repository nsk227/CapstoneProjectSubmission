package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class allpagesAdmin {

	WebDriver driver;

	By about = By.xpath("//*[@id=\"about\"]/a");
	By contact = By.xpath("//*[@id=\"contact\"]/a");
	By viewList = By.xpath("//*[@id=\"listProducts\"]/a");
	By Antipyretics=By.id("a_Antipyretics");
	By Analgesics=By.id("a_Analgesics");
	By Antibiotics=By.id("a_Antibiotics");
	By home=By.xpath("/html/body/div[2]/nav/div/div[1]/a");

	By manageWindow=By.xpath("//*[@id=\"manageProduct\"]/a");
	By name=By.id("name");
	By brand=By.id("brand");
	By description=By.id("description");
	By price=By.id("unitPrice");
	By qty=By.id("quantity");
	By file=By.id("file");
	By save=By.xpath("//*[@id=\"product\"]/div[8]/div/input");

	By productLink = By.xpath("//*[@id=\"listProducts\"]/a");	
	By searchBox = By.xpath("//*[@id=\"productListTable_filter\"]/label/input");
	By productName = By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]");
	By productBrand = By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[3]");

	By viewIcon= By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[1]/span");
	By editIcon= By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[6]/a[2]/span");
	By addIcon= By.xpath("//*[@id=\"product\"]/div[7]/div/div/button");
	By newName= By.id("name");
	By newDesc= By.id("description");
	By saveBtn= By.xpath("//*[@id=\"categoryForm\"]/div[3]/div/input");

	By dropDown=By.xpath("//*[@id=\"categoryId\"]/option[5]");
	By saveChange=By.xpath("//*[@id=\"product\"]/div[8]/div/input");

	By newSearch=By.xpath("//*[@id=\"productsTable_filter\"]/label/input");
	By disable=By.xpath("//*[@id=\"productsTable\"]/tbody/tr[1]/td[7]/label/div");
	By okay=By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");	
	By Cokay=By.xpath("/html/body/div[3]/div/div/div[2]/button");

	public allpagesAdmin(WebDriver driver){

		this.driver = driver;

	} 

	public void viewAbout() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(about).click();

		WebElement aboutUs=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/p"));
		String Result1=aboutUs.getText();



		if (Result1.equalsIgnoreCase("This is an about us page")) {
			System.out.println("About Page should display : "+Result1);	
		}


	}

	public void viewContact() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(contact).click();

		WebElement contactPage=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/p"));
		String Result2=contactPage.getText();



		if (Result2.equalsIgnoreCase("This is an about us page")) {
			System.out.println("Contact Page should display : "+Result2);	
		}

	}

	public void viewItems() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(viewList).click();
		Thread.sleep(2000);
		driver.findElement(Antipyretics).click();
		Thread.sleep(2000);

		WebElement firstTable = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/thead/tr/th[2]"));

		//To find  rows of table (item name)
		WebElement productRow1 = firstTable.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]"));
		String row1 = productRow1.getText();
		System.out.println("First Item on the Antipyretics list is : "+row1);

		driver.findElement(Analgesics).click();
		Thread.sleep(2000);

		WebElement secondTable = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/thead/tr/th[2]"));

		//To find  rows of table (item name)
		WebElement productRow2 = secondTable.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]"));
		String row2 = productRow2.getText();
		System.out.println("First Item on the Analgesics list is : "+row2);


		driver.findElement(Antibiotics).click();
		Thread.sleep(3000);

		WebElement thirdTable = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/thead/tr/th[2]"));

		//To find  rows of table (item name)
		WebElement productRow3 = thirdTable.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]"));
		String row3 = productRow3.getText();
		System.out.println("First Item on the Antibiotics list is : "+row3);

	}

	public void viewHome() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(home).click();

		WebElement mainPage=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/p"));
		String Result3=mainPage.getText();

		if (Result3.equalsIgnoreCase("Categories")) {
			System.out.println("Main Page should display : "+Result3);	
		}

	}

	public void manageProducts() throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(manageWindow).click();
		Thread.sleep(2000);
		driver.findElement(name).sendKeys("vaccine");
		driver.findElement(brand).sendKeys("pfyzier");
		driver.findElement(description).sendKeys("Life Saver dose");
		driver.findElement(price).sendKeys("25");
		driver.findElement(qty).sendKeys("100");

		WebElement upload_file = driver.findElement(By.xpath("//*[@id=\"file\"]"));

		upload_file.sendKeys("/home/khadkasnareshgm/Naresh/vaccine.jpg");

		Thread.sleep(5000);

		driver.findElement(save).click();

	}

	public void viewProduct() throws InterruptedException{
		Thread.sleep(4000);
		driver.findElement(productLink).click();

	}
	public void searchbyName() throws InterruptedException{
		driver.findElement(searchBox).sendKeys("vaccine"+ "\n");

		String productname=driver.findElement(productName).getText();
		System.out.println("The name column should be displaying" + " " +productname);

		Thread.sleep(4000);
		WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"productListTable_filter\"]/label/input"));
		searchbox.clear();



	}

	public void searchbyBrand() throws InterruptedException{
		driver.findElement(searchBox).sendKeys("pfyzier"+ "\n");

		String productbrand=driver.findElement(productBrand).getText();
		System.out.println("The brand column should be displaying" + " " +productbrand);

	}

	public void editProduct() throws InterruptedException{

		Thread.sleep(3000);
		driver.findElement(editIcon).click();
		Thread.sleep(2000);

		Thread.sleep(4000);
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys("New Vaccine");
		Thread.sleep(4000);
		driver.findElement(brand).clear();
		driver.findElement(brand).sendKeys("J&J");
		driver.findElement(dropDown).click();
		driver.findElement(saveChange).click();
		System.out.println("Added Product- Vaccine- successfully Updated");


	}

	public void editnewProduct() throws InterruptedException{

		Thread.sleep(3000);

		driver.findElement(newSearch).sendKeys("New Vaccine"+ "\n");
		Thread.sleep(3000);

		driver.findElement(disable).click();
		Thread.sleep(3000);

		driver.findElement(okay).click();
		Thread.sleep(3000);

		driver.findElement(Cokay).click();
		Thread.sleep(3000);

		System.out.println("Added Product- Vaccine- successfully Disabled");

	}



	public void pagenavigations() throws InterruptedException{

		this.viewAbout();
		this.viewContact();
		this.viewItems();
		this.viewHome();
		this.manageProducts();
		this.viewProduct();
		this.searchbyName();
		this.searchbyBrand();
		this.editProduct();
		this.editnewProduct();


	}
}