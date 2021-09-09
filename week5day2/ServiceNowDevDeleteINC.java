package week5.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowDevDeleteINC extends  ServiceNowBaseClass  {
	
	@Test
	public void runServiceNowDevDeleteINC( ) throws InterruptedException {
				
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectElement);
		drpdwn.selectByValue("number");
		WebElement searchINC1 = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC1.sendKeys("INC001");
		Actions builder = new Actions(driver);
		builder.moveToElement(searchINC1).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		System.out.println("Delete INC");

	}

}
