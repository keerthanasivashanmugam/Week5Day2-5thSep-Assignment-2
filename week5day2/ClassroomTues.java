package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassroomTues {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://downtowndallas.com/experience/stay/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//img[@src='/wp-content/themes/downtowndallas/assets/img/popup.jpg']")).click();
		driver.findElement(By.xpath("//a[text()='Experience']")).click();
		driver.findElement(By.xpath("//button[text()='Stay']")).click();
		
		List<WebElement> elementList = driver.findElements(By.xpath("//a[@class='place-square__btn']"));
		List<String> elementList1 = new ArrayList<String>(); 
		System.out.println(elementList.size());
		
		for(int i=1; i<elementList.size();i++)
		{
			driver.findElement(By.xpath("(//a[@class='place-square__btn'])["+i+"]")).click();
			Thread.sleep(1000);
			String text1 = driver.findElement(By.xpath("//div[@class='place-info']")).getText();
			System.out.println(text1);
			elementList1.add(text1);
			driver.navigate().back();
		}
		
		
	}

}
