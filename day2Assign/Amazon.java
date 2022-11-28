package week4.day2Assign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
		
		Actions builder=new Actions(driver);
		
		//search as one plus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//Get the price of the first product
		Thread.sleep(1000);
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of the first product :"+price);
		
		price=price.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(price);
		
		//Print the number of customer ratings for the first displayed product
		/*Thread.sleep(1000);
        String numofrate = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
        int num=Integer.parseInt(numofrate);
		System.out.println("Number of customer ratings for the first displayed product :"+num);
		
		//Mouse Hover on the stars
		Thread.sleep(1000);
		WebElement mouse = driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small a-star-sma')]/.)[1]"));
		builder.moveToElement(mouse).perform();
        
		//Get the percentage of ratings for the 5 star.
			Thread.sleep(1000);
			String per = driver.findElement(By.xpath("	(//span[@class='a-size-base']/a)[2]")).getText();
			System.out.println("Percentage of ratings for the 5 star :"+per);*/
        
		//Click the first text link of the first image
			driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
			
			Set<String> windowHandles = driver.getWindowHandles();
			//convert set into list
			List<String> lstname=new ArrayList<String>(windowHandles);
			//move the control into second open window
			driver.switchTo().window(lstname.get(1));
			
		//Take a screen shot of the product displayed
			Thread.sleep(1000);
		       File source1 = driver.getScreenshotAs(OutputType.FILE);
		       File dest1=new File("./Amazon/Product.png");
		       FileUtils.copyFile(source1, dest1);
		       
		  //Click 'Add to Cart' button
		      Thread.sleep(1000);
		       driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click();
		      
		   //Get the cart subtotal and verify if it is correct.
		       Thread.sleep(2000);
		       String grandTotal1 = driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price')] /span[@id='attach-accessory-cart-subtotal'][1]")).getText();
		    		   //.replaceAll("[^0-9]", "").substring(0, 5);
		       System.out.println("grandtotal:"+grandTotal1);
	    		if(price.contains(grandTotal1)) {
	    			System.out.println(grandTotal1);
	    		}
	    		else {
	    			System.out.println(" Price is Not Same");
	    		}
		      		

	}

}
