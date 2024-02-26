package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class AjaxLoaderPage {
	WebDriver driver;
	// public String parentHandle = driver.getWindowHandle();

	public AjaxLoaderPage(WebDriver driver) {
		this.driver = driver;
	}

	By load_btn = By.xpath("//div[@class='section-title']/h1[text()='AJAX LOADER']");
	By click_me = By.xpath("//*[text()='CLICK ME!']");
	By close_btn = By.xpath("//*[text()='Close']");

	public void loaderpage() throws IOException, InterruptedException {
		driver.findElement(load_btn).click();

		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		
		Thread.sleep(2000);
		driver.findElement(click_me).click();
		Thread.sleep(2000);
		driver.findElement(close_btn).click();

		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}

//		Thread.sleep(5000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//AjaxLoaderPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);	
	}
