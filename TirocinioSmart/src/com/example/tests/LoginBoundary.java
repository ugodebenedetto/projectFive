package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginBoundary {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/IsProjectClaudio/index.jsp";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginBoundary() throws Exception {
    driver.get(baseUrl + "/IsProjectClaudio/it.tirociniosmart.view.utente/login.jsp");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("claudiooooo");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("");
    driver.findElement(By.id("submitLogin")).click();
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("f");
    driver.findElement(By.id("submitLogin")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("d");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("");
    driver.findElement(By.id("submitLogin")).click();
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("d");
    driver.findElement(By.id("submitLogin")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("amatoclaudio");
    driver.findElement(By.id("submitLogin")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("amatoclaudio");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("aaaaa");
    driver.findElement(By.id("submitLogin")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
