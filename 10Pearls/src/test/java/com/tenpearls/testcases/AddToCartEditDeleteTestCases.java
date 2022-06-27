package com.tenpearls.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tenpearls.listeners.AllureListener;
import com.tenpearls.pageobjects.AddToCartEditDelete;
import com.tenpearls.pageobjects.HomePage;
import com.tenpearls.pageobjects.Signup;
import com.tenpearls.setup.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({AllureListener.class})
public class AddToCartEditDeleteTestCases extends TestBase {

    HomePage homepage;
    Signup signup;
    AddToCartEditDelete cart;


    public AddToCartEditDeleteTestCases(){
        super();
    }

    @BeforeTest
    public void setUp() throws IOException {
        initialization();
        cart = new AddToCartEditDelete();
        signup = new Signup();
        homepage = new HomePage();
        signup = homepage.SignupPage();
        cart = signup.signupDetail();
    }
  @Test(priority = 1)
  public void verifyPageTitle(){
      cart.verifyPageTitlee();

  }
    
  @Test(priority = 2)
  @Severity(SeverityLevel.CRITICAL)
  public void invalidInputs() throws InterruptedException{
      cart.productSelection();

  }
  
  
  @AfterClass
  public void tearDown(){
	  driver.close();
  }
}

