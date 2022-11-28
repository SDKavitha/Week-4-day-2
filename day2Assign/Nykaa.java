package week4.day2Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));

		Actions builder=new Actions(driver);
		//Mouse over on Brands and Search L'Oreal Paris
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brands).perform();
	    driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
	    
	    //Click L'Oreal Paris
	    driver.findElement(By.xpath("(//a[text()=\"L'Oreal Paris\"])[1]/.")).click();
	    
	    //Check the title contains L'Oreal Paris
        System.out.println("Title of the page is :"+driver.getTitle());
        
        Thread.sleep(1000);
        //Click sort By and select customer top rated
        driver.findElement(By.xpath("//span[@class='sort-name']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//label[@class='control control-radio'])[4]")).click();
        
        //Scroll
        WebElement scroll = driver.findElement(By.xpath("(//span[text()='Price'])[1]"));
        builder.scrollToElement(scroll).perform();
        
        //Click Category and click Hair->Click haircare->Shampoo
       Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Category']/.")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Hair']/..")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Hair Care']/.")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//label[@class='control control-checkbox'])[1]")).click();
        
        //Click->Concern->Color Protection
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Concern']/.")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Color Protection']/..")).click();
        
        //check whether the Filter is applied with Shampoo
        String shampoo = driver.findElement(By.xpath("(//span[text()='Shampoo'])[1]/.")).getText();
        String shampoo1="Shampoo";
        if(shampoo.equals(shampoo1))
        {
        	System.out.println("Filter is applied with Shampoo");
        }
        
        //Click on L'Oreal Paris Colour Protect Shampoo
        driver.findElement(By.xpath("//img[@alt=\"L'Oreal Paris Colour Protect Shampoo\"]/.")).click();
        
        // GO to the new window and select size as 175ml
        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
 		System.out.println(driver.getTitle());
        Set<String> windowHandles = driver.getWindowHandles();
      //convert set into list
      		List<String> lstname=new ArrayList<String>(windowHandles);
      		driver.switchTo().window(lstname.get(1));
     		System.out.println(driver.getWindowHandle());
     		System.out.println(driver.getTitle());
     	WebElement size = driver.findElement(By.xpath("//select[@title='SIZE']/."));
     	Select sc=new Select(size);
		 sc.selectByIndex(1);
		 
		 //Print the MRP of the product
		 String mrp = driver.findElement(By.xpath("(//span[contains(text(),'189')])[1]/.")).getText();
		 System.out.println("Mrp of product is : "+mrp);
		 
		 //Click on ADD to BAG
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]/.")).click();
		 
		 //Go to Shopping Bag 
		 driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		 
		 Thread.sleep(1000);
			//handle frame
		driver.switchTo().frame(0);
		 //Print the Grand Total amount
		 String Gt = driver.findElement(By.xpath("//div[@class='css-15py5ir e25lf6d2']")).getText();
		 String replaceAll1 = Gt.replaceAll("\\D", "");
		 int Grandtotal=Integer.parseInt(replaceAll1);
		 System.out.println("Grand total amount :"+Grandtotal);
		 
		 //Click Proceed
		driver.findElement(By.xpath("(//button[@class='css-guysem e8tshxd0'])[2]")).click();
		 
		 //Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		driver.findElement(By.xpath("(//img[@alt='Image'])[7]/.")).click();
		
		//Check if this grand total is the same in step 14
		 String tot = driver.findElement(By.xpath("//p[@class='css-5t7v9l eka6zu20']")).getText();
		 String replaceAll2 = tot.replaceAll("\\D", "");
		 int Grandtotal1=Integer.parseInt(replaceAll2);
		 System.out.println("Grand total amount :"+Grandtotal1);
		 
		 if(Gt.equals(tot))
		 {
			 System.out.println("Grand Total is same");
		 }
		 else
		 {
			 System.out.println("Grand Total is not same");

		 }
		 
		 //Close all windows
		 driver.close();
	}

}
