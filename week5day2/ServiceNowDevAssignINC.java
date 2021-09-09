package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowDevAssignINC extends ServiceNowBaseClass {

		@Test
	public  void runServiceNowDevAssignINC() throws InterruptedException {
				
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(1000);
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		driver.findElement(By.xpath("//th[@name='opened_at']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[6]")).click();
		
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List <String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(1));
				
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Software group");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(windowHandlesList1.get(0));
		WebElement frameElement3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement3);		

		driver.findElement(By.xpath("(//span[@class='icon icon-locked'])[2]")).click();
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Work Notes");
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'INC0010025')]")).click();
		String text = driver.findElement(By.xpath("(//tr[@class='list_row list_odd'])[2]")).getText();
		System.out.println(text);
		System.out.println("Assign INC");

	}

}
