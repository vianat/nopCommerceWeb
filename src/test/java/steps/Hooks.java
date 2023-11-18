package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Date;

public class Hooks extends BaseClass {
	final String systemName = System.getProperty("os.name");
	protected boolean skip = false;
	@Before
	public void before(io.cucumber.java.Scenario scenario) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		skip = false;
		if(systemName.contains("Win")){
			switch (scenario.getName()) {
				case "safari":
					skip = true;
					break;
				case "edge":
//					driver = new EdgeDriver();
					driver = setUpDriver(EdgeDriver.class);
					break;
				case "firefox":
//					driver = new FirefoxDriver();
					driver = setUpDriver(FirefoxDriver.class);
					break;
				case "chrome":
//					driver = new ChromeDriver();
					driver = setUpDriver(ChromeDriver.class);
					break;
			}

		} else {
			switch (scenario.getName()) {
				case "edge":
					driver = new EdgeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//					driver = setUpDriver(EdgeDriver.class);
					break;
				case "firefox":
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//					driver = setUpDriver(FirefoxDriver.class);
					break;
				case "safari":
					driver = new SafariDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//					driver = setUpDriver(SafariDriver.class);
					break;
				case "chrome":
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//					driver = setUpDriver(ChromeDriver.class);
					break;
			}
		}
	}
	private WebDriver setUpDriver(Class klass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		var driver = (WebDriver)klass.getDeclaredConstructor().newInstance();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;
	}

	@After
	public void after(Scenario scenario) throws IOException {
		
		System.out.println(scenario.getName() + "  " + scenario.getStatus());

		if (scenario.isFailed()) {
			Date date = new Date();
			String screenshotFilename = date.toString().replace(" ", "-").replace(":", "-");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("target/ScreenShots/" + screenshotFilename + ".png"));
		}
		if (driver != null) {
			driver.quit();
		};
	}
}