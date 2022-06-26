package com.tenpearls.testcases;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tenpearls.listeners.AllureListener;
import com.tenpearls.pageobjects.HomePage;
import com.tenpearls.pageobjects.Signup;
import com.tenpearls.setup.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({AllureListener.class})
public class SignupTestCases extends TestBase {

    HomePage homepage;
    Signup signup;


    public SignupTestCases(){
        super();
    }

    @BeforeTest
    public void setUp() throws IOException {
        initialization();
        signup = new Signup();
        homepage = new HomePage();
        signup = homepage.SignupPage();
    }
  @Test(priority = 1)
  public void verifyPageTitle(){
      signup.verifyPageTitlee();

  }
    
  @Test(priority = 2)
  @Severity(SeverityLevel.CRITICAL)
  public void invalidInputs() throws IOException{
      signup.signupDetail();

  }
  
//  @AfterClass
//  public void tearDown(){
//	  driver.close();
//  }
}

