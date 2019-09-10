import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

public class GoogleDemo {
	public static void main(String[] args) throws InterruptedException
	{
		String Browser="Link";
		if(Browser.equals("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\selenium\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
//			driver.get("https://login.yahoo.com/");
//			driver.manage().window().maximize();
//			System.out.println("Title is"+driver.getTitle());
//			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("Samsung");
//			Thread.sleep(5000);
//			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div[2]/center/input[1]")).click();
//			Thread.sleep(5000);
//			driver.close();
			driver.get("https://login.yahoo.com");
			driver.manage().window().maximize();
			driver.findElement(By.id("createacc")).click();
			Thread.sleep(5000);
			//driver.findElement(By.className("first-name pure-u-1-2")).sendKeys("Pooja");
			driver.findElement(By.xpath("//*[@class='ureg-fname ']")).sendKeys("Pooja");
			driver.findElement(By.name("lastName")).sendKeys("Gaana");
			driver.findElement(By.id("reg-submit-button")).sendKeys(Keys.ENTER);
			driver.close();
	}
		else if(Browser.equals("GC"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Documents\\selenium\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.get("https://www.rediff.com");
			driver.manage().window().maximize();
	        
			Thread.sleep(5000);
			driver.findElement(By.name("srchword")).sendKeys("Watches");
			driver.findElement(By.className("newsrchbtn")).click();
			driver.findElement(By.id("lowprice")).sendKeys("5000");
			driver.findElement(By.id("highprice")).sendKeys("10000");
			driver.findElement(By.className("pr_rangebtn")).click();
			driver.findElement(By.linkText("Become a Seller")).click();
			driver.findElement(By.partialLinkText("Forgot")).click();
			driver.findElement(By.xpath("//input[@id='login']")).sendKeys("eyetyert");
			driver.close();
			
		}
		
		else if(Browser.equals("CC")) {


			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrator\\Documents\\selenium\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
			driver.get("https://www.gmail.com");
			//driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("lucky");
			Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf' and @id='identifierId']")).sendKeys("gfjg");
		
//driver.findElement(By.cssSelector(".whsOnd.zHQkBf")).sendKeys("usahduia");
//
//	driver.findElement(By.cssSelector("#identifierId")).sendKeys("usahduia");
//Thread.sleep(5000);
		driver.close();
		}
		
		else if(Browser.equals("DC")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\selenium\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			String [] aCarMake = {"Samysung","Google Pixel","Redmi","Apple","One Plus"};
			int iLength = aCarMake.length;
			for(int i = 0;i<=iLength-1;i++){
			driver.get("https://google.co.in");
			driver.manage().window().maximize();
			
			
				 System.out.println("The value stored at position "+i+" in aMake array is ==> " + aCarMake[i]);
				 Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(aCarMake[i]);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
			Thread.sleep(5000);
			String y=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div/div[1]/input")).getAttribute("value");
			Thread.sleep(5000);
			System.out.println(driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/div[2]/ul")).getText());
			System.out.println(y);
			if(aCarMake[i].matches(y))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			}
			String x=driver.findElement(By.xpath("//*[@id=\"resultStats\"]")).getText();
			System.out.println(x);
       

}
	
	
	else if(Browser.equals("Btn"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		driver.findElement(By.xpath("//input[@value='Milk']")).click();
//		Boolean radioval=driver.findElement(By.xpath("//input[@value='Milk']")).isSelected();
//		if(radioval==true)
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
		List<WebElement> radioval= driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println(radioval.size());
		for(int j=0;j<radioval.size();j++)
			
		{
			System.out.println(radioval.get(j).getAttribute("value"));
			if(radioval.get(j).getAttribute("value").equals("Butter")) {
			radioval.get(j).click();}
		}
	}
		
	else if(Browser.equals("Link"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		List<WebElement> radioval= driver.findElements(By.tagName("a"));
		System.out.println(radioval.size());
		for(int j=0;j<radioval.size();j++)
			
		{
			
			
			
			{
				if((radioval.get(j).getText().matches("[a-zA-Z]+")))
				{
					System.out.println(radioval.get(j).getText());
				}
				
			}
	}
}}
}