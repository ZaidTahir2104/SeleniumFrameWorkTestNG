package com.tenpearls.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.DataProvider;

import com.tenpearls.utalities.WaitUtils;
import com.tenpearls.utalities.XLUtils;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com" +
                    "/tenpearls/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
//        if (browserName.equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/chromedriver/chromedriver"));
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--lang= locale-of-choice");
//            driver = new ChromeDriver(options);
//
//        }
       
            System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir")+"/chromedriver/geckodriver"));
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--lang= locale-of-choice");
            driver = new FirefoxDriver(options);



        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.get("chrome://settings/clearBrowserData");
//        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().pageLoadTimeout(WaitUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WaitUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
    public static WebDriver getDriver() {

        return driver;
    }
}

