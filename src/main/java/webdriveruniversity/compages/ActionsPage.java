package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class ActionsPage {

	WebDriver driver;
	

	public ActionsPage(WebDriver driver) {
		this.driver = driver;
	}

	By action_btn = By.xpath("(//div[@class='section-title'])/h1[text()='ACTIONS']");
	By element_1 = By.xpath("//b[text()='DRAG ME TO MY TARGET!']"); // b[text()='DRAG ME TO MY
																	// TARGET!'],//*[@id=\"draggable\"]/p/b"
	By element_2 = By.xpath("//b[text()='DROP HERE!']"); // b[text()='DROP HERE!'], //*[@id=\"droppable\"]/p/b")
	By click_me = By.xpath("//*[@id=\"double-click\"]/h2");
	By textTo = By.xpath("//b[text()='Dropped!']");
	By mouse_hover1 = By.xpath("//button[@class='dropbtn'][text()='Hover Over Me First!']");
	By link1 = By.xpath("(//a[@class='list-alert'][text()='Link 1'])[1]");
	By mouse_hover2 = By.xpath("//button[@class='dropbtn'][text()='Hover Over Me Second!']");
	By link2 = By.xpath("(//a[@class='list-alert'][text()='Link 1'])[2]");
	By mouse_hover3 = By.xpath("//button[@class='dropbtn'][text()='Hover Over Me Third!']");
	By link3 = By.xpath("(//a[@class='list-alert'][text()='Link 1'])[3]");
	By link4 = By.xpath("(//a[@class='list-alert'][text()='Link 1'])[4]");
	By release_btn = By.xpath("//div[@id='click-box']");

	public void action() throws InterruptedException, Exception {
		driver.findElement(action_btn).click();
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//ActionsPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);
		Actions action = new Actions(driver);
		WebElement from = driver.findElement(element_1);
		WebElement to = driver.findElement(element_2);
		action.dragAndDrop(from, to).build().perform();
		Thread.sleep(2000);
		System.out.println("Dopped" + textTo);

		// doubleclick
		Thread.sleep(2000);
		WebElement double_click = driver.findElement(click_me);
		action.doubleClick(double_click).perform();

		// mousehover1
		Thread.sleep(2000);
		WebElement hover = driver.findElement(mouse_hover1);
		action.moveToElement(hover).build().perform();
		Thread.sleep(2000);
		driver.findElement(link1).click();
		Alert alert = driver.switchTo().alert(); // switch to alert
		String alertMessage = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage); // Print Alert Message
		Thread.sleep(5000);
		alert.accept();

		// mousehover2
		Thread.sleep(5000);
		WebElement hover1 = driver.findElement(mouse_hover2);
		action.moveToElement(hover1).build().perform();
		Thread.sleep(2000);
		driver.findElement(link2).click();
		Alert alert1 = driver.switchTo().alert(); // switch to alert
		String alertMessage1 = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage1); // Print Alert Message
		Thread.sleep(5000);
		alert1.accept();
		// mousehover3
		Thread.sleep(5000);
		WebElement hover2 = driver.findElement(mouse_hover3);
		action.moveToElement(hover2).build().perform();
		Thread.sleep(2000);
		driver.findElement(link3).click();
		Alert alert2 = driver.switchTo().alert(); // switch to alert
		String alertMessage2 = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage2); // Print Alert Message
		Thread.sleep(5000);
		alert1.accept();

		Thread.sleep(5000);
		WebElement hover3 = driver.findElement(mouse_hover3);
		action.moveToElement(hover3).build().perform();
		Thread.sleep(2000);
		driver.findElement(link4).click();
		Alert alert3 = driver.switchTo().alert(); // switch to alert
		String alertMessage3 = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage3); // Print Alert Message
		Thread.sleep(5000);
		alert3.accept();
		
		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}
}
