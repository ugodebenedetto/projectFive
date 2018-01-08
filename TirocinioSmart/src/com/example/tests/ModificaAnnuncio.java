package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ModificaAnnuncio {
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
  public void testModificaAnnuncio() throws Exception {
    driver.get(baseUrl + "/IsProjectClaudio/it.tirociniosmart.view.didattica/home_didattica.jsp");
    driver.findElement(By.linkText("ANNUNCI")).click();
    driver.findElement(By.cssSelector("div.col-md-4.col-sm-4 > div.wrap-btn > a.flat-btn")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Modifica dell'annuncio");
    driver.findElement(By.id("body")).clear();
    driver.findElement(By.id("body")).sendKeys("Modifica della descrizione dell'annuncio");
    driver.findElement(By.id("inputFile")).clear();
    driver.findElement(By.id("inputFile")).sendKeys(
        "C:\\Users\\Claudio\\Documents\\Documenti\\Universita\\III\\IS\\1 - 00.intro-corsoIS.pdf");
    driver.findElement(By.id("submit")).click();
    driver.findElement(By.linkText("Vai Alla HOMEPAGE")).click();
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
