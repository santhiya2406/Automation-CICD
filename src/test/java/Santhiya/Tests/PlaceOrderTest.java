package Santhiya.Tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import Santhiya.TestComponents.BaseTest;
import Santhiya.data.CredentialData;
import Santhiya.pageobjects.CartPage;
import Santhiya.pageobjects.InventoryPage;
import Santhiya.pageobjects.OrderPage;
import Santhiya.pageobjects.CheckOutPage;
import junit.framework.Assert;

public class PlaceOrderTest extends BaseTest {
	

	@Test(dataProvider="Credentials", dataProviderClass=CredentialData.class)
	public void ProductDisplay(HashMap<String, String> input)
	{
		InventoryPage inventorypage = doLogin(input.get("username"), input.get("password"));
		Assert.assertTrue(inventorypage.checkProductDisplay());
	}
	
	@Test(groups= {"PlaceOrder"}, dataProvider="CheckOutData", dataProviderClass=CredentialData.class)
	public void addToCart(HashMap<String, String> input) throws InterruptedException   
	{
		InventoryPage inventorypage = doLogin();
		inventorypage.addtoCart(productName);
		CartPage cartpage = inventorypage._GoToCart();
		Assert.assertTrue(cartpage.checkCart(productName));
		CheckOutPage checkoutpage = cartpage.goToCheckoutPage();
		Assert.assertTrue(checkoutpage.checkUrl());
		OrderPage orderpage = checkoutpage.enterDetails(input.get("firstname"), input.get("lastname"), input.get("postalCode"));
		Assert.assertTrue(orderpage.checkUrl());
		orderpage.placeOrder();
		Assert.assertTrue(orderpage.displayMessage().equalsIgnoreCase("Thank you for your order!"));
		
	}
	
}
