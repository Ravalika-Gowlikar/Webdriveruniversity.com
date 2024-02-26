package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class POMPage {

     WebDriver driver;

	public POMPage(WebDriver driver) {
		this.driver = driver;
	}

	By pom_btn = By.xpath("//div[@class='section-title']/h1[text()='PAGE OBJECT MODEL']");
	By home = By.xpath("//a[text()='Home']");
	By product = By.xpath("//a[text()='Our Products']");
	By contact_Us = By.xpath("//a[text()='Contact Us']");
	By fname = By.name("first_name");
	By lname = By.name("last_name");
	By email = By.name("email");
	By commt = By.name("message");
	By submit = By.xpath("//input[@class='contact_button'][2]");

	public void pom() throws IOException, InterruptedException {
		driver.findElement(pom_btn).click();

		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	

		Thread.sleep(3000);
		driver.findElement(home).click();
		driver.findElement(product).click();
		driver.findElement(contact_Us).click();
	
		driver.findElement(fname).sendKeys("John");
		driver.findElement(lname).sendKeys("Lee");
		driver.findElement(email).sendKeys("john@gmail.com");
		driver.findElement(commt).sendKeys("Hello");
		driver.findElement(submit).click();
//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//ThanksMessagePage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);

		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}
	}
	


