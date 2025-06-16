package Santhiya.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Santhiya.AbstractComponents.AbstractComponent;

public class CartPage{
	
	WebDriver driver;

	@FindBy(css=".inventory_item_name")
	WebElement productInCart;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkCart(String productName)
	{
		return productInCart.getText().equals(productName);
	}
	
	public CheckOutPage goToCheckoutPage()
	{
		checkoutButton.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}
	


}
