package cucumber;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Mobilesteps {
	static WebDriver driver;
	@Given("user login to flipkart")
	public void user_login_to_flipkart() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
	}
	@When("user search mobile {string}")
	public void user_search_mobile(String string) {
		names = string;
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebElement mobile1 = driver.findElement(By.xpath("(//span[contains(text(),'"+names+"')])[8]"));
		JavascriptExecutor js3=(JavascriptExecutor)driver;
		js3.executeScript("arguments[0].scrollIntoView(true)",mobile1);
		mobile1.click();
	 
	}
String names;
	@When("user search mobile")
	public void user_search_mobile() {
		names = "realme";
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		WebElement mobile1 = driver.findElement(By.xpath("(//span[contains(text(),'"+names+"')])[8]"));
		mobile1.getText();
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].scrollIntoView(true)",mobile1);
		mobile1.click();
		
	
	}

	@When("user choose the mobile")
	public void user_choose_the_mobile() {
		String wh = driver.getWindowHandle();
		Set<String> wh2 = driver.getWindowHandles();
		List<String> wh3=new ArrayList<String>(wh2);
		for(String x:wh3) {
			if(!wh.equals(wh3)) {
				driver.switchTo().window(x);
			}
		}
		
		
	}

	@When("user doing payment by using UPI")
	public void user_doing_payment_by_using_UPI() {
		WebElement buynow = driver.findElement(By.xpath("//input[@id='buy-now-button']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",buynow);
		buynow.click();
		driver.quit();
		//Assert.assertEquals("Buy Now", text);
	    
	}

	@Then("user receiving confirmation message")
	public void user_receiving_confirmation_message() {
	   System.out.println("last");
	}
	@When("user search mobile using oneD list")
	public void user_search_mobile_using_d_list(DataTable dataTable) {
		List<String> datas = dataTable.asList();
		
		names =datas.get(1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		WebElement mobile1 = driver.findElement(By.xpath("(//span[contains(text(),'"+names+"')])[8]"));

		mobile1.getText();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",mobile1);
		mobile1.click();
		
		
	   
	}
	@When("user search tv using oneD map")
	public void user_search_mobile_using_oneD_map(DataTable dataTable) {
		
		Map<String, String> data = dataTable.asMap(String.class, String.class);
		
		names = data.get("phone2");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		WebElement mobile1 = driver.findElement(By.xpath("(//span[contains(text(),'"+names+"')])[8]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",mobile1);
		
		mobile1.click();
	}
	
	
}