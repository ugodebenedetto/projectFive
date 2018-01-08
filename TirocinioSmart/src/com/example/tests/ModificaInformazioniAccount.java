package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ModificaInformazioniAccount {
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
  public void testModificaInformazioniAccount() throws Exception {
    driver.get(baseUrl
        + "/IsProjectClaudio/it.tirociniosmart.view.studente/modifica_account_studente.jsp");
    driver.findElement(By.cssSelector("div.btn-menu")).click();
    driver
        .findElement(
            By.xpath("//a[contains(text(),'IL MIO\n									PROFILO')]"))
        .click();
    driver.findElement(By.id("idModificaInformazioni")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Maria");
    driver.findElement(By.name("cognome")).clear();
    driver.findElement(By.name("cognome")).sendKeys("Rossi");
    driver.findElement(By.name("codiceFiscale")).clear();
    driver.findElement(By.name("codiceFiscale")).sendKeys("MTACLD96S16A4444");
    driver.findElement(By.name("luogoNascita")).clear();
    driver.findElement(By.name("luogoNascita")).sendKeys("Salerno");
    driver.findElement(By.id("F")).click();
    driver.findElement(By.name("residenza")).clear();
    driver.findElement(By.name("residenza")).sendKeys("Cancello");
    driver.findElement(By.name("via")).clear();
    driver.findElement(By.name("via")).sendKeys("Via Cancello, 125");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("3333333344");
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
