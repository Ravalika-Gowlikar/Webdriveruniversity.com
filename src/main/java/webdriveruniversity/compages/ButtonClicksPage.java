package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ButtonClicksPage {

	WebDriver driver;

	public ButtonClicksPage(WebDriver driver) {
		this.driver = driver;
	}

	By btn_click = By.xpath("//*[@id=\"button-clicks\"]/div/div[1]/h1");
	By web_ele = By.xpath("//*[@id=\"button1\"]");
	By pop_up1 = By.xpath("//*[@id=\"myModalClick\"]/div/div/div[3]/button");
	By java_click = By.id("button2");
	By pop_up2 = By.xpath("//*[@id=\"myModalJSClick\"]/div/div/div[3]/button");
	By action_click = By.id("button3");
	By pop_up3 = By.xpath("//*[@id=\"myModalMoveClick\"]/div/div/div[3]/button");

	public void click_btn() throws InterruptedException, Exception {
		
//		Thread.sleep(2000);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,600)");

		driver.findElement(btn_click).click();
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}

		Thread.sleep(2000);
		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//ButtonClickPage.png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f2 = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f2, src);
		driver.findElement(web_ele).click();// click me
		Thread.sleep(2000);
		// System.out.println(driver.switchTo().alert().getText());
		driver.findElement(pop_up1).click();

		driver.findElement(java_click).click();
		Thread.sleep(2000);
		driver.findElement(pop_up2).click();

		driver.findElement(action_click).click();
		Thread.sleep(2000);
		driver.findElement(pop_up3).click();
		driver.close();
		
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}
	
	
}
	
