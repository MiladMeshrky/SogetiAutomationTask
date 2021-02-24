//package ;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestCase2 {

	@SuppressWarnings("unused")
	public static <WebElements> void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub		
		//create Object for Chrome Browser
		
		System.setProperty("webdriver.chrome.driver", "E:\\Tools\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://www.sogeti.com");
		System.out.println(driver.getTitle());		
		driver.manage().window().maximize();
		
		//Accept and close the cockies
		driver.findElement(By.className("acceptCookie")).click();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		// Select Tab Services	
		
		String Services = "//*[@id='header']/div[1]/nav/ul/li[3]/div[1]";		
		driver.findElement(By.xpath(Services)).click();
		Thread.sleep(2000);
		
        String Automation = "//*[@id='header']/div[1]/nav/ul/li[3]/div[2]/ul/li[7]/a";		
		driver.findElement(By.xpath(Automation)).click();
		
		WebElement Element = driver.findElement(By.xpath("//*[@id='99a12a58-3899-4fe1-a5c7-b9065fe635b0']/h2"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		
		driver.findElement(By.xpath("//*[@id='4ff2ed4d-4861-4914-86eb-87dfa65876d8']")).sendKeys("Sogeti");
		
		driver.findElement(By.xpath("//*[@id='11ce8b49-5298-491a-aebe-d0900d6f49a7']")).sendKeys("Sogeti");
		
		driver.findElement(By.xpath("//*[@id='056d8435-4d06-44f3-896a-d7b0bf4d37b2']")).sendKeys("Sogeti@Sogeti.com");
		driver.findElement(By.xpath("//*[@id='755aa064-7be2-432b-b8a2-805b5f4f9384']")).sendKeys("123456");
		
		WebElement staticdropdown= driver.findElement(By.xpath("//*[@id='e74d82fb-949d-40e5-8fd2-4a876319c45a']"));		
		Select dropdown= new Select(staticdropdown);
		dropdown.selectByIndex(1);
		
		driver.findElement(By.xpath("//*[@id='88459d00-b812-459a-99e4-5dc6eff2aa19']")).sendKeys("Sogeti");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='863a18ee-d748-4591-bb64-ef6eae65910e']/fieldset/label/input")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='863a18ee-d748-4591-bb64-ef6eae65910e']/fieldset/label/input")).isSelected());
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("06838eea-8980-4305-83d0-42236fb4d528")).click();		
		
		
		String actualvalue= driver.findElement(By.xpath("//span[contains(@data-epiforms-linked-name,'136030')]")).getText();
		
		System.out.println(actualvalue);
		
		String expectedvalue= "Invalid captcha value.";
		
		System.out.println("Message assertion of ,Invalid captcha value., is: "+actualvalue.equals(expectedvalue));
}
	}
