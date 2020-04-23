package StepDef;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.AWTException;
import java.util.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Verify;

import Muthu.Framework.*;

public class StepDefinition extends FrameworkClass {

	

	/*
	 * 
	 * Given i have "gmail" login page opened in "chrome" browser Then I verify ""
	 * page is displayed When I enter "" for "" editfield And I enter "" for ""
	 * editfield And I click "" button Then I wait for "" seconds And I verify ""
	 * page is displayed
	 */
	@Before("@login")
	public void beforeEachScenario(Scenario scenario) throws AWTException, InterruptedException, IOException {
		FrameworkClass.ExcelHandler();
		StartTime = System.currentTimeMillis();

		tcName = scenario.getName();
		hashMapData = FrameworkClass.testDatahandler(tcName);

	}

	@Given("^[i|I] check Background$")
	public void background() {
		System.out.println("background");
	}

	@Given("^[i|I] have \"(.*)\" login page opened in \"(.*)\" browser$")
	public void PageLaunch(String strPage, String strBrowser) {

		strBrowser = strBrowser.toLowerCase();
		String strURL = property.getProperty("URL");

		if (strBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Muthukumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Muthukumar\\Downloads\\IEDriverServer_x64_3.13.0\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		}

		driver.get(strURL);
		driver.manage().window().maximize();
		// waitdriver = new WebDriverWait(driver, 20);

	}

	@When("^[i|I] verify \"(.*)\" page is displayed$")
	public void pageVerification(String strPage) throws IOException {
		Set<String> pageTitles = driver.getWindowHandles();
		Iterator pageIterator = pageTitles.iterator();
		String winHandle;
		int flag = 0;
		while (pageIterator.hasNext()) {
			winHandle = pageIterator.next().toString();
			driver.switchTo().window(winHandle);
			if ((driver.getTitle().contains(strPage))) {
				flag = 1;
				FrameworkClass.ValidationScreenshot();
				FrameworkClass.createHtml(1, "pageDisplayed");

				break;
			}
		}
		if (flag == 0) {

			FrameworkClass.createHtml(0, "pageNotDisplayed");
			System.exit(1);
		}

	}

	@Then("^[i|I] wait for \"(.*)\" seconds$")
	public void waitForSeconds(int n) throws InterruptedException {
		Thread.sleep(1000 * n);
	}

	/*
	 * @When("^[I|i] enter \"(.*)\" for \"(.*)\" editfield in \"(.*)\" page$")
	 * public void enterTextEditField(String strText, String objEdit, String
	 * objPage) throws IOException { try { if
	 * (driver.findElement(FrameworkClass.getObj(objEdit, objPage)).isDisplayed()) {
	 * driver.findElement(FrameworkClass.getObj(objEdit, objPage)).click();
	 * driver.findElement(FrameworkClass.getObj(objEdit,
	 * objPage)).sendKeys(hashMapData.get(strText));
	 * 
	 * } } catch (Exception e) { FrameworkClass.createHtml(0, objEdit +
	 * "not displayed");
	 * 
	 * } }
	 * 
	 */
	@Given("^[i|I] test ReadJSON$")
	public void TestJson() throws IOException {
		FrameworkClass.ReaderPath();
	
	
		driver.findElement(FrameworkClass.JSONPropertyExtractory("Login")).click();
	}

	@After("@login")
	public void afterScenario() {
		Verify.verify(globalFlag);
		driver.quit();
	}

	@Given("^I add two numbers$")
	public void add(DataTable dt) {
		List<Map<String, String>> li = dt.asMaps(String.class, String.class);
		System.out.println(li.get(0).get("h1"));

	}

	@Given("^[I|i] open \"(.*)\" tshirt$")
	public void openingZip(String s) {
		System.out.println(s);
	}

}
