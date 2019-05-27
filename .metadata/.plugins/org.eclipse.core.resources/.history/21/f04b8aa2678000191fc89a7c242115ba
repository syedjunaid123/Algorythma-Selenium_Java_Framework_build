package pages_com.saal.challenge;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenClothing_Page {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	
	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
	WebElement selected_dress;
	
	@FindBy(name="Submit")
	WebElement btn_submit;
	
	@FindBy(xpath="//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
	WebElement btn_proceed_checkout;
	
	
	public WomenClothing_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 20, 50);		
	}

	public void select_dress() {
		this.wait.until(ExpectedConditions.visibilityOf(selected_dress)).click();		
	}
	
	public void select_view_dress() {
		this.wait.until(ExpectedConditions.visibilityOf(selected_dress)).click();		
	}
			
	public void click_btn_submit() {
		this.wait.until(ExpectedConditions.visibilityOf(btn_submit)).click();
	}
	
	public void click_btn_proceed_checkout() {
		this.wait.until(ExpectedConditions.visibilityOf(btn_proceed_checkout)).click();
	}
}
	
	
