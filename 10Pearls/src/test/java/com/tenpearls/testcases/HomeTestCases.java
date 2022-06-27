package com.tenpearls.testcases;


import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tenpearls.listeners.AllureListener;
import com.tenpearls.pageobjects.HomePage;
import com.tenpearls.setup.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListener.class})
public class HomeTestCases extends TestBase {

    HomePage homepage;


    public HomeTestCases(){
        super();
    }

    @BeforeTest
    public void setUp() {
        initialization();
        homepage = new HomePage();
    }
  @Test(priority = 1)
  public void verifyTitlePage(){
      homepage.verifyTitle();

  }
  @Test(priority = 2)
  @Severity(SeverityLevel.MINOR)
  public void signUpPage() throws IOException, InterruptedException{
      homepage.SignupPage();

  }
  

  
//  @AfterClass
//  public void tearDown(){
//	  driver.close();
//  }
}

