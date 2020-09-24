package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePage;

public class LoginPage extends BasePage {
	

	public LoginPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(id="user_login")
	public WebElement txtUsername;
	
	@FindBy(id="user_password")
	public WebElement txtPassword;
	
	@FindBy(name="submit")
	public WebElement btnSubmit;
	
	public void doLogin(String myusername, String mypassword) {
		txtUsername.sendKeys(myusername);
		txtPassword.sendKeys(mypassword);
		btnSubmit.click();
	}
	

}
