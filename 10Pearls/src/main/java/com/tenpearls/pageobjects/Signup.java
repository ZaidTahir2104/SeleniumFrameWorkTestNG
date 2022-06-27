package com.tenpearls.pageobjects;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.tenpearls.setup.TestBase;
import io.qameta.allure.Step;

public class Signup extends TestBase {

	private  XSSFWorkbook workbook;
	private XSSFSheet sheet;
	@FindBy(css = "#uniform-id_gender1")
	WebElement gender;
	@FindBy(css = "#customer_firstname")
	WebElement fName;
	@FindBy(css = "#customer_lastname")
	WebElement lName;
	@FindBy(css = "#passwd")
	WebElement password;
	@FindBy(css = "#days")
	WebElement days;
	@FindBy(css = "[value='21']")
	WebElement daysvalue;
	@FindBy(css = "#months")
	WebElement months;
	@FindBy(xpath = ".//*[text()[contains(.,\"April\")]]")
	WebElement monthsvalue;
	@FindBy(css = "#years")
	WebElement years;
	@FindBy(xpath = ".//*[text()[contains(.,\"1993\")]]")
	WebElement yearsvalue;
	@FindBy(css = "#address1")
	WebElement address1;
	@FindBy(css = "#city")
	WebElement city;
	@FindBy(css = "#id_state")
	WebElement state;
	@FindBy(css = "#postcode")
	WebElement postcode;
	@FindBy(css = "#phone_mobile")
	WebElement phone_mobile;
	@FindBy(css = "#alias")
	WebElement alias;
	@FindBy(css = "button[id='submitAccount'] span")
	WebElement register;

	@FindBy(xpath = "//li[normalize-space()='You must register at least one phone number.']")
	WebElement phonenumberrequired;
	@FindBy(xpath = "//b[normalize-space()='lastname']")
	WebElement lnamerequired;
	@FindBy(xpath = "//b[normalize-space()='firstname']")
	WebElement fnamerequired;
	@FindBy(xpath = "//b[normalize-space()='passwd']")
	WebElement passwdrequired;
	@FindBy(xpath = ".//*[text()[contains(.,\"The Zip/Postal code you've entered is invalid. It must follow this format: 00000\")]]")
	WebElement zipcoderequired;
	@FindBy(xpath = "//li[normalize-space()='This country requires you to choose a State.']")
	WebElement staterequired;
	@FindBy(xpath = "//b[normalize-space()='city']")
	WebElement cityrequired;
	@FindBy(css = "//b[normalize-space()='address1']")
	WebElement address1required;
	
	

	public Signup() {
		super();
		PageFactory.initElements(driver, this);

	}
	//Verify Title
	@Step(" User will hit the url : Vereify Title of the page  ")
	public void verifyPageTitlee() {
		Assert.assertEquals(driver.getTitle(), "Login - My Store"); 
	}
	//Redirect to Login/Signup Page 
	public AddToCartEditDelete signupDetail() throws IOException {
		register.click();
		isPresent(phonenumberrequired);
		isPresent(lnamerequired);
		isPresent(fnamerequired);
		isPresent(passwdrequired);
		isPresent(zipcoderequired);
		isPresent(staterequired);
		isPresent(cityrequired);
		isPresent(address1required);
		gender.click();
		File file = new File(System.getProperty("user.dir")+"/src/main/java/com/tenpearls/utalities/TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(1);
		fName.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		lName.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		password.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		days.click();
		daysvalue.click();
		months.click();
		monthsvalue.click();
		years.click();
		yearsvalue.click();
		address1.sendKeys(sheet.getRow(1).getCell(6).getStringCellValue());
		city.sendKeys(sheet.getRow(1).getCell(7).getStringCellValue());
		state.sendKeys(sheet.getRow(1).getCell(8).getStringCellValue());
		postcode.sendKeys(sheet.getRow(1).getCell(9).getStringCellValue());
		phone_mobile.sendKeys(sheet.getRow(1).getCell(10).getStringCellValue());
		alias.clear();
		alias.sendKeys(sheet.getRow(1).getCell(11).getStringCellValue());
		register.click();
		return new AddToCartEditDelete();
	}
	public boolean isPresent(WebElement ele) {
	    boolean flag = true;
	    try {
	        ele.isDisplayed();
	        System.out.println("Required Fields is "+ele.getText());
	        flag = true;
	    }
	    catch (Exception e) {
	        flag = false;
	    }
	    return flag;
	}
}

