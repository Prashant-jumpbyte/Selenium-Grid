package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Node2 {
	WebDriver driver;
	String nodeUrl;

	@BeforeClass
	public void Setup() {

	}

	@Test
	public void Google() throws Exception {
		try {
			nodeUrl =  "http://<IP Address>:<Port>/wd/hub";
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.getCurrent());
			driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
			driver.manage().deleteAllCookies();
			// driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);

			driver.get("https://www.google.co.in/");
			driver.findElement(By.name("btnI")).click();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void Teardown() {
		driver.close();
	}
}
