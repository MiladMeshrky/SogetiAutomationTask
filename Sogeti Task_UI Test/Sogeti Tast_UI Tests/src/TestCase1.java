//package ;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCase1 {

	public static <WebElements> void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub		
		//create Object for Chrome Browser
		
		System.setProperty("webdriver.chrome.driver", "E:\\Tools\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.sogeti.com");
		System.out.println(driver.getTitle());		
		driver.manage().window().maximize();
		
		//Accept and close the cockies
		driver.findElement(By.className("acceptCookie")).click();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		// Select Tab Services	
		
		String Services = "//*[@id='header']/div[1]/nav/ul/li[3]/div[1]";
		
		driver.findElement(By.xpath(Services)).click();
		Boolean Display1 = driver.findElement(By.xpath(Services)).isDisplayed();
		Boolean Selection1 = driver.findElement(By.xpath(Services)).isSelected();
		if (Selection1= true);
		{
			
		System.out.println("Element is displayed= "+ Display1+" and is selected= "+ Selection1);
		
		}
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		// Select subelement Automation
		String Automation = "//*[@id='header']/div[1]/nav/ul/li[3]/div[2]/ul/li[7]/a";
		
		driver.findElement(By.xpath(Automation));
		Boolean Display2 = driver.findElement(By.xpath(Automation)).isDisplayed();
		Boolean Selection2 = driver.findElement(By.xpath(Automation)).isSelected();
		if (Selection2= true);
		{
			
			System.out.println("Eeement is displayed= "+ Display2+" and is selected= "+ Selection2);
		
		}
		
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='header']/div[1]/nav/ul/li[3]/div[2]/ul/li[7]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		driver.findElement(By.id("pageTop")).click();
		System.out.println(driver.getTitle());
				
		
		
		}
	}


