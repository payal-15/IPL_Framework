package scripts;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest{
	
	@Test
	public void testValidLogin()
	{
		LoginPage lp=new LoginPage(driver);
		//set username
		String userName=Lib.getCellValue("validLogin", 1, 0);
		lp.setUserName(userName);
		//set pwd
		String password=Lib.getCellValue("validLogin", 1, 1);
		lp.setPwd(password);
		//click login
		lp.clickLogin();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		//check if it is going to home page actiTIME - Enter Time-Track
		SoftAssert s=new SoftAssert();
		s.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		s.assertAll();
		
		
	}
}

