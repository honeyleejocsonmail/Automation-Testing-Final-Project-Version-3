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
import pages.TransferFundPage;



public class TestCase003_verifyTransferFund  extends BaseClass {


	@Test  (dataProvider = "transferfunddata")
	public void verifyTransferFund(String fromaccount1, String toaccount2, String amount , String description) {
		
		test = rep.startTest("verifyTransferFund Test Started");
		
		app_logs.info("verifyTransferFund test started");
		
		AccountSummaryPage asp=new AccountSummaryPage(driver);
		asp.doClickTransferFund();
		test.log(LogStatus.INFO,"Clicked Transfer tab");
		
		TransferFundPage tf=new TransferFundPage(driver);		
		tf.doTransferFund(fromaccount1, toaccount2, amount, description);
		test.log(LogStatus.INFO,"Entered From Account, To Account, Amount, Description, clicked Continue and clicked Submit");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(tf.alertContainer.isDisplayed());
		softAssert.assertAll();
		
		test.log(LogStatus.PASS,"Successfully Transferred a Fund");
		
		app_logs.info("verifyTransferFund test completed");

	}
	
	
	
	
	
	
	
	@DataProvider(name="transferfunddata")
	public Object[][] passdata() throws IOException{
		File src = new File("C:\\Users\\rechi\\eclipse-workspace\\FinalProjectVersion3\\src\\test\\resources\\exceldata\\TestData.xlsx"); //specify the file location
		FileInputStream fis= new FileInputStream(src); 	//load the file
		XSSFWorkbook wb = new XSSFWorkbook(fis); 		//load workbook from excel file
		XSSFSheet sheet = wb.getSheetAt(2); 			//loading the sheet 1
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
