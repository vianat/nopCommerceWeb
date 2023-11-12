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
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks extends BaseClass {

	@Before
	public void before(io.cucumber.java.Scenario scenario) {
		final String systemName = System.getProperty("os.name");
//		String browserName = context.getCurrentXmlTest().getParameter("browserName");
//		String dir = System.getProperty("user.dir");
//		Properties prop = new Properties();
//		prop.load(new FileInputStream(dir + "/src/test/java/resources/data.properties"));
//		String browserName = prop.getProperty("browser");

		if(systemName.contains("Windows")){
			switch (scenario.getName()) {
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "safari":
					WebDriverManager.safaridriver().setup();
					driver = new SafariDriver();
					break;
				default:
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--log-level=3");
//				options.addArguments("--silent");
//				options.addArguments("--headless");
// 				run without UI
//				if (browserName.contains("headless")) {
//					options.addArguments("headless");
//				}
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
			}
		} else {
			switch (scenario.getName()) {
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--log-level=3");
//				options.addArguments("--silent");
//				options.addArguments("--headless");
// 				run without UI
//				if (browserName.contains("headless")) {
//					options.addArguments("headless");
//				}
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
			}
		}

//		driver.manage().deleteAllCookies(); // not working with safari
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