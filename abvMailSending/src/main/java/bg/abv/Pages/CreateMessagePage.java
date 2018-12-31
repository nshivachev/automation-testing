package bg.abv.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import Helper.BrowserFactory;

public class CreateMessagePage {
	
	WebDriver driver;
	
	//CreateMessagePage Elements
	@FindBy(how=How.XPATH, using=".//*[@id='main']/div/div[4]/div/div[4]/div/div[4]/div/div[2]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[2]/div/input")
	WebElement receiver_field;
	@FindBy(how=How.CSS, using="tr>td.clientField>div>input.gwt-TextBox")
	WebElement theme_field;
	@FindBy(how=How.CLASS_NAME, using="abv-button")
	WebElement send_message_button;
	@FindBy(how=How.CSS, using="html > body")
	WebElement iframeBodyElement;
	@FindBy(how=How.CLASS_NAME, using="gwt-RichTextArea")
	WebElement iframeTextAreaElement;
	@FindBy(how=How.CSS, using="line-Bottom")
	WebElement noThemeTextBox;
	@FindBy(how=How.XPATH, using="//div[text()='Потвърди']")
	WebElement submit_button;
	@FindBy(how=How.XPATH, using="//div[text()='Затвори']")
	WebElement close_button;
	@FindBy(how=How.XPATH, using="//div[text()='Прикачи от Dox']")
	WebElement attach_button;
	@FindBy(how=How.CLASS_NAME, using="GK-NLG3BLW")
	WebElement wrong_mail_warning;
	
	//Constructor
	public CreateMessagePage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	//Send valid message - receiver, theme, content and assert via SuccessSentPage
	public void createMessage(String mail, String theme, String content)
	{
		//Wait page loading until send_message_button become clickable
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(send_message_button));
		receiver_field.sendKeys(mail);
		theme_field.sendKeys(theme);
		driver.switchTo().frame(iframeTextAreaElement);
		iframeBodyElement.sendKeys("");
		iframeBodyElement.sendKeys(content);
		driver.switchTo().defaultContent();
		send_message_button.click();
		SuccessSentPage successSending = PageFactory.initElements(driver, SuccessSentPage.class);
		successSending.verifySending();
	}
	
	//Send valid message - two receivers, theme, content and assert via SuccessSentPage
	public void createMultipleMessages(String mail_first, String mail_second, String theme, String content) 
	{
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(send_message_button));
		receiver_field.sendKeys(mail_first+","+mail_second);
		theme_field.sendKeys(theme);
		driver.switchTo().frame(iframeTextAreaElement);
		iframeBodyElement.sendKeys(content);
		driver.switchTo().defaultContent();
		send_message_button.click();
		SuccessSentPage successSending = PageFactory.initElements(driver, SuccessSentPage.class);
		successSending.verifySending();
	}
	
	//Send message missing theme and assert via SuccessSentPage
	public void createMessageNoTheme(String mail) 
	{
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(send_message_button));
		receiver_field.sendKeys(mail);
		send_message_button.click();
		// click on the element to focus
		new Actions(driver).moveToElement(submit_button).click().perform();
		SuccessSentPage successSending = PageFactory.initElements(driver, SuccessSentPage.class);
		successSending.verifySending();
	}
	
	//Create invalid message missing receiver and assert warning appearing
	public void createMessageNoReceiver() 
	{
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(send_message_button));
		send_message_button.click();
		Assert.assertTrue(close_button.isDisplayed());
	}
	
	//Create invalid message wrong receiver email and assert warning appearing
	public void createMessageWrongReceiver()
	{
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(send_message_button));
		receiver_field.sendKeys("mail_receiving_testabv.bg");
		theme_field.click();
		Assert.assertTrue(wrong_mail_warning.isDisplayed());
	}
	
	
	
	
			

}
