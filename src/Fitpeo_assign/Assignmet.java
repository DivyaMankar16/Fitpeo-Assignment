package Fitpeo_assign;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignmet {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Navigate to the FitPeo Homepage
		driver.get("https://www.fitpeo.com/");
		//Navigate to the Revenue Calculator Page
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")));
		ac.click().perform();
		Thread.sleep(3000);
		//Scroll Down to the Slider section
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,300)");
		Thread.sleep(3000);
		//Adjust the Slider
		WebElement element = driver.findElement(By.xpath("//body//div//div//div//div//div//span//span[1]"));	
		Thread.sleep(3000);
		Action action = ac.dragAndDropBy(element, 82, 0).build();
		action.perform();	    
		Thread.sleep(3000);
		//Update the Text Field
		driver.findElement(By.xpath("//input[@type='number']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys(String.valueOf(560));
		Thread.sleep(3000);
		//Validate Slider Value
		String expected = "560";
	    String actual = driver.findElement(By.xpath("//input[@type='number']")).getText();
	    if(expected.equals(actual))
	    {
	    	System.out.println("Title is matched::"+expected+"    "+actual);
		}
		else
		{
			System.out.println("Title is not matched::"+expected+"     "+actual);
		}
	    Thread.sleep(3000);
	    //Select CPT Codes
	    js.executeScript("window.scrollTo(0,780)");
	    element = driver.findElement(By.xpath("//div//div//div[1]//label[1]//span[1]//input[1]"));
	    element.click();
	    Thread.sleep(1000);
	    element = driver.findElement(By.xpath("//body/div/div/div/div[2]/label[1]/span[1]/input[1]"));
	    element.click();
	    Thread.sleep(1000);
	    element = driver.findElement(By.xpath("//div[3]//label[1]//span[1]//input[1]"));
	    element.click();
	    Thread.sleep(2000);
	    //Validate Total Recurring Reimbursement and Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month
	    String Exp = "$110700";
	    String Act = driver.findElement(By.xpath("//p[contains(text(),'Total Recurring Reimbursement for all Patients Per')]//p[1]")).getText();
	    if(Exp.equals(Act))
	    {
	    	System.out.println("Title is matched::"+Exp+"    "+Act);
		}
		else
		{
			System.out.println("Title is not matched::"+Exp+"     "+Act);
		}		
		driver.close();

	}

}
