package testcases;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import base.BaseClass;
import pages.AccountSummaryPage;
import pages.PayBillsPage;



public class TestCase002_verifyAddPayee extends BaseClass {


	
	@Test  (dataProvider = "payeedata")
	public void verifyAddPayee(String payeename, String payeeaddress, String payeeacct , String payeedetails) {
		test = rep.startTest("verifyAddPayee Test Started");
		
		app_logs.info("verifyAddPayee test started");
		
		AccountSummaryPage asp=new AccountSummaryPage(driver);
		asp.doClickPayBills(); 
		test.log(LogStatus.INFO,"Clicked Pay Bills tab");

		PayBillsPage pb=new PayBillsPage(driver);
		pb.doClickAddPayee(); 
		test.log(LogStatus.INFO,"Clicked Add Payee tab");
		
		pb.doAddPayee(payeename, payeeaddress, payeeacct, payeedetails);
		test.log(LogStatus.INFO,"Entered Payee Name , Adress, Account Number, Account Details and clicked Add Button");
			
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(pb.alertContainer.isDisplayed());
		softAssert.assertAll();
		
		test.log(LogStatus.PASS,"Payee Successfully Added");
		
		app_logs.info("verifyAddPayee test completed");
		
	}
		
	
	
	
	
	
	
	
	@DataProvider(name="payeedata")
	public Object[][] passdata() throws IOException{
			
			File src = new File("C:\\Users\\rechi\\eclipse-workspace\\FinalProjectVersion3\\src\\test\\resources\\exceldata\\TestData.xlsx"); //specify the file location
			FileInputStream fis= new FileInputStream(src); 	//load the file
			XSSFWorkbook wb = new XSSFWorkbook(fis); 		//load workbook from excel file
			XSSFSheet sheet = wb.getSheetAt(1); 			//loading the sheet 1
			int rowCount = sheet.getLastRowNum(); 			//counting number of rows by index
			int rows = rowCount +1;							//counting number of rows

		Object[][] data = new Object [rows][4];
		
		for (int i=0; i<rows ; i++) {
			data[i][0] =sheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1] =sheet.getRow(i).getCell(1).getStringCellValue();
			data[i][2] =sheet.getRow(i).getCell(2).getStringCellValue();
			data[i][3] =sheet.getRow(i).getCell(3).getStringCellValue();
		}
		
		return data;
	}

}
