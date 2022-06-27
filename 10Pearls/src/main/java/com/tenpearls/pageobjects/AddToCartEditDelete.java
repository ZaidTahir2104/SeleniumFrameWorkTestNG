package com.tenpearls.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.tenpearls.setup.TestBase;
import io.qameta.allure.Step;

public class AddToCartEditDelete extends TestBase {
	@FindBy(css = ".page-heading")
    WebElement pageHeading;
    @FindBy(css = "a[title='T-shirts']")
    WebElement tshirts;
    @FindBy(css = "a[title='Women']")
    WebElement women;
    @FindBy(css = "[title='View']")
    WebElement more;
    @FindBy(css = ".icon-plus")
    WebElement plusicon;
    @FindBy(css = "#quantity_wanted")
    WebElement quantity;
    @FindBy(css = "#group_1")
    WebElement size;
    @FindBy(css = "#color_13")
    WebElement orange;
    @FindBy(css = "#color_14")
    WebElement blue;
    @FindBy(css = "button[name='Submit'] span")
    WebElement addtocart;
    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement successMsg;
    @FindBy(css = "a[title='Proceed to checkout'] span")
    WebElement checkout;
    @FindBy(css = ".icon-trash")
    WebElement delete;
    @FindBy(css = "img[title='Faded Short Sleeve T-shirts']")
    WebElement tshirt;
    @FindBy(css = "td[class='cart_description'] p[class='product-name']")
    WebElement product;
    @FindBy(css = "#alias")
    WebElement alias;
    @FindBy(css = "button[id='submitAccount'] span")
    WebElement register;
    WebDriverWait wait=new WebDriverWait(driver,30);
    
    public AddToCartEditDelete() {
        super();
        PageFactory.initElements(driver, this);

    }
    //Verify Title
	@Step(" User will hit the url : Vereify Title of the page  ")
    public void verifyPageTitlee() {
		wait.until(ExpectedConditions.visibilityOf(women));
		Assert.assertEquals(driver.getTitle(), "My account - My Store"); 
    }
    public void productSelection() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement menuOption = women;
		actions.moveToElement(menuOption).perform();
		wait.until(ExpectedConditions.visibilityOf(tshirts));
		tshirts.click();
		WebElement tshirtselection = tshirt;
		actions.moveToElement(tshirtselection).perform();
		more.click();
		addingProduct("2","L","b");
		EditProduct();
		delete.click();
    }
    public void addingProduct( String quantityy, String sizee,String color) {
    	quantity.clear();
    	quantity.sendKeys(quantityy);
		size.sendKeys(sizee);
		if(color=="b") {
			blue.click();
		}
		else if(color=="o") {
			orange.click();
		}
		addtocart.click();
		wait.until(ExpectedConditions.visibilityOf(checkout));
		Assert.assertEquals(successMsg.getText(), "Product successfully added to your shopping cart");
		checkout.click();
    }
    public void EditProduct() {
    	product.click();
    	addingProduct("3","M","o");
    	delete.click();
    }
}

