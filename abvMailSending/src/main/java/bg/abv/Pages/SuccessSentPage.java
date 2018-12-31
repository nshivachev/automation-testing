package bg.abv.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Helper.BrowserFactory;


public class SuccessSentPage {
	
	WebDriver driver;

	//SuccessSentPage Elements
	@FindBy(how=How.CLASS_NAME, using="abv-h2")
	WebElement success_sent_textbox;
	
	//Constructor
	public SuccessSentPage(WebDriver ldriver) 
	{
		this.driver = ldriver;
	}
	
	//Assert successful sent message
	public void verifySending() 
	{		
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(success_sent_textbox));
		Assert.assertTrue(success_sent_textbox.isDisplayed());		
	}

}
