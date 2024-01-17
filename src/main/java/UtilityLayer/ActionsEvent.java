package UtilityLayer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseLayer.BaseClass;

public class ActionsEvent extends BaseClass {

	public static void enterTextAndClick(WebElement wb, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(wb, value).sendKeys(Keys.ENTER).build().perform();
	}

}
