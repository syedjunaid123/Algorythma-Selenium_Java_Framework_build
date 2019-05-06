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

public class SignIn_Page {
	WebDriver driver = null;
	WebDriverWait wait = null;
	
	@FindBy(className="login")
	WebElement signInButton;
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public SignIn_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 20, 50);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(this.driver, 50);

		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(projectPath+"/DataSheet.xlsx");
			sheet = workbook.getSheetAt(0);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public void appln_url() {
		driver.get(sheet.getRow(24).getCell(1).getStringCellValue());
	}
	public void signin() {
		this.wait.until(ExpectedConditions.visibilityOf(signInButton)).click();		
	}
}
