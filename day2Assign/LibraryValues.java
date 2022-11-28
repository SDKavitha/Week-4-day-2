package week4.day2Assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryValues {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
		
		List<WebElement> lst = driver.findElements(By.xpath("(//table)[1]//tr[2]/td"));
		System.out.println("Num of columns :"+lst.size());
		
				
		String str="Absolute Usage";
		String Str1 = driver.findElement(By.xpath("//table//tr[2]//td[1]")).getText();
		
		//String str2="Market Share";
		//String Str3 = driver.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
       
		List<String> Abs=new ArrayList<String>();
		
		if(str.equals(Str1))
		{
			//System.out.println("same");
			for(int i=1;i<lst.size();i++)
			{
				String values = lst.get(i).getText();
				Abs.add(values);
							
			}
			System.out.println("Absolute Usage are :"+Abs);
		}
		
        
	}

}
