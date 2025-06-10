package Santhiya.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Santhiya.AbstractComponents.AbstractComponent;

public class InventoryPage extends AbstractComponent{
	
	WebDriver driver;

	public InventoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='inventory_item_label']")
	List<WebElement> products;
	
	@FindBy(css=".shopping_cart_link")
	WebElement cartbutton;
	
	By addToCartButton = By.cssSelector("button[id*='add-to-cart']");
	By addToCart = By.xpath("following-sibling::div/button");
	
	public boolean checkProductDisplay()
	{
		return products.size() > 0;
	}
	
	public WebElement getProductName(String productName)
	{
		return products.stream().filter(item -> item.findElement(By.cssSelector("a div")).getText().equals(productName)).findFirst().orElse(null);
	}
	
	public void addtoCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductName(productName);
		waitForElementToAppear(addToCartButton);
		prod.findElement(addToCart).click();
	}
	
	public CartPage _GoToCart()
	{
		cartbutton.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
}
