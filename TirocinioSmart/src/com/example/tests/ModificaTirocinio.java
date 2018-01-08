package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ModificaTirocinio {
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
  public void testModificaTirocinio() throws Exception {
    driver.get(
        baseUrl + "/IsProjectClaudio/it.tirociniosmart.view.tutorAccademico/i_miei_tirocini.jsp");
    driver.findElement(By.linkText("Modifica")).click();
    driver.findElement(By.id("nam")).clear();
    driver.findElement(By.id("nam")).sendKeys("Modifica del nome del tirocino");
    driver.findElement(By.id("obi")).clear();
    driver.findElement(By.id("obi")).sendKeys("Modifica dell'obiettivo del tirocino");
    driver.findElement(By.id("des")).clear();
    driver.findElement(By.id("des")).sendKeys("Modifica della descrizione del tirocino");
    driver.findElement(By.name("Tipo")).clear();
    driver.findElement(By.name("Tipo")).sendKeys("Modifica del tipo di tirocinio");
    driver.findElement(By.id("sed")).clear();
    driver.findElement(By.id("sed")).sendKeys("Modifica sede del tirocinio");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("15");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("14");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("13");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("12");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("11");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("10");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("9");
    driver.findElement(By.id("res")).clear();
    driver.findElement(By.id("res")).sendKeys("Modifica responsabile");
    driver.findElement(By.id("submitRegistration")).click();
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
