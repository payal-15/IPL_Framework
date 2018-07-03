package generic;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant {
	public WebDriver driver;

	static {
		//set path
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	@BeforeMethod
	public void openApplication()
	{
		//launch browser
		driver=new FirefoxDriver();
		//goto url
		driver.get(Lib.getPropertyValue("URL"));
		String propertyValue = Lib.getPropertyValue("ITO");
		long timeOut = Long.parseLong(propertyValue);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeApplication(ITestResult rs)
	{	
		if(ITestResult.FAILURE==rs.getStatus())
		{
			Lib.takeScreenShot(driver,rs.getName());
		}
		driver.close();
	}
}





