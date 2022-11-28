package week4.day2Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MenuAction {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));

		Actions builder = new Actions(driver);
		// Menu Bar
		driver.findElement(By.xpath("//span[text()='Customers']")).click();
		WebElement menu = driver.findElement(By.xpath("(//a[@role='menuitem'])[2]"));
		builder.moveToElement(menu).perform();
		WebElement order = driver.findElement(By.xpath("//span[text()='Orders']"));
		builder.moveToElement(order).perform();
		WebElement shipment = driver.findElement(By.xpath("//span[text()='Shipments']"));
		builder.moveToElement(shipment).perform();
		WebElement profile = driver.findElement(By.xpath("//span[text()='Profile']"));
		builder.moveToElement(profile).perform();

		Thread.sleep(1000);
		// Right click
		builder.contextClick().perform();

		// TabMenu
		driver.findElement(By.xpath("//span[text()='Members']")).click();

		Thread.sleep(1000);
		// Slide menu
		driver.findElement(By.xpath("(//span[text()='Customers'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='New'])[3]/..")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-w']")).click();
	

		// Panel Menu
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Customers']")).click();
		driver.findElement(By.xpath("(//a[@role='menuitem'])[20]/..")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Customers']")).click();

		// Menu Button
		driver.findElement(By.xpath("//span[text()='Options']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Delete']/.")).click();

		// scroll
		WebElement scroll = driver.findElement(By.xpath("//label[text()='2022 - All Rights Reserved']"));
		builder.scrollToElement(scroll).perform();

		// Context menu
		WebElement rigclick = driver.findElement(By.xpath("//h5[text()='Context Menu']/.."));
		builder.contextClick(rigclick).build().perform();
	}

}
