package TestLayer;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.UserRegistrationPage;
import UtilityLayer.ExcelReader;
import UtilityLayer.UtilsClass;

public class RegisterPageTest extends BaseClass {
	private UserRegistrationPage userRegistrationPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		BaseClass.initialization();
	}

	@Test(dataProvider = "registerTestData")
	public void validateRegisterUserFunctionality(String PassportOffice, String firstname, String Lastname, String DOB,
			String EmailId, String RadioButton, String LoginId, String Password, String ConfirmPassword, String HintQue,
			String HintAns) throws InterruptedException, IOException {
		UtilsClass.takeScreenshot();
		userRegistrationPage = new UserRegistrationPage();
		userRegistrationPage.registerNewUser(PassportOffice, firstname, Lastname, DOB, EmailId, RadioButton, LoginId,
				Password, ConfirmPassword, HintQue, HintAns);
		UtilsClass.takeScreenshot();
	}

	@DataProvider(name = "registerTestData")
	public Object[][] getData() throws IOException {
		ExcelReader obj = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\PassportIndia.xlsx");
		return obj.getAllSheetData(0);
	}

	@AfterTest
	public void tearDown() {
		// driver.quit();
	}

}
