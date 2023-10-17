package MavenTest111;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	@Test(priority = 5)
	public void positivelogintest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\Desktop\\Selenium\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String saucedemo = "https://www.saucedemo.com/";

		driver.get(saucedemo);

		WebElement positivelogintest = driver.findElement(By.id("user-name"));
		positivelogintest.click();

		positivelogintest.sendKeys("standard_user");

		Thread.sleep(2000);

		WebElement correctpassword = driver.findElement(By.id("password"));
		correctpassword.click();

		correctpassword.sendKeys("secret_sauce");

		WebElement positiveLoginTest = driver.findElement(By.xpath("//input[@id='login-button']"));
		positiveLoginTest.click();

		Thread.sleep(2000);

		String expectedoutcome = ("https://www.saucedemo.com/inventory.html");
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL + " Our current URL");
		Assert.assertEquals(actualURL, expectedoutcome);

		driver.quit();
	}

	@Test(priority = 4)
	public void lockedOutUserTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\Desktop\\Selenium\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String saucedemo = "https://www.saucedemo.com/";

		driver.get(saucedemo);

		WebElement positivelogintest = driver.findElement(By.id("user-name"));
		positivelogintest.click();

		positivelogintest.sendKeys("locked_out_user");

		Thread.sleep(2000);

		WebElement correctpassword = driver.findElement(By.id("password"));
		correctpassword.click();

		correctpassword.sendKeys("secret_sauce");

		WebElement positiveLoginTest = driver.findElement(By.xpath("//input[@id='login-button']"));
		positiveLoginTest.click();

		Thread.sleep(2000);

		String expectedmessage = "Epic sadface: Sorry, this user has been locked out.";
		WebElement expectedoutcome = driver.findElement(
				By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]"));
		String actualmessage = expectedoutcome.getText();
		Assert.assertEquals(actualmessage, expectedmessage);
		driver.quit();
	}

	@Test(priority = 3)
	public void usingproblemuser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\Desktop\\Selenium\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String saucedemo = "https://www.saucedemo.com/";

		driver.get(saucedemo);

		WebElement positivelogintest = driver.findElement(By.id("user-name"));
		positivelogintest.click();

		positivelogintest.sendKeys("problem_user");

		Thread.sleep(2000);

		WebElement correctpassword = driver.findElement(By.id("password"));
		correctpassword.click();

		correctpassword.sendKeys("secret_sauce");

		WebElement positiveLoginTest = driver.findElement(By.xpath("//input[@id='login-button']"));
		positiveLoginTest.click();

		Thread.sleep(2000);

		String expectedoutcome = ("https://www.saucedemo.com/inventory.html");
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL + " Our current URL");
		Assert.assertEquals(actualURL, expectedoutcome);

		driver.quit();

	}

	@Test(priority = 2)
	public void wrongPasswordTest() throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\Desktop\\Selenium\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String saucedemo = "https://www.saucedemo.com/";

		driver.get(saucedemo);

		WebElement positivelogintest = driver.findElement(By.id("user-name"));
		positivelogintest.click();

		positivelogintest.sendKeys("standard_user");

		Thread.sleep(2000);

		WebElement correctpassword = driver.findElement(By.id("password"));
		correctpassword.click();

		correctpassword.sendKeys("123456789");

		WebElement positiveLoginTest = driver.findElement(By.xpath("//input[@id='login-button']"));
		positiveLoginTest.click();

		Thread.sleep(2000);

		String expectedmessage = "Epic sadface: Username and password do not match any user in this service";
		WebElement expectedoutcome = driver.findElement(
				By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]"));
		String actualmessage = expectedoutcome.getText();
		Assert.assertEquals(actualmessage, expectedmessage);
		driver.quit();
	}

	@Test(priority = 1)
	public void wrongUsernameTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSI\\Desktop\\Selenium\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String saucedemo = "https://www.saucedemo.com/";

		driver.get(saucedemo);

		WebElement positivelogintest = driver.findElement(By.id("user-name"));
		positivelogintest.click();

		positivelogintest.sendKeys("hello_user");

		Thread.sleep(2000);

		WebElement correctpassword = driver.findElement(By.id("password"));
		correctpassword.click();

		correctpassword.sendKeys("secret_sauce");

		WebElement positiveLoginTest = driver.findElement(By.xpath("//input[@id='login-button']"));
		positiveLoginTest.click();

		Thread.sleep(2000);

		String expectedmessage = "Epic sadface: Username and password do not match any user in this service";
		WebElement expectedoutcome = driver.findElement(
				By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
		String actualmessage = expectedoutcome.getText();
		// Assert.assertEquals (expectedmessage ,actualmessage);
		assertTrue(expectedmessage.contains(actualmessage));

		driver.quit();
	}
}
