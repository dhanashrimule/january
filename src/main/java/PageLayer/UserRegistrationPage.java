package PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.ActionsEvent;
import UtilityLayer.HandleDropDown;
import UtilityLayer.UtilsClass;

public class UserRegistrationPage extends BaseClass {
	// 1. create Object Repository by using @FindBy annotations

	@FindBy(name = "cpvLocationPO")
	private WebElement passportOfficeRadiobutton;

	@FindBy(name = "dcdrLocation")
	private WebElement passportOffice;

	@FindBy(name = "givenName")
	private WebElement fname;

	@FindBy(name = "surname")
	private WebElement lname;

	@FindBy(name = "dob")
	private WebElement dob;

	@FindBy(name = "email")
	private WebElement email;

	@FindBys(@FindBy(name = "emailloginSame"))
	private List<WebElement> radioButton;

	@FindBy(name = "loginId")
	private WebElement loginId;

	@FindBy(name = "pwd")
	private WebElement pwd;

	@FindBy(name = "confirmPwd")
	private WebElement confirmPwd;

	@FindBy(name = "hintQues")
	private WebElement hintQues;

	@FindBy(name = "hintAns")
	private WebElement hintAns;

	// 2. initialize the Object Repository by using PageFactory.initElements()
	// method in constructor

	public UserRegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	// 3. create associated method for each and every object repository without
	// entering test data.

	public void registerNewUser(String PassportOffice, String firstname, String Lastname, String DOB, String EmailId,
			String RadioButton, String LoginId, String Password, String ConfirmPassword, String HintQue, String HintAns)
			throws InterruptedException {

		// UtilsClass.click(passportOfficeRadiobutton);
		HandleDropDown.selectByVisibleText(passportOffice, PassportOffice);
		UtilsClass.sendKeys(fname, firstname);
		UtilsClass.sendKeys(lname, Lastname);

		ActionsEvent.enterTextAndClick(dob, DOB);
		Thread.sleep(5000);
		UtilsClass.sendKeys(email, EmailId);
		UtilsClass.selectGender(radioButton, RadioButton);
		UtilsClass.sendKeys(loginId, LoginId);
		UtilsClass.sendKeys(pwd, Password);
		UtilsClass.sendKeys(confirmPwd, ConfirmPassword);
		HandleDropDown.selectByVisibleText(hintQues, HintQue);
		UtilsClass.sendKeys(hintAns, HintAns);

	}

}
