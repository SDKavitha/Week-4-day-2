package week4.day2Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StockMarket {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.chittorgarh.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));

       //Click on Stock Market
        driver.findElement(By.xpath("(//i[@class='fa fa-caret-down'])[3]")).click();
       
        
        //Click on NSE bulk Deals
        driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
        
        //Get all the security names
        
      List<WebElement> lst = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr//td[3]"));
      System.out.println("Row count:"+lst.size());
      
      List<String> securityname=new ArrayList<String>();
      
    	 System.out.println("All Security names :\n");
    	 for(int i=0;i<lst.size();i++)
    	 {
    		String text = lst.get(i).getText();
    		securityname.add(text);
    	}
    	 
    	 System.out.println(securityname);
    	 
    	 Set<String> setvalue=new HashSet<String>(securityname);
         System.out.println("Size after removing duplicates :"+setvalue.size());
         if(setvalue.size()!=lst.size())
         {
        	 System.out.println("Ensured it has duplicates in Security names");
         }
         else
         {
        	 System.out.println("It has no duplicates");
         }
         
      
     }

}
