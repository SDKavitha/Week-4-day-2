package week4.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAction {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));

		Actions builder=new Actions(driver);
		//Draggable
		WebElement draggable = driver.findElement(By.xpath("//div[@id='form:conpnl_content']"));
		System.out.println("Before :"+draggable.getLocation());
		builder.dragAndDropBy(draggable,100, 150).perform();
		System.out.println("After :"+draggable.getLocation());
		
		//Droppable
		WebElement source = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement destin = driver.findElement(By.xpath("//div[@id='form:drop_header']"));
		builder.dragAndDrop(source, destin).perform();

	
		//Draggable Columns
		WebElement Category = driver.findElement(By.xpath("(//table)[5]//th[2]"));
		WebElement Quantity = driver.findElement(By.xpath("(//table)[5]//th[3]"));
		builder.dragAndDrop(Quantity, Category).perform();
		Thread.sleep(1000);
        String text = driver.findElement(By.xpath("//span[text()='Columns reordered']")).getText();
		String text2="Columns reordered";
		if(text.equals(text2))
		{
			System.out.println("Columns reordered successfully");
			
		}
		
		//Draggable Rows
		/* WebElement rw1 = driver.findElement(By.xpath("(//table)[6]//tr[1]"));
		WebElement rw2 = driver.findElement(By.xpath("(//table)[6]//tr[2]"));
		builder.dragAndDrop(rw2, rw1).perform();
		String text3 = driver.findElement(By.xpath("//span[text()='Row moved']")).getText();	
		String text4="Row moved";
		if(text3.equals(text4))
		{
			System.out.println("rows reordered successfully");
			
		}*/
		

		//Scroll down
		WebElement scroll = driver.findElement(By.xpath("//label[text()='2022 - All Rights Reserved']"));
		builder.scrollToElement(scroll).perform();
		
		//Resize Image
		WebElement resize = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable')]"));
		 org.openqa.selenium.Point location = resize.getLocation();
         int x2 = location.getX();
         int y2 = location.getY();
         System.out.println(x2+"   "+y2);
		builder.clickAndHold(resize).moveByOffset(50, 10).release().build().perform();
		Thread.sleep(1000);
		Point location2 = resize.getLocation();
		 int x3 = location2.getX();
         int y3 = location2.getY();
         System.out.println(x3+"   "+y3);
		
		//Progress bar
		WebElement prog = driver.findElement(By.xpath("//span[text()='Start']"));
		prog.click();
		String text5 = driver.findElement(By.xpath("//span[text()='Progress Completed']")).getText();
		String text6="Progress Completed";
		if(text5.equals(text6))
		{
			System.out.println("Progress Completed");
		}
		else
		{
			System.out.println("Progress not completed");
		}
		
		//Thread.sleep(1000);
		
		//Range Slider
		WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		builder.dragAndDropBy(slider, 25, 60).perform();
		System.out.println("Sliding successfully");
		

	}

}
