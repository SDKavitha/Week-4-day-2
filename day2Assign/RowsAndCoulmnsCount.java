package week4.day2Assign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RowsAndCoulmnsCount {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://html.com/tags/table/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
	
	//Get the count of number of rows
      List<WebElement> lst = driver.findElements(By.xpath("(//table)[1]//th"));
      System.out.println("Num of columns of table 1 :"+lst.size());
      
     // List<WebElement> lst1 = driver.findElements(By.xpath("(//table)[2]//th"));
     // System.out.println("Num of columns of table 2 :"+lst1.size());
      
      //Get the count of number of columns
      List<WebElement> lst2 = driver.findElements(By.xpath("(//table)[1]//tr"));
      System.out.println("Num of rows of table 1 :"+lst2.size());
      
      //List<WebElement> lst3 = driver.findElements(By.xpath("(//table)[2]//tr"));
      //System.out.println("Num of rows of table 2 :"+lst3.size());


	}

}
