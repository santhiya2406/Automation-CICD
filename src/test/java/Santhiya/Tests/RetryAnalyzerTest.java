package Santhiya.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Santhiya.TestComponents.Retry_;

public class RetryAnalyzerTest {
	
int attempt = 0;
	
	@Test(retryAnalyzer = Retry_.class)
	public void retryTestExample()
	{
		attempt++;
		System.out.println("Attempt:" + attempt);
		Assert.assertTrue(attempt > 1, "Failed first attempt");
	}

}
