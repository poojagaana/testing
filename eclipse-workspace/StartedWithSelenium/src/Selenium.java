
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
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Select select2=new Select(driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/"
				+ "tbody/tr[2]/td[3]/select")));
		select2.selectByValue("What is the name of your first school?");
		driver.findElement(By.xpath("//input[@type='password']"));
		driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input")).sendKeys("ChristKing");
		
	
		
		
	}
	}