package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class TextAffectsPage {

	WebDriver driver;

	public TextAffectsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By text = By.xpath("//div[@class='section-title']/h1[text()='ACCORDION & TEXT AFFECTS (APPEAR & DISAPPEAR)']");
	By manul = By.id("manual-testing-accordion");
	By bdd = By.id("cucumber-accordion");
	By Auto_test = By.id("automation-accordion");
	By click = By.id("click-accordion");
	
	public void textaffect() throws InterruptedException, IOException {
		driver.findElement(text).click();
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		
		Thread.sleep(2000);
		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//TextAffectPage.png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File f2 = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f2, src);
		Actions act = new Actions(driver);
		WebElement man = driver.findElement(manul);
		act.doubleClick().perform();
		//act.clickAndHold();
//		act.click();
//		Thread.sleep(2000);
//		act.click();
		Thread.sleep(2000);
		WebElement bd = driver.findElement(bdd);
		act.doubleClick().perform();
		
		Thread.sleep(2000);
		WebElement test = driver.findElement(Auto_test);
		act.doubleClick().perform();
		
		Thread.sleep(2000);
		WebElement clk = driver.findElement(click);
		act.doubleClick().perform();
		
		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
		
	}
}
