package Santhiya.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="user-name")
	private WebElement userName;

	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	@FindBy(css="[class*='error-message'] h3")
	private WebElement errorMessage;
	
	public InventoryPage loginApplication(String Name, String pwd)
	{
		userName.sendKeys(Name);
		password.sendKeys(pwd);
		loginButton.click();
		InventoryPage inventorypage = new InventoryPage(driver);
		return inventorypage;
	}
	
	public String errorMessage()
	{
		return errorMessage.getText();
	}
}
