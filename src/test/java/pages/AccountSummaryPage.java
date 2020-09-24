package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class AccountSummaryPage extends BasePage {
	
	public AccountSummaryPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//a[contains(text(),'Pay Bills')]")
	public WebElement lnkPayBills;
	
	public void doClickPayBills() {
		lnkPayBills.click();
		
	}
	@FindBy(xpath="//a[contains(text(),'Transfer Funds')]")
	public WebElement lnkTransferFund;
	
	public void doClickTransferFund() {
		lnkTransferFund.click();
	}
	
		
	@FindBy(xpath="//a[contains(text(),'Online Statements')]")
	public WebElement lnkOnlineStatements;
	
	public void doClickOnlineStatement() {
		lnkOnlineStatements.click();
	}
	
	
}
