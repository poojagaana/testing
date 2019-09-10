
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium{
	public static void main(String[] args) throws InterruptedException
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		driver.manage().window().maximize();
		Select select1=new Select(driver.findElement(By.id("country")));
		select1.selectByIndex(5);
		Thread.sleep(4000);
		select1.selectByValue("99");
		Thread.sleep(4000);
		select1.selectByVisibleText("United States");
	
		System.out.println(select1.isMultiple());
	
		
		
	}
	}