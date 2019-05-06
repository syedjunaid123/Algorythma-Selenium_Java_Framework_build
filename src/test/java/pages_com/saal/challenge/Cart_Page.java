package pages_com.saal.challenge;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart_Page {

	WebDriver driver = null;
	WebDriverWait wait = null;
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	@FindBy(xpath="//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
	WebElement btn_proceed_checkout;

	@FindBy(name="processAddress")
	WebElement btn_process_address;

	@FindBy(id="uniform-cgv")
	WebElement chk_terms;

	@FindBy(name="processCarrier")
	WebElement btn_process_shipping;

	@FindBy(className="bankwire")
	WebElement btn_pay_by_bank_wire;

	@FindBy(xpath="//*[@id='cart_navigation']/button")
	WebElement btn_confirm_order;

	@FindBy(css="h1")
	WebElement heading;

	@FindBy(xpath="//li[@class='step_done step_done_last four']")
	WebElement shipping_step4;

	@FindBy(xpath="//li[@id='step_end' and @class='step_current last']")
	WebElement confirmation_step_end;
	
	@FindBy(xpath="//*[@class='cheque-indent']/strong")
	WebElement txt_order_confirm;
	
	public Cart_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 20, 50);
		
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/DataSheet.xlsx");
			sheet = workbook.getSheetAt(0);

		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	public void click_proceed_checkout() {
		this.wait.until(ExpectedConditions.visibilityOf(btn_proceed_checkout)).click();
	}

	public void click_process_address() {
		this.wait.until(ExpectedConditions.visibilityOf(btn_process_address)).click();
	}

	public void chk_terms_conditions() {
		this.wait.until(ExpectedConditions.visibilityOf(chk_terms)).click();
	}

	public void click_process_shipping() {
		btn_process_shipping.click();
	}

	public void click_btn_pay_by_bank_wire() {
		this.wait.until(ExpectedConditions.visibilityOf(btn_pay_by_bank_wire)).click();
	}

	public void click_btn_confirm_order() {
		this.wait.until(ExpectedConditions.visibilityOf(btn_confirm_order)).click();
	}

	public String get_heading_label() {
		String lbl_heading = this.wait.until(ExpectedConditions.visibilityOf(heading)).getText();
		return lbl_heading;
	}	
	public boolean is_disp_shipping_step4() {
		return shipping_step4.isDisplayed();			
	}
	
	public boolean is_disp_conformation_step_end() {
		return confirmation_step_end.isDisplayed();			
	}
	
	public String lbl_order_confirmation() {
			return sheet.getRow(17).getCell(1).getStringCellValue();
	}
	
	public String get_txt_order_confirmation() {
		String txt_order_confirmation = this.wait.until(ExpectedConditions.visibilityOf(txt_order_confirm)).getText();
		return txt_order_confirmation;
	}
	
	public String lbl_txt_order_confirmation() {
			return sheet.getRow(18).getCell(1).getStringCellValue();
	}
	
	public boolean order_confirmation_in_url() {
			String url_contains = sheet.getRow(19).getCell(1).getStringCellValue();
			return driver.getCurrentUrl().contains(url_contains);
	}		
}
