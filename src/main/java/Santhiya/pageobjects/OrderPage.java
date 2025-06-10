package Santhiya.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="complete-header")
	WebElement message;
	
	@FindBy(id="finish")
	WebElement finishButton;
	
	public boolean checkUrl()
	{
		return driver.getCurrentUrl().contains("checkout-step-two");
	}
	
	public void placeOrder()
	{
		finishButton.click();
	}

	public String displayMessage()
	{
		return message.getText();
	}
	
}
