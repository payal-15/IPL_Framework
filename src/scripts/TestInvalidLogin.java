package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest{
	
	@Test
	public void testInvalidLogin()
	{
		LoginPage lp= new LoginPage(driver);
		
		int rowCount=Lib.getRowCount("invalidLogin");
		for(int i=1;i<=rowCount;i++)
		{
		String userName=Lib.getCellValue("invalidLogin", i, 0);
		lp.setUserName(userName);

		String pwd=Lib.getCellValue("invalidLogin", i, 1);
		lp.setUserName(pwd);
		
		lp.clickLogin();
		}

	}
}
