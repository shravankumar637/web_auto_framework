package io.web.base;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.fold.core.configuration.ConfigurationTest;

public class BaseTest extends ConfigurationTest
{

	@BeforeSuite(alwaysRun=true)
	public void foldWebBeforeSuite(ITestContext testContext) throws Throwable
	{
		
		beforeSuite(testContext);
		
	}
	
	
	@BeforeTest(alwaysRun =true)
	public void foldWebBeforeTest(ITestContext testContext) throws Throwable
	{
		
		beforeTest(testContext);
	}

	
	@BeforeMethod(alwaysRun = true)
	public void foldWebBeforeMethod(Method method)
	{
		
		beforeMethod(method);
	}

	
	@AfterMethod(alwaysRun = true)
	public void foldWebAfterMethod(ITestResult result) throws Exception
	{
		afterMethod(result);
		
	}
	
	
	@AfterTest(alwaysRun = true)
	public void foldWebAfterTest()throws Exception
	{
		
		afterTest();
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterWebAfterSuite()throws Exception
	{
		afterSuite();
	}
	
	

}
