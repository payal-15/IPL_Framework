package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declare
	@FindBy (name="username")
	WebElement unTB;
	@FindBy (name="pwd")
	WebElement pwdTB;
	@FindBy (id="loginButton")
	WebElement loginButton;
	
	//initialize
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilize
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	public void setPwd(String pwd)
	{
		pwdTB.sendKeys(pwd);
	}
	public void clickLogin()
	{
		loginButton.click();
	}
}
