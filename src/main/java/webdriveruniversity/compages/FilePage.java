package webdriveruniversity.compages;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class FilePage {

	 WebDriver driver;
	
	public FilePage(WebDriver driver) {
		this.driver = driver;
	}

	By alerts_btn = By.xpath("//div[@class='section-title']/h1[text()='FILE UPLOAD']");
	By choose_file = By.id("myFile");
	By submit_btn = By.id("submit-button");
	By date_btn = By.xpath("//*[@id=\"datepicker\"]/div/div[1]/h1");
	By date_picker = By.xpath("//*[@id=\"datepicker\"]/input");
	By select_date = By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[6]/td[1]");

	public void fileupload() throws Exception {
		Thread.sleep(2000);
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
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//FileUploadPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);
		
		WebElement uploadfile = driver.findElement(choose_file);
		uploadfile.sendKeys("C:\\Users\\gowlikar.ravalika\\OneDrive - Infosys Limited\\Documents\\output.txt");
		driver.findElement(submit_btn).click();
		System.out.println("File Uploaded Successfully");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.close();
		driver.switchTo().window(parentHandle);
		Thread.sleep(2000);
	}

	public void datepicker() throws Exception {
		driver.findElement(date_btn).click();
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
		
//		Thread.sleep(2000);
//		File src = new File(System.getProperty("user.dir")+"//POMScreenshots//DatePickerPage.png");
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File f2 = ts.getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(f2, src);
		
		Calendar calendar = Calendar.getInstance();
		String targetDate = "31-dec-2023";
		SimpleDateFormat targetDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date formattedTargetDate;
		try {
			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(targetDate);
			calendar.setTime(formattedTargetDate);
			
			int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
			int targetMonth = calendar.get(Calendar.MONTH);
			int targetYear = calendar.get(Calendar.YEAR);
			
			driver.findElement(date_picker).click();
			Thread.sleep(3000);
			driver.findElement(select_date).click();
			
		} catch (ParseException e) {
			throw new Exception("Invalid date is provided, please check the input date");
			
		}

	}
}
