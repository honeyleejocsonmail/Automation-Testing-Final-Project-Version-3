package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class OnlineStatementsPage extends BasePage {
	
	
	public OnlineStatementsPage(WebDriver driver) {
		super(driver);
		}
	
	
	@FindBy(id="os_accountId")
	public WebElement drpdownAccount;
	
	public void doAccount(String account) {
		Select s=new Select(drpdownAccount);
		s.selectByVisibleText(account);
	}
	
	
	
	@FindBy(xpath="//a[@href='#os_2011']")
	public WebElement yearlink;
	
	public void doclickyearlink() {
		yearlink.click();
	}
	
	
	@FindBy(xpath="//a[@href='/bank/online-statements-by-name.html?name=8534567-05-12-11.pdf']")
	public WebElement statementlink;
	
	public void doclickstatementlink() {
		statementlink.click();
	}
	

}
	

