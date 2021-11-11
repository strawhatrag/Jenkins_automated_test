package test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import pages.LoginPage;

public class LoginTest extends Baseclass {
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	@Parameters({"UserName", "Password"})
	@Test(enabled=false)
	public void NegativeLogin(String UserNameVal, String PasswordVal) {
		
		test = report.startTest("Negative Login Test");
		LoginPage login = new LoginPage();
		login.Login(UserNameVal,PasswordVal);
		login.ErrorCheck();
		report.endTest(test);
		
	}
	
	@Parameters({"UserName","CorrectPassword"})
	@Test(enabled=false)
	public void PositiveLogin(String UserNameVal, String PasswordVal) {
		
		test = report.startTest("Positive Login Test");
		LoginPage login = new LoginPage();
		login.Login(UserNameVal,PasswordVal);
		report.endTest(test);
		
		
	}
	
	@Test
	public void ExcelTest() throws IOException {
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("data");
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(UserNameVal);
		
		test = report.startTest("Positive Login Test");
		LoginPage login = new LoginPage();
		login.Login(UserNameVal,PasswordVal);
		report.endTest(test);
		
		
	}
	
	
	
	
	
}