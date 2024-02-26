package webdriveruniversity.compages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
	WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	By contact_Us = By.xpath("//div[@class='section-title']/h1[text()='CONTACT US']");
	By fname = By.xpath("//*[@id=\"contact_form\"]/input[1]");
	By lname = By.xpath("//*[@id=\"contact_form\"]/input[2]");
	By email = By.xpath("//*[@id=\"contact_form\"]/input[3]");
	By commt = By.xpath("//*[@id=\"contact_form\"]/textarea");
	By submit = By.xpath("//*[@id=\"form_buttons\"]/input[2]");

	public void contact() throws Exception {
		driver.findElement(contact_Us).click();

		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		
		driver.findElement(fname).sendKeys("John");
		driver.findElement(lname).sendKeys("Lee");
		driver.findElement(email).sendKeys("john@gmail.com");
		driver.findElement(commt).sendKeys("Hello");
		driver.findElement(submit).click();
		
		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
		
	}
}
