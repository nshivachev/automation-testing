package bg.abv.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Helper.BrowserFactory;

public class MainPage {
	
	WebDriver driver;
	
	//MainPage Elements
	@FindBy(how=How.CLASS_NAME, using="abv-button")
	WebElement new_message_button;
	
	//Constructor
	public MainPage(WebDriver ldriver) 
	{
		this.driver = ldriver;
	}
	
	//Click on new_message_button and pass the respective arguments to the CreateMessagePage
	public void sendMessage(String mail, String theme, String content)
	{
		//Wait page loading until new_message_button become clickable
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(new_message_button));
		new_message_button.click();
		CreateMessagePage new_message = PageFactory.initElements(driver, CreateMessagePage.class);
		new_message.createMessage(mail, theme, content);
	}
	
	//Click on new_message_button and pass the respective arguments to the CreateMessagePage
	public void sendToMultipleReceivers(String mail_first, String mail_second, String theme, String content)
	{
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(new_message_button));
		new_message_button.click();
		CreateMessagePage new_message = PageFactory.initElements(driver, CreateMessagePage.class);
		new_message.createMultipleMessages(mail_first, mail_second, theme, content);
	}
	
	//Click on new_message_button and pass the respective arguments to the CreateMessagePage
	public void sendMessageNoTheme(String mail)
	{
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(new_message_button));
		new_message_button.click();
		CreateMessagePage new_message = PageFactory.initElements(driver, CreateMessagePage.class);
		new_message.createMessageNoTheme(mail);
	}
	
	//Click on new_message_button and pass the respective arguments to the CreateMessagePage
	public void sendMessageNoReceiver()
	{
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(new_message_button));
		new_message_button.click();
		CreateMessagePage new_message = PageFactory.initElements(driver, CreateMessagePage.class);
		new_message.createMessageNoReceiver();		
	}
	
	//Click on new_message_button and pass the respective arguments to the CreateMessagePage
	public void sendMessageWrongReceiver()
	{
		BrowserFactory.waitForElement.until(ExpectedConditions.elementToBeClickable(new_message_button));
		new_message_button.click();
		CreateMessagePage new_message = PageFactory.initElements(driver, CreateMessagePage.class);
		new_message.createMessageWrongReceiver();
	}
		
	

}
