package webdriveruniversity.compages;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {

	WebDriver driver;

	public DropDownPage(WebDriver driver) {
		this.driver = driver;
	}

	By drop_btn = By.xpath("//div[@class='section-title']/h1[text()='DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)']");
	By drop_dwn1 = By.id("dropdowm-menu-1");
	By drop_dwn2 = By.id("dropdowm-menu-2");
    By drop_dwn3 = By.id("dropdowm-menu-3");
	By check_box = By.xpath("//*[@id=\"checkboxes\"]/label[1]/input");
	By radio_btn1 = By.xpath("//*[@id=\"radio-buttons\"]/input[2]");
	By radio_btn2 = By.xpath("//*[@id=\"radio-buttons-selected-disabled\"]/input[1]");
	By selt_fruit = By.id("fruit-selects");
	
	public void dropdown() throws InterruptedException, Exception {
		driver.findElement(drop_btn).click();
		
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		
//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//DropdownPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);
		
		Select drp_down1 = new Select(driver.findElement(drop_dwn1));
		drp_down1.selectByVisibleText("SQL");
		Thread.sleep(2000);
		Select drp_down2 = new Select(driver.findElement(drop_dwn2));
		drp_down2.selectByIndex(2);
		Thread.sleep(2000);
		Select drp_down3 = new Select(driver.findElement(drop_dwn3));
		drp_down3.selectByValue("css");
		
		driver.findElement(check_box).click();
		driver.findElement(radio_btn1).click();
		driver.findElement(radio_btn2).click();
		drp_down1.selectByVisibleText("SQL");
		Thread.sleep(2000);
		Select drp_down = new Select(driver.findElement(selt_fruit));
		drp_down.selectByIndex(0);
		
		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}
}
