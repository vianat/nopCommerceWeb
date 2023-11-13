package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks extends BaseClass {
	final String systemName = System.getProperty("os.name");
	@Before
	public void before(io.cucumber.java.Scenario scenario) {

		if(systemName.contains("win")){
			switch (scenario.getName()) {
				case "edge":
					driver = new EdgeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				case "chrome":
					driver = new ChromeDriver();
					break;
			}
		} else {
			switch (scenario.getName()) {
				case "edge":
					driver = new EdgeDriver();
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				case "safari":
					driver = new SafariDriver();
					break;
				case "chrome":
					driver = new ChromeDriver();
					break;
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	@After
	public void after(Scenario scenario) throws IOException {
		
		System.out.println(scenario.getName() + " -> " + scenario.getStatus());

		if (scenario.isFailed()) {
			Date date = new Date();
			String screenshotFilename = date.toString().replace(" ", "-").replace(":", "-");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("target/ScreenShots/" + screenshotFilename + ".png"));
		}
		if (driver != null) driver.quit();
	}
}