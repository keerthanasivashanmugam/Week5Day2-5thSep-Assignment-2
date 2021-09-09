package week5.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowDevCreateINC extends  ServiceNowBaseClass {

		
	@Test(dataProvider="runexcel")
	public void runCreateINC(String Caller , String Shortdescription) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//input[@id='filter']")).click();
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		String incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident no : "+incidentNumber);
		
		
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys(Caller);
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//tr[@class='ac_highlight']")).click();
		System.out.println("Caller Name : "+Caller);
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys(Shortdescription);
		System.out.println("Short Description : "+Shortdescription);
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		WebElement selectWebElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectWebElement);
		drpdwn.selectByValue("number");
		WebElement searchINC = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC.sendKeys(incidentNumber);
		searchINC.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String INCNo = driver.findElement(By.xpath("//label[@class='checkbox-label']/span")).getText();
		System.out.println(INCNo);
		if(INCNo.contains(incidentNumber))
		{
			System.out.println("Created INC is displayed");
		}else
			System.out.println("Created INC is not displayed");
	
	}
	
	@DataProvider 
	public String[][] runexcel() throws IOException   {
	String[][] data = ServiceNowReadExcel.runServiceNowReadExcel();
	return data;
	//readingDataFromExcel.readExcel("ServiceNowINCExcel");
	}
	
}