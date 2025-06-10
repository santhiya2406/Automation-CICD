package Santhiya.TestComponents;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Santhiya.pageobjects.InventoryPage;
import Santhiya.pageobjects.LoginPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BaseTest {

	public WebDriver driver;
	public String productName = "Sauce Labs Onesie";
	
	@BeforeMethod(alwaysRun=true)
	public void SetUp() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Santhiya\\resources\\GlobalData.properties");
		prop.load(fis);
//		String browserName = prop.getProperty("browser");
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

		if(browserName.contains("edge"))
		{
			EdgeOptions options = new EdgeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("--headless=new");
			}
			driver = new EdgeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	public InventoryPage doLogin()
	{
		LoginPage loginpage = new LoginPage(driver);
		return loginpage.loginApplication("standard_user", "secret_sauce");
	}
	
	public InventoryPage doLogin(String username, String password) {
	    LoginPage loginpage = new LoginPage(driver);
	    return loginpage.loginApplication(username, password); 
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		//Json to string
		String jsoncontent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		//string to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){
		});	
		return data;
	}
	
	public String getScreenshot(String testcaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}
}
