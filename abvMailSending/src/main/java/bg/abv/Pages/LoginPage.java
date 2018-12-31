package bg.abv.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//LoginPage Elements
	@FindBy(how=How.ID, using="username")
	WebElement username;
	@FindBy(how=How.ID, using="password")
	WebElement password;
	@FindBy(how=How.ID, using="loginBut")
	WebElement login_button;
	
	//Constructor
	public LoginPage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	
	//Login and return MainPage
	public MainPage login_abv(String uid, String pass)
	{
		username.sendKeys(uid);
		password.sendKeys(pass);
		login_button.click();
		return PageFactory.initElements(driver, MainPage.class);
	}
		
 
}
