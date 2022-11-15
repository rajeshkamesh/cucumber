package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fbsignup {
	
	public static void main(String[] args) {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='First name']")).sendKeys("Rajesh");
		driver.findElement(By.xpath("//input[@namer='lastname']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@namer='reg_email__']")).sendKeys("rajeshhkamesh@gmail.com");
		driver.findElement(By.xpath("//input[@namer='reg_passwd__']")).sendKeys("rajeshkumar");
		WebElement day = driver.findElement(By.id("day"));
		Select s = new Select(day);
		s.selectByVisibleText("02");
		
		WebElement month = driver.findElement(By.id("month"));
		Select s2 = new Select(month);
		s2.selectByVisibleText("Nov");
		
		
		WebElement year = driver.findElement(By.id("year"));
		Select s3 = new Select(year);
		s3.selectByVisibleText("1991");
		
		
	}
	

}
