package bg.abv.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import bg.abv.Pages.LoginPage;
import bg.abv.Pages.MainPage;

public class MultipleReceiversTest {
	
	@Test
	public void checkSendingMultipleReceivers()
	{
		//Launch browser and specific url
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.abv.bg/");
		
		//Create Page Object using Page Factory
		LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
				
		//Call methods
		MainPage main_page = login_page.login_abv("mail_sending_test", "test1234");
		main_page.sendToMultipleReceivers("mail_receiver_test@abv.bg", "mail_receiver2_test@abv.bg", "theme", "content");
	}

}
