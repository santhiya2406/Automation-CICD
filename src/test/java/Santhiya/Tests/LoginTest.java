package Santhiya.Tests;

import org.testng.annotations.Test;

//import com.sun.net.httpserver.Authenticator.Retry;

import Santhiya.TestComponents.BaseTest;
import Santhiya.TestComponents.Retry_;
import Santhiya.pageobjects.LoginPage;
import org.testng.Assert;

public class LoginTest extends BaseTest{

	@Test
	public void validLogin()
	{
		doLogin();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory"));
	}
	
	@Test(retryAnalyzer = Retry_.class)
	public void invalidLogin()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginApplication("standard_user", "secret_auce");
		String errorMessage = loginpage.errorMessage();
		Assert.assertFalse(errorMessage.equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
	}
	
}
