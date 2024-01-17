package UtilityLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class UtilsClass extends BaseClass {

	// Reusabel script code for check element displayed status and enabled status
	// and click on element
	public static void click(WebElement wb) {
		if (wb.isDisplayed() && wb.isEnabled()) {
			wb.click();
		}
	}

	// Reusabel script code for check element displayed status and enabled status
	// and enter the value
	public static void sendKeys(WebElement wb, String value) {
		if (wb.isDisplayed() && wb.isEnabled()) {
			wb.sendKeys(value);
		}
	}

	// Reusable script code for select gender
	public static void selectGender(List<WebElement> ls, String gender) {
		for (WebElement wb : ls) {
			if (wb.getText().equalsIgnoreCase(gender)) {
				wb.click();
				break;
			}
		}
	}

	public static void takeScreenshot() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

		FileUtils.copyFile(f, new File(System.getProperty("user.dir") + "\\PassScreenshot\\" + date + ".png"));

	}

}
