import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class htmlunitdriver{
	public static void main(String a[])
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.toolsqa.com/automation-practice-table");
//		String data1=driver.findElement(By.xpath("//*[@id=\"content\"]/table")).getText();
//		String data2=driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")).getText();
//		String data3=driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[1]")).getText();
		
//		System.out.println(data1);
//		
		driver.get("https://www.amazon.in/");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[2]"))).build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a/span")).click();
	

		
	}
}