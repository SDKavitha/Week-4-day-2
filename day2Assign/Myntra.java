package week4.day2Assign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));

		Actions builder=new Actions(driver);
		//Mouse hover on MeN 
        WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		builder.moveToElement(men).perform();
		
		//Click Jackets 
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		//Find the total count of item 
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total count of item :"+count);
		
		//Validate the sum of categories count matches
		String sum = driver.findElement(By.xpath("//span[@class='categories-num']")).getText();
		System.out.println("Sum of categories count matches :"+sum);
		if(count.equals(sum))
		{
			System.out.println("Count matches");
		}
		else
		{
			System.out.println("Count not matches");
		}
		
		//Check jackets
		driver.findElement(By.xpath("//label[@class='common-customCheckbox vertical-filters-label']")).click();
		
		//Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		//Type Duke and click check box
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		
		//Close the pop-up x
      driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']/.")).click();
        
        //Confirm all the Coats are of brand Duke
        List<WebElement> coats = driver.findElements(By.xpath("//h3[text()='Duke']"));
        System.out.println("Size of coats :"+coats.size());
         List<String>lst=new ArrayList<String>();
         int c=0;
        for(int i=0;i<coats.size();i++)
        {
        	String coatval = coats.get(i).getText();
        	lst.add(coatval);
        	 if(!(lst.get(i)).equals("Duke"))
         	{
         		c=c+1;
         	}
        }
       // System.out.println(c);
        if(c==0)
        {
        	System.out.println("All coats are Duke");
        }
        
        //Sort by Better Discount
        WebElement disc = driver.findElement(By.xpath("//div[@class='sort-sortBy']/."));
        builder.moveToElement(disc).perform();
        driver.findElement(By.xpath("//label[text()=\"Better Discount\"]")).click();
        
        //Find the price of first displayed item
       // Click on the first product
        Thread.sleep(2000);
        String price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
       System.out.println("Price of first displayed item :"+price);
       Thread.sleep(1000);
       driver.findElement(By.xpath("(//img[@class='img-responsive'])[1]")).click();
       String windowHandle = driver.getWindowHandle();
       System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		
       Set<String> windowHandles = driver.getWindowHandles();
     //convert set into list
     		List<String> lstname=new ArrayList<String>(windowHandles);
     		driver.switchTo().window(lstname.get(1));
    		System.out.println(driver.getWindowHandle());
    		System.out.println(driver.getTitle());
        
       //Take a screen shot
       Thread.sleep(2000);
       File source = driver.getScreenshotAs(OutputType.FILE);
       File dest=new File("./Myntra/Duke.png");
       FileUtils.copyFile(source, dest);
       
       //Click on WishList Now
       driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
       
       // Close Browser
       driver.close();
       driver.quit();
		
	}

}
