package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ToDoListPage {
	
	WebDriver driver;
	
	public ToDoListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By todo_list = By.xpath("//*[@id=\"to-do-list\"]/div/div[1]/h1");
	By add_new = By.xpath("//*[@id=\"container\"]/input");
	By icon = By.xpath("//*[@id=\"plus-icon\"]");
	
	public void list() throws InterruptedException, Exception {
		
//	JavascriptExecutor jse = (JavascriptExecutor) driver;
//	jse.executeScript("window.scrollBy(0,800)");
//	Thread.sleep(2000);
	
	driver.findElement(todo_list).click();
	
	String parentHandle = driver.getWindowHandle();
	Set<String> handles = driver.getWindowHandles();
	for (String handle : handles) {
		System.out.println(handle);
		if(!handle.equals(parentHandle)) {
			driver.switchTo().window(handle);
		}
	}
	
	Thread.sleep(2000);
	File src = new File(System.getProperty("user.dir")+"//POMScreenshots//todolistPage.png");
	TakesScreenshot ts = (TakesScreenshot) driver;
	File f2 = ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(f2, src);
	WebElement tdl = driver.findElement(add_new);
	Thread.sleep(2000);
	tdl.sendKeys("Practice Selenium");
	tdl.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(icon).click();
	System.out.println("Sucessfully Operation got performed");
	driver.close();
	driver.switchTo().window(parentHandle);
	Thread.sleep(2000);
}

}
