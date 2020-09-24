package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class TransferFundPage extends BasePage {
	
	
	public TransferFundPage(WebDriver driver) {
		super(driver);
		}
	
	
	
	@FindBy(id="tf_fromAccountId")
	public WebElement drpdownfromAccountId;
	
	public void doFromAccount(String fromaccountid) {
		Select s=new Select(drpdownfromAccountId);
		s.selectByVisibleText(fromaccountid);
	}
	
	@FindBy(id="tf_toAccountId")
	public WebElement drpdowntoAccountId;
	
	public void doToAccount(String toaccountid) {
		Select s=new Select(drpdowntoAccountId);
		s.selectByVisibleText(toaccountid);
	}
	
	
	@FindBy(id="tf_amount")
	public WebElement txtamount;
	
	@FindBy(id="tf_description")
	public WebElement txtdescription;

	@FindBy(id="btn_submit")
	public WebElement submitbtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	public WebElement alertContainer;
	
	public void doTransferFund(String fromaccountid, String toaccountid, String amount, String description) {
		drpdownfromAccountId.sendKeys(fromaccountid);
		drpdowntoAccountId.sendKeys(toaccountid);
		txtamount.sendKeys(amount);
		txtdescription.sendKeys(description);
		submitbtn.click();
		submitbtn.click();
		
	}
	
	
	
}
