package Santhiya.data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import Santhiya.TestComponents.BaseTest;

public class CredentialData extends BaseTest{

//	@DataProvider(name="Credentials")
//	public Object[][] getUserCredentials()
//	{
//		return new Object[][] {
//			{"standard_user", "secret_sauce"},
//			{"locked_out_user", "secret_sauce"}
//		};
//	}
	
	@DataProvider(name="Credentials")
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Santhiya\\data\\LoginData.json");
			return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
	@DataProvider(name="CheckOutData")
	public Object[][] getCheckOutData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\Santhiya\\data\\CheckOutPageData.json");
		return new Object[][] {{data.get(0)}};
	}
}
