package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By login_btn = By.xpath("//*[@id=\"login-portal\"]/div/div[1]/h1");
	By unmae = By.xpath("//*[@id=\"text\"]");
	By pswd = By.xpath("//*[@id=\"password\"]");
	By sign_btn = By.id("login-button");
	
	private String str = "ravalika@123";
	
	public void sigin() throws InterruptedException, IOException {
		

//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//HomePage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);
		
		//String parentHandle = driver.getWindowHandle();
//		System.out.println("parent window : "+parentHandle);
		
		driver.findElement(login_btn).click();
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				WebElement username = driver.findElement(unmae);
				username.click();
				username.sendKeys("ravalika");
				
				WebElement pass = driver.findElement(pswd);
				pass.click();
				pass.sendKeys(decodeString("cmF2YWxpa2FAMTIz"));
				
				driver.findElement(sign_btn).click();		
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				Thread.sleep(5000);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());

	}
	
	static String decodeString(String password) {
		byte[] decodedString = Base64.decodeBase64(password);
		return(new String(decodedString));
	}
}
