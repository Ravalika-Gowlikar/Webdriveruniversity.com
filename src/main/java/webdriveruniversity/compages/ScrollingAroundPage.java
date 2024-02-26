package webdriveruniversity.compages;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class ScrollingAroundPage {

	WebDriver driver;

	public ScrollingAroundPage(WebDriver driver) {
		this.driver = driver;
	}

	By scrolling_btn = By.xpath("//*[@id=\"scrolling-around\"]/div/div[1]/h1");
	By mouse_scroll1 = By.id("zone1");
	By mouse_scroll2 = By.id("zone2-entries");
	By mouse_scroll3 = By.id("zone3-entries");
    By mouse_scroll4 = By.id("zone4");
    
	public void scrolling() throws Exception {
		driver.findElement(scrolling_btn).click();

		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//ScrollingAroundPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);

		Actions action = new Actions(driver);
		Thread.sleep(2000);
		WebElement hover = driver.findElement(mouse_scroll1);
		action.moveToElement(hover).build().perform();
		System.out.println(driver.findElement(mouse_scroll1).getText());

		Thread.sleep(2000);
		WebElement hover1 = driver.findElement(mouse_scroll2);
		action.moveToElement(hover1).build().perform();
		System.out.println(driver.findElement(mouse_scroll2).getText());

		Thread.sleep(2000);
		WebElement hover2 = driver.findElement(mouse_scroll3);
		action.moveToElement(hover2).build().perform();
		System.out.println(driver.findElement(mouse_scroll3).getText());
		
		Thread.sleep(2000);
		WebElement hover3 = driver.findElement(mouse_scroll4);
		action.moveToElement(hover3).build().perform();
		System.out.println(driver.findElement(mouse_scroll4).getText());
		
		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}
}
