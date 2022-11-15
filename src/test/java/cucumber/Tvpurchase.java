package cucumber;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
		
public class Tvpurchase {
	
	String names;
	@When("user search tv")
	public void user_search_tv() {
		names = "Philips";
		Mobilesteps.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		WebElement mobile1 = Mobilesteps.driver.findElement(By.xpath("(//span[contains(text(),'"+names+"')])[8]"));
		mobile1.getText();
		JavascriptExecutor js2=(JavascriptExecutor)Mobilesteps.driver;
		js2.executeScript("arguments[0].scrollIntoView(true)",mobile1);
		mobile1.click();
		
	    
	}
	@When("user search tv using oneD list")
	public void user_search_tv_using_oneD_list(DataTable dataTable) {
		List<String> datas = dataTable.asList();
		
		names =datas.get(1);
		Mobilesteps.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		WebElement mobile1 = Mobilesteps.driver.findElement(By.xpath("(//span[contains(text(),'"+names+"')])[8]"));

		mobile1.getText();
		JavascriptExecutor js=(JavascriptExecutor)Mobilesteps.driver;
		js.executeScript("arguments[0].scrollIntoView(true)",mobile1);
		mobile1.click();
	    
	}
	@When("user search tv {string}")
	public void user_search_tv(String string) {
		names = string;
		Mobilesteps.driver.findElement(By.xpath("//input[@type='text']")).sendKeys(names,Keys.ENTER);
		Mobilesteps.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebElement mobile1 = Mobilesteps.driver.findElement(By.xpath("(//span[contains(text(),'"+names+"')])[8]"));
		JavascriptExecutor js3=(JavascriptExecutor)Mobilesteps.driver;
		js3.executeScript("arguments[0].scrollIntoView(true)",mobile1);
		mobile1.click();
		
	}
	@When("user choose the tv")
	public void user_choose_the_tv() {
		String wh = Mobilesteps.driver.getWindowHandle();
		Set<String> wh2 = Mobilesteps.driver.getWindowHandles();
		List<String> wh3=new ArrayList<String>(wh2);
		for(String x:wh3) {
			if(!wh.equals(wh3)) {
				Mobilesteps.driver.switchTo().window(x);
			}
		}
		
	  
	}

}
