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
import pages.HomePage;
import pages.LoginPage;




public class TestCase001_verifyLogin extends BaseClass {

	HomePage hp;
	LoginPage lp;

	
	@Test  (dataProvider = "logindata")
	public void verifylogin(String uname, String pword) {
		
		test = rep.startTest("verifyLogin Test Started");
		
		app_logs.info("verify login test started");
		
		hp = new HomePage(driver);
		hp.doClick();
		test.log(LogStatus.INFO,"Clicked Signin Button");
		
		
		lp=new LoginPage(driver);
		lp.doLogin(uname, pword);
		test.log(LogStatus.INFO,"Entered Username, Password and click Submit Button");
		
		String actual = driver.getTitle();
		String expected="Zero - Account Summary";
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();
		
		test.log(LogStatus.PASS,"Login Successfully");
		app_logs.info("verify login test completed");
		}


	
	
	
	@DataProvider(name="logindata")
	public Object[][] passdata() throws IOException{
		
		File src = new File("C:\\Users\\rechi\\eclipse-workspace\\FinalProjectVersion3\\src\\test\\resources\\exceldata\\TestData.xlsx"); //specify the file location
		FileInputStream fis= new FileInputStream(src); 	//load the file
		XSSFWorkbook wb = new XSSFWorkbook(fis); 		//load workbook from excel file
		XSSFSheet sheet = wb.getSheetAt(0); 			//loading the sheet 1
		int rowCount = sheet.getLastRowNum(); 			//counting number of rows by index
		
		
				Object[][] data = new Object [rowCount][2];	
				for (int i=1; i<rowCount + 1 ; i++) {			
					data[i-1][0] =sheet.getRow(i).getCell(0).getStringCellValue();
					data[i-1][1] =sheet.getRow(i).getCell(1).getStringCellValue();	
				}	
		return data;
	}
	

	
}
