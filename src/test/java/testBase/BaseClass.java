package testBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class BaseClass {

	public WebDriver driver;

	public Logger logger; // for logging
	
	public ResourceBundle rb;

	@BeforeClass
	@Parameters("browser")

	public void setup(String br) { 
		rb =ResourceBundle.getBundle("config");  //Load config.properties file
		logger = LogManager.getLogger(this.getClass()); //logging

		// WebDriverManager.firefoxdriver().setup();
		if (br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (br.equals("edge")) {
			driver = new EdgeDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}

}
