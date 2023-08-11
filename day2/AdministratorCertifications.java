package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class AdministratorCertifications {
	ChromeOptions opt;
	ChromeDriver driver;
	Shadow learn;
	Actions a;
	@BeforeMethod
	public void precondition() throws InterruptedException {
		opt=new ChromeOptions(); 
		opt.addArguments("--disable-notifications"); 
		driver= new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winhan = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winhan.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		learn = new Shadow(driver);
		Thread.sleep(5000);
		learn.findElementByXPath("//span[text()='Learning']").click();
		a=new Actions(driver);
		WebElement mo=learn.findElementByXPath("//span[text()='Learning on Trailhead']");
		Thread.sleep(3000);
		a.moveToElement(mo).perform();
		WebElement getcerti=learn.findElementByXPath("//a[text()='Salesforce Certification']");
		a.scrollToElement(getcerti).click(getcerti).perform();
	}
	@Test(priority=-1,invocationCount=1)
	public void admimcertification() throws InterruptedException{
		learn = new Shadow(driver);
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(15));
		String s1=driver.getTitle();
		wait.until(ExpectedConditions.titleContains(s1));
		if(s1.equals(s1))
		{
			System.out.println(s1);
		}
		WebElement scorll1=driver.findElement(By.xpath("//div[@class='trailMix-card-body_title']"));
		a.scrollToElement(scorll1).perform();
		List<WebElement> certificate=driver.findElements(By.xpath("//div[@class='trailMix-card-body_title']"));
		System.out.println("Listed Administrator Certificates :");
		for(int i=0;i<certificate.size();i++)
		{
			String text=certificate.get(i).getText();
			System.out.println(text);
		}
	}
	@AfterMethod(enabled=false)
	public void PostCondition1()
	{
		driver.close();
	}
}
