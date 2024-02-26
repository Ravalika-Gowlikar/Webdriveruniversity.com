package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class IFramePage {
	
	WebDriver driver;

	public IFramePage(WebDriver driver) {
		this.driver = driver;
	}

	By alerts_btn = By.xpath("//*[@id=\"iframe\"]/div/div[1]/h1");
	
	public void iframepage() throws Exception {
		driver.findElement(alerts_btn).click();
		
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		
		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}

}
