package webdriveruniversity.compages;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class PopupAlertsPage {

	WebDriver driver;

	public PopupAlertsPage(WebDriver driver) {
		this.driver = driver;
	}

	By alerts_btn = By.xpath("//*[@id=\"popup-alerts\"]/div/div[1]/h1");
	By alert_btn1 = By.id("button1");
	By alert_btn2 = By.id("button2");
	By btn_click  = By.xpath("//*[text()='Close']");
	By ajax_loader= By.id("button3");
	By click_me = By.xpath("//*[text()=\"CLICK ME!\"]");
	By confirmbox = By.id("button4");
	
	public void popupalert() throws Exception {
		driver.findElement(alerts_btn).click();
		
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//Popup&AlertsPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);
		
		driver.findElement(alert_btn1).click();
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage); // Print Alert Message
		Thread.sleep(5000);
		alert.accept();
		
		driver.findElement(alert_btn2).click();
		driver.findElement(btn_click).click();
		driver.findElement(confirmbox).click();
		alert.accept();
		Thread.sleep(2000);
		System.out.println(driver.findElement(confirmbox).getText());
		driver.findElement(ajax_loader).click();
		Thread.sleep(3000);
		
		driver.findElement(click_me).click();
		Thread.sleep(2000);
		driver.findElement(btn_click).click();

		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
		
	}
}
