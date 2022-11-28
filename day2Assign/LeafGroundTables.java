package week4.day2Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/table.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
		
		//count of tagname
	    List<WebElement> tag = driver.findElements(By.tagName("th"));
	    System.out.println(tag.size());
		
		//Get the column count
	    List<WebElement> col = driver.findElements(By.xpath("(//table[@role='grid'])[1]//th"));
		 System.out.println(col.size());
		 for(int i=0;i<col.size();i++)
		 {
			 System.out.println(col.get(i).getText());
		 }
		 
		 //get the entire row count
		 List<WebElement> rw = driver.findElements(By.xpath("(//table[@role='grid'])[2]//tr"));
		 System.out.println(rw.size());
		 
		 //Print particular data
		 String text = driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr[2]//td[2]")).getText();
		 System.out.println(text);
		 		 
		 //Get the particular Column data (Country names)
		 List<WebElement> rw1 = driver.findElements(By.xpath("(//table[@role='grid'])[2]//tr//td[2]"));
			System.out.println(rw1.size());

		 List<String> countrydata=new ArrayList<String>();
		 for(int i=0;i<rw1.size();i++)
		 {
			String text2 = rw1.get(i).getText(); 
			countrydata.add(text2);
		 }
		 System.out.println("Country names are :");
		 System.out.println(countrydata);
		
	}

}
