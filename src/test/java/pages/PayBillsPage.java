package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class PayBillsPage extends BasePage {
	
	
	public PayBillsPage(WebDriver driver) {
		super(driver);
		}
	

	//For the Add New Payee tab
	@FindBy(xpath="//a[contains(text(),'Add New Payee')]")
	public WebElement lnkAddPayee;
	
	@FindBy(id="np_new_payee_name")
	public WebElement txtPayeeName;
	
	@FindBy(id="np_new_payee_address")
	public WebElement txtPayeeAddress;
	
	@FindBy(id="np_new_payee_account")
	public WebElement txtPayeeAccount;
	
	@FindBy(id="np_new_payee_details")
	public WebElement txtPayeeDetails;
	
	@FindBy(id="add_new_payee")
	public WebElement btnAddPayee;
	
	@FindBy(id="alert_container")
	public WebElement alertContainer;
	
	
	public void doClickAddPayee() {
		lnkAddPayee.click();
		
	}
	
	
	public void doAddPayee(String pname, String paddress, String paccount, String pdetails) {
		txtPayeeName.sendKeys(pname);
		txtPayeeAddress.sendKeys(paddress);
		txtPayeeAccount.sendKeys(paccount);
		txtPayeeDetails.sendKeys(pdetails);
		btnAddPayee.click();
		
	}
	
	
	//For the Pay Saved Payee tab

	
	@FindBy(xpath="//a[contains(text(),'Pay Saved Payee')]")
	public WebElement lnkPaySavedPayee;
	

	public void doClickPaySavedPayee() {
		lnkPaySavedPayee.click();
	}
	
	@FindBy(xpath="//select[@id='sp_payee']")
	public WebElement drpdownPayee;
	
	public void doPaySavedPayee(String sppayee) {
		Select s=new Select(drpdownPayee);
		s.selectByVisibleText(sppayee);
	}
	
	@FindBy(xpath="//select[@id='sp_account']")
	public WebElement drpdownspaccount;
	
	public void doSpAccount(String spaccount) {
		Select s=new Select(drpdownspaccount);
		s.selectByVisibleText(spaccount);
	}
	
	@FindBy(id="sp_amount")
	public WebElement spAmount;
	
	@FindBy(id="sp_date")
	public WebElement spDate;
	
	@FindBy(id="sp_description")
	public WebElement txtSpDescription;
		
	@FindBy(id="pay_saved_payees")
	public WebElement btnPaySavedPayee;

	
	public void doPayBills(String payee, String account, String amount, String date, String description) {
		drpdownPayee.sendKeys(payee);
		drpdownspaccount.sendKeys(account);
		spAmount.sendKeys(amount);
		spDate.sendKeys(date);
		txtSpDescription.sendKeys(description);
		btnPaySavedPayee.click();
		
	}
	


}
