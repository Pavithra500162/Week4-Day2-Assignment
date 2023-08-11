package week4.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class ArchitectCertification extends AdministratorCertifications{
	@Test(timeOut=200000,dependsOnMethods="admimcertification")
	public void Architect() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement sfarc=driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']"));
		a.moveToElement(sfarc).click(sfarc).perform();
		String para=driver.findElement(By.xpath("//div[contains(@class,'cert-site_text')]")).getText();
		System.out.println("Summary of Salesforce Architect: \n"+para);
		List<WebElement> arccer=driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("Listed Architect Certificates :");
		for(int i=0;i<arccer.size();i++)
		{
			String text=arccer.get(i).getText();
			System.out.println(text);
		}
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		WebElement scorll=driver.findElement(By.xpath("//div[@class='credentials-card_title']"));
		a.scrollToElement(scorll).perform();
		List<WebElement> apparccerti=driver.findElements(By.xpath("//div[contains(@class,'cert-site-bg--trailhead')]//div[@class='credentials-card_title']"));
		System.out.println("Listed application Certificates :");
		for(int i=0;i<apparccerti.size();i++)
		{
			String text=apparccerti.get(i).getText();
			System.out.println(text);
		}
	}
	@AfterMethod
	public void PostCondition()
	{
		driver.quit();
	}
}
