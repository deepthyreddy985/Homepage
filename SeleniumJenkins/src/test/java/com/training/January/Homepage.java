package com.training.January;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Homepage {
	
	static ExtentReports extent;
	static ExtentTest homeTest;
	
	
	public static void main(String[] args)  throws InterruptedException {
		
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/homeExtentReport.html, true");
		homeTest=extent.startTest("launch Test");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver;
		driver=new ChromeDriver();
		//WebDriverWait wait=new WebDriverWait(driver,40);
		driver.get("https://selenium-prd.firebaseapp.com/home.html");
		System.out.println("application launched successfully");
		//wait.wait(20);
		
		Thread.sleep(4000);
		WebElement emailUsername=driver.findElement(By.id("email_field"));
		emailUsername.clear();
		emailUsername.sendKeys("admin123@gmail.com");
		homeTest.log(LogStatus.PASS,"username entered successfully");
		System.out.println("username entered successfully");
		//enter password
		WebElement password=driver.findElement(By.id("password_field"));
		password.clear();
		password.sendKeys("admin123");
		homeTest.log(LogStatus.PASS,"password entered successfully");
		System.out.println("entered password successfully");
		//login successfully
		WebElement LoginButton=driver.findElement(By.xpath("//button[@onclick='login()']"));
		
		LoginButton.click();
		homeTest.log(LogStatus.PASS,"button clicked successfully");
		System.out.println("login successfully");
		Thread.sleep(4000);
		//click on home button
		WebElement hometab=driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
				hometab.click();
		//enter name
				WebElement name=driver.findElement(By.id("name"));
				name.clear();
				name.sendKeys("Deepthy");
				
				//enter the father name
				WebElement Fathername=driver.findElement(By.id("lname"));
				Fathername.clear();
				Fathername.sendKeys("Subba Reddy");
				
				//enter postal code
				
				WebElement postalcode=driver.findElement(By.id("postaladdress"));
				postalcode.clear();
				postalcode.sendKeys("80129");
				//enter personal address
				WebElement PersonalAddress=driver.findElement(By.id("personaladdress"));
				PersonalAddress.clear();
				PersonalAddress.sendKeys("denver");
		//select gender
				WebElement Gender=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/form[1]/div[5]/span[2]/input[1]"));
				Gender.click();
				//select the city
				Select city= new Select(driver.findElement(By.id("city")));
				//city.selectByIndex(1);
				city.selectByVisibleText("GOA");
				//select the course from the dropdown
				Select course= new Select(driver.findElement(By.id("course")));
				course.selectByValue("mba");
				//select district
				Select district=new Select(driver.findElement(By.id("district")));
				district.selectByValue("goa");
				
				//select state
				Select  state=new  Select(driver.findElement(By.xpath("//select[@name='state']")));
				state.selectByValue("btech");
				//pincode
				WebElement pincode=driver.findElement(By.id("pincode"));
				pincode.sendKeys("80129");
				//enter  email
				WebElement email=driver.findElement(By.id("emailid"));
				email.sendKeys("deepthyreddy985@gmail.com");
				
				WebElement submit=driver.findElement(By.xpath("//button[@class='bootbutton']"));
				submit.click();
				//switch to tab actions
				WebElement switchto=driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
				switchto.click();
				WebElement alert=driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
				alert.click();
				WebElement WindowAlert=driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
				WindowAlert.click();
				Thread.sleep(3000);
				Alert windowsAlert = driver.switchTo().alert();
				//Alert alertText=driver.switchTo().alert();
				String alerttext=windowsAlert.getText();
				System.out.println("alert is"+alerttext);
				Thread.sleep(3000);
				windowsAlert.accept();
				
				//switch to prompt alert and dismiss the text from the alert
				WebElement promptAlert=driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
				promptAlert.click();
				Thread.sleep(3000);
				Alert promptalert=driver.switchTo().alert();
				promptalert.sendKeys("Deepthy");
				Thread.sleep(3000);
				promptalert.accept();
				extent.endTest(homeTest);
				extent.flush();
				extent.close();
				
				
				
				
		
				
				
	}
	
}
