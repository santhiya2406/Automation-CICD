package Santhiya.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[data-test='firstName']")
	WebElement firstName;
	
	@FindBy(css="input[data-test='lastName']")
	WebElement lastName;
	
	@FindBy(css="input[data-test='postalCode']")
	WebElement postalCode;
	
	@FindBy(css="input[data-test='continue']")
	WebElement continueButton;
	
	public boolean checkUrl()
	{
		return driver.getCurrentUrl().contains("checkout-step-one");
	}
	
	public OrderPage enterDetails(String firstname, String lastname, String Code)
	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		postalCode.sendKeys(Code);
		continueButton.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	}
}
