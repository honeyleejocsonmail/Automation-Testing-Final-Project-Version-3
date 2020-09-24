package testcases;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import base.BaseClass;
import pages.AccountSummaryPage;
import pages.OnlineStatementsPage;


public class TestCase005_verifyOnlineStatementDownload extends BaseClass {
		

		
			@Test  (dataProvider = "statementdownload")
			public void verifyOnlineStatement(String accountid1, String yearlink, String statementlink) {
				
				test = rep.startTest("verifyOnlineStatement Test Started");
				
				app_logs.info("verifyOnlineStatement test started");
				
				AccountSummaryPage asp=new AccountSummaryPage(driver);
				asp.doClickOnlineStatement(); 
				test.log(LogStatus.INFO,"Clicked Online Statement tab");
				
				
				OnlineStatementsPage osp=new OnlineStatementsPage(driver);
				osp.doAccount("Checking");
				test.log(LogStatus.INFO,"Entered Account Type");

				try {																//click the year - try/catch code for StaleElementReferenceException Error
					osp.doclickyearlink();
					test.log(LogStatus.INFO,"Clicked the year link");
				}
				catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
					osp.doclickyearlink();
					test.log(LogStatus.INFO,"Clicked the year link");
				}
				
				osp.doclickstatementlink();
				test.log(LogStatus.INFO,"Clicked the statement link");

				driver.navigate().to("chrome://Downloads/"); 						//navigate to downloads
				test.log(LogStatus.INFO,"Opened the path = chrome://Downloads/");
				
				String filename = driver.findElement(By.tagName("body")).getText();
	
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(filename.contains("8534567-05-12-11"), "File not Found");
				softAssert.assertAll();
				
				test.log(LogStatus.PASS,"Successfully Downloaded an Online Statement");
				
				app_logs.info("verifyOnlineStatement test completed");
				
			}
			

			
			@DataProvider(name="statementdownload")
			public Object[][] passdata() throws IOException{
				File src = new File("C:\\Users\\rechi\\eclipse-workspace\\FinalProjectVersion3\\src\\test\\resources\\exceldata\\TestData.xlsx"); //specify the file location
				FileInputStream fis= new FileInputStream(src); 	//load the file
				XSSFWorkbook wb = new XSSFWorkbook(fis); 		//load workbook from excel file
				XSSFSheet sheet = wb.getSheetAt(4); 			//loading the sheet 1
				int rowCount = sheet.getLastRowNum(); 			//counting number of rows by index
				int rows = rowCount +1;							//counting number of rows
				
				Object[][] data = new Object [rows][3];
				
				for (int i=0; i<rows ; i++) {
					data[i][0] =sheet.getRow(i).getCell(0).getStringCellValue();
					data[i][1] =sheet.getRow(i).getCell(1).getStringCellValue();
					data[i][2] =sheet.getRow(i).getCell(2).getStringCellValue();
				}
				
				return data;
				
			}
}
