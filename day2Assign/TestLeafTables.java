package week4.day2Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeafTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));

				 
		 //Get column count
		 List<WebElement> col = driver.findElements(By.xpath("//table//th"));
		 System.out.println(col.size());
		 
		//Get row count
			List<WebElement> rw = driver.findElements(By.xpath("//table//tr"));
			 System.out.println(rw.size());
	 
		 //Get Progress value of learn to interact with element
		 String text = driver.findElement(By.xpath("//table//tr[3]//td[2]")).getText();
		 System.out.println("Progress value of learn to interact element:"+text);
		 
		 //check the vital task for least completed progress
		 
		 List<WebElement> progress = driver.findElements(By.xpath("//table//td[2]"));
		 
		 List<Integer> lst=new ArrayList<Integer>();
		 
		 for(int i=0;i<progress.size();i++)
		 {
			 String provalue = progress.get(i).getText();
			 String replaced = provalue.replaceAll("[^0-9]", "");
			 int intvalue = Integer.parseInt(replaced);
			 lst.add(intvalue);
		 }
		 
		 Collections.sort(lst);
		 Integer i = lst.get(0);
		 
		 driver.findElement(By.xpath("//font[contains(text(),'"+i+"%')]/following::input")).click();
		 
		 
	}

}
