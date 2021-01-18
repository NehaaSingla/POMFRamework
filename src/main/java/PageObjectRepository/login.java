package PageObjectRepository;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {
	
	WebDriver driver;
	
	public login(WebDriver driver){ //encapsulation
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//Capturing xpaths
	@FindBy(xpath = "//span[contains(text(),'sign in')]")
	private WebElement SignInButton;
	
	public void getSignInButton() {
		try {
			click(SignInButton);
			pause(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}	
	
	public void click(WebElement elementToBeClicked){
	    WebDriverWait wait = new WebDriverWait(driver, 3000);
	    wait.until(ExpectedConditions.visibilityOf(elementToBeClicked));
	    wait.until(ExpectedConditions.elementToBeClickable(elementToBeClicked)); 
	    wait.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class); elementToBeClicked.click(); 
	 }
	
	public void pause(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	@FindBy(xpath = "//div//following-sibling::input[@name='login']")
	private WebElement UserName;
	
	public void setUserName(String strUserName) {
		try {
			UserName.sendKeys(strUserName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new AssertionError("UserName not entered", e);
		}
	}

	
	@FindBy(xpath = "//div//following-sibling::input[@placeholder='Password']")
	private WebElement Password;
	
	public void setPassword(String strPassword) {
		try {
			Password.sendKeys(strPassword);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new AssertionError("Password not entered", e);
		}	
	}
	
	@FindBy(xpath = "//div//following-sibling::input[@value='Sign In']")
	private WebElement LoginButton;
	
	public void getLoginButton() {
		try {
			LoginButton.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void getTitle() {
		try {
			driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public void TearDown() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'×')]")
	private WebElement toastCloseButton;
	
	public void gettoastCloseButton() {
		if(toastCloseButton.isDisplayed())
		{
			toastCloseButton.click();
		}else
			{
				System.out.println("No toastCloseButton is present");
			}
		}
	

}
