package Santhiya.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_ implements IRetryAnalyzer{

	int count = 0;
	int maxTry = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Retry attempt #" + (count + 1) + " for " + result.getName());
		if(count < maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

	
}
