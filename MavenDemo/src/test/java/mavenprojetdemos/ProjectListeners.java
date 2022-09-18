package mavenprojetdemos;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ProjectListeners implements ISuiteListener,ITestListener
{

	public void onStart(ISuite suite)
	{
	System.out.println("Before Suite...........onStart");	
	}

	public void onFinish(ISuite suite)
	{
	System.out.println("After Suite...........onFinish");	
	}

	public void onStart(ITestContext c)
	{
	System.out.println("OnStart...........");	
	}

	public void onFinish(ITestContext c)
	{
	System.out.println("OnFinish...........");	
	}

	public void onTestStart(ITestResult c)
	{
	System.out.println("OnTestStart...........");	
	}

	public void onTestSuccess(ITestResult c)
	{
	System.out.println("OnTestSucess...........");

	}

	public void onTestFailure(ITestResult c)
	{
	System.out.println("OnTestFailure...........");	
	}

	public void onTestSkipped(ITestResult c)
	{
	System.out.println("OnTestSkipped...........");	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult c)
	{
	System.out.println("OnTestFailedButWithinSuccessPercentage...........");	
	}
}
