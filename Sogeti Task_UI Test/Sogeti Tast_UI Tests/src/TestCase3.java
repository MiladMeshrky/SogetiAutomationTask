import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
//import java.util.Set;
//import java.util.Iterator;
import java.util.concurrent.TimeUnit;
//import org.apache.http.NameValuePair;

import javax.net.ssl.HttpsURLConnection;

//import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;



public class TestCase3 {

	@SuppressWarnings("unused")
	public static <WebElements> void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub		
		//create Object for Chrome Browser
		
		System.setProperty("webdriver.chrome.driver", "E:\\Tools\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		/*System.setProperty("webdriver.gecko.driver", "E:\\Tools\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();*/
		
		driver.get("https://www.sogeti.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		//Accept and close the cockies
		driver.findElement(By.className("acceptCookie")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		
		// Select Tab woldwide  
		 		
	
		
		driver.findElement(By.xpath("//span[contains(.,'Worldwide')]")).click();
		
		System.out.println("These are the Country specific Sogeti links.");
		
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	    Thread.sleep(5000);
	    
	    // getting drop downdpwn elements from 1 to 6 in a list and checking if there are broken links and print out the result
	    
	    		    
	        Boolean Display1 = driver.findElement(By.xpath("//*[@id='header']/div[3]/ul/li[position() >= 1 and 12 >= position()]/a")).isDisplayed();
	        
	        System.out.println("Elements are displayed= "+ Display1);
	    
	        List<WebElement> linksset1 = (driver.findElements (By.xpath("//*[@id='header']/div[3]/ul/li[position() >= 1 and 6 >= position()]/a")));
	         	         	         
	    	   for (WebElement link : linksset1)
	   	    {
	    		    
	    		   
	   	    	String url= link.getAttribute("href");
	   	    	
	   	    	HttpsURLConnection conn= (HttpsURLConnection)new URL(url).openConnection();
	   	    	conn.connect();
	   	    	int respCode= conn.getResponseCode();
	   	    	//System.out.println(respCode);
	   	    	if (respCode>400)	    	
	   	    	{
	   	    		
	   	    		System.out.println("The link with Text: "+ link.getText()+" is broken with Code number: "+ respCode +" Test is fail" );
	   	    		
	   	    	}
	   	    	
	   	    	else {
	   	    		System.out.println("The link with Text: "+ link.getText()+" is healthy with Code number: "+ respCode +" Test is pass" );
	   	    		
	   	    	}
	   	    }
	    	 
	    	// getting drop downdpwn elements from 8 to 12 in a list and checking if there are broken links and print out the result
	    	   
		    	List<WebElement> linksset2 = (driver.findElements (By.xpath("//*[@id='header']/div[3]/ul/li[position() >= 8 and 12 >= position()]/a")));
		    	   for (WebElement link : linksset2)
		   	    {
		   	    	String url= link.getAttribute("href");
		   	    	
		   	    	HttpsURLConnection conn= (HttpsURLConnection)new URL(url).openConnection();
		   	    	conn.connect();
		   	    	int respCode= conn.getResponseCode();
		   	    	//System.out.println(respCode);
		   	    	if (respCode>400)	    	
		   	    	{
		   	    		
		   	    		System.out.println("The link with Text: "+ link.getText()+" is broken with Code number: "+ respCode +" Test is fail" );
		   	    		
		   	    	}
		   	    	
		   	    	else {
		   	    		System.out.println("The link with Text: "+ link.getText()+" is healthy with Code number: "+ respCode +" Test is pass" );
		   	    		
		   	    	}
		   	    }	

		
		
		
	}
}

