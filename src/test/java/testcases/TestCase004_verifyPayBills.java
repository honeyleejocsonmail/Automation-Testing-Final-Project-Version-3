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
import pages.PayBillsPage;
import pages.AccountSummaryPage;



public class TestCase004_verifyPayBills  extends BaseClass {
		
		
		@Test  (dataProvider = "paybilldata")
		public void verifyPayBills(String payee1, String account1, String amount, String date , String description) {
			
			test = rep.startTest("verifyPayBills Test Started");
			
			app_logs.info("verifyPayBills test started");
			
			AccountSummaryPage asp=new AccountSummaryPage(driver);
			asp.doClickPayBills(); 
			test.log(LogStatus.INFO,"Clicked Pay Bills tab");
			
			PayBillsPage pb=new PayBillsPage(driver);	
			pb.doClickPaySavedPayee(); 
			test.log(LogStatus.INFO,"Clicked Pay Saved Payee tab");
			
			pb.doPayBills(payee1, account1, amount, date, description );
			test.log(LogStatus.INFO,"Entered Payee Name , Account, Amount,  Date, Description and clicked Pay Buttton");
		
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(pb.alertContainer.isDisplayed());
			softAssert.assertAll();
			
			test.log(LogStatus.PASS,"Successfully Paid the Bill");
			
			app_logs.info("verifyPayBills test started");
		}
		
		
		
		
		
		
		
		@DataProvider(name="paybilldata")
		public Object[][] passdata() throws IOException{
			File src = new File("C:\\Users\\rechi\\eclipse-workspace\\FinalProjectVersion3\\src\\test\\resources\\exceldata\\TestData.xlsx"); //specify the file location
			FileInputStream fis= new FileInputStream(src); 	//load the file
			XSSFWorkbook wb = new XSSFWorkbook(fis); 		//load workbook from excel file
			XSSFSheet sheet = wb.getSheetAt(3); 			//loading the sheet 1
			int rowCount = sheet.getLastRowNum(); 			//counting number of rows by index
			int rows = rowCount +1;							//counting number of rows
			
			Object[][] data = new Object [rows][5];
			
			for (int i=0; i<rows ; i++) {
				data[i][0] =sheet.getRow(i).getCell(0).getStringCellValue();
				data[i][1] =sheet.getRow(i).getCell(1).getStringCellValue();
				data[i][2] =sheet.getRow(i).getCell(2).getStringCellValue();
				data[i][3] =sheet.getRow(i).getCell(3).getStringCellValue();
				data[i][4] =sheet.getRow(i).getCell(4).getStringCellValue();
			}
			
			return data;
			
		}
}
