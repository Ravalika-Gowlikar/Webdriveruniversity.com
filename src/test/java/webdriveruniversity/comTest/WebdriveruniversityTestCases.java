package webdriveruniversity.comTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import webdriveruniversity.compages.ActionsPage;
import webdriveruniversity.compages.AjaxLoaderPage;
import webdriveruniversity.compages.ButtonClicksPage;
import webdriveruniversity.compages.ContactUsPage;
import webdriveruniversity.compages.DropDownPage;
import webdriveruniversity.compages.ElementsPage;
import webdriveruniversity.compages.FilePage;
import webdriveruniversity.compages.IFramePage;
import webdriveruniversity.compages.LoginPage;
import webdriveruniversity.compages.POMPage;
import webdriveruniversity.compages.PopupAlertsPage;
import webdriveruniversity.compages.ScrollingAroundPage;
import webdriveruniversity.compages.TextAffectsPage;
import webdriveruniversity.compages.ToDoListPage;

public class WebdriveruniversityTestCases {

	public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
	//LoginPage loginpage = new LoginPage(driver);
	String URL = "https://webdriveruniversity.com/index.html";
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(2000);
	} 

	
	@Test(priority=1)
		public void test1() throws Exception {
			ContactUsPage cp = new ContactUsPage(driver);
			cp.contact();
		}
		
		
	@Test(priority=2)
	public void test2() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.sigin();
	}
	
	@Test(priority=3)
	public void test3() throws Exception {
		ButtonClicksPage bcp = new ButtonClicksPage(driver);
		bcp.click_btn();
	}
	
	@Test(priority=4)
	public void test4() throws Exception {
		ToDoListPage td = new ToDoListPage(driver);
		td.list();
	}
	
	@Test(priority=5)
	public void test5() throws Exception {
		POMPage page = new POMPage(driver);
		page.pom();
	}
	
	@Test(priority=6)
		public void test6() throws InterruptedException, IOException {
			TextAffectsPage tp = new TextAffectsPage(driver);
			tp.textaffect();
		}
	
	@Test(priority=7)
	public void test7() throws Exception {
		DropDownPage dd = new DropDownPage(driver);
		dd.dropdown();
	}
		
	@Test(priority=8)
	public void test8() throws Exception {
		AjaxLoaderPage ap = new AjaxLoaderPage(driver);
		ap.loaderpage();
	}
	
	
	@Test(priority=9)
	public void test9() throws Exception {
		ActionsPage act = new ActionsPage(driver);
		act.action();
	}
	
	@Test(priority=10)
	public void test10() throws Exception {
		ScrollingAroundPage scroll = new ScrollingAroundPage(driver);
		scroll.scrolling();
	}
	
	@Test(priority=11)
	public void test11() throws Exception {
		PopupAlertsPage pop = new PopupAlertsPage(driver);
		pop.popupalert();
	}
	
	@Test(priority=12)
	public void test12() throws Exception {
		IFramePage iframe = new IFramePage(driver);
		iframe.iframepage();
	}
	
	@Test(priority=13)
	public void test13() throws Exception {
		ElementsPage ele = new ElementsPage(driver);
		ele.elements();
		ele.datapage();
		ele.autocomp_textfield();
	}
	
	@Test(priority=14)
	public void test14() throws Exception {
		FilePage file = new FilePage(driver);
		file.fileupload();
		file.datepicker();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
