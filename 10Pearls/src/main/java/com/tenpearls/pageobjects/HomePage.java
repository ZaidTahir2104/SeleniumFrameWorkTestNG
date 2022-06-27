package com.tenpearls.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.tenpearls.setup.TestBase;
import io.qameta.allure.Step;

public class HomePage extends TestBase {

	private  XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFCell cell ;
	int i = new Random().nextInt(10000);
	@FindBy(css = "a[title='Log in to your customer account']")
	WebElement signinOption;
	@FindBy(css = "#email_create")
	WebElement email_create;
	@FindBy(css = "button[id='SubmitCreate'] span")
	WebElement creatAccount;
	@FindBy(xpath = "//li[contains(text(),'An account using this email address has already be')]")
	WebElement alreadyAccount;
	
	public HomePage() {
		//super();
		PageFactory.initElements(driver, this);

	}
	WebDriverWait wait=new WebDriverWait(driver,30);
	//Verify Title
	@Step(" User will hit the url : Vereify Title of the page  ")
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "My Store");  
	}
	public Signup SignupPage() throws IOException {



		signinOption.click();
		wait.until(ExpectedConditions.visibilityOf(creatAccount));
		File file = new File(System.getProperty("user.dir")+"/src/main/java/com/tenpearls/utalities/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		System.out.print("sheet size is "+sheet.getLastRowNum());
		email_create.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		creatAccount.click();
		return new Signup();

	}
}

