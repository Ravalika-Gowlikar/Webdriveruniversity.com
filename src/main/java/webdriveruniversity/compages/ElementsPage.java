package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ElementsPage {

	WebDriver driver;

	public ElementsPage(WebDriver driver) {
		this.driver = driver;
	}

	By ele_btn = By.xpath("//div[@class='section-title']/h1[text()='HIDDEN ELEMENTS']");
	By data_btn = By.xpath("//*[@id=\"data-table\"]/div/div[1]/h1");
	By auto_text = By.xpath("//*[@id=\"autocomplete-textfield\"]/div/div[1]/h1");
	By item_name = By.id("myInput");
	By submit_btn = By.id("submit-button");



	public void elements() throws Exception {
		driver.findElement(ele_btn).click();

		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}

//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir") + "//POMScreenshots//HiddenPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);

		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}

	public void datapage() throws Exception {
		driver.findElement(data_btn).click();
		
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}

//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir") + "//POMScreenshots//DataPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);

		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}

	public void autocomp_textfield() throws Exception {
		driver.findElement(auto_text).click();
		
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}

//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir") + "//POMScreenshots//Auto_comp_textPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);

		driver.findElement(item_name).sendKeys("apple");
		driver.findElement(submit_btn).click();

		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}

}
