package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrazioneBoundary {
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
  public void testRegistrazioneBoundary() throws Exception {
    driver.get(baseUrl + "/IsProjectClaudio/it.tirociniosmart.view.utente/registrazione.jsp");
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("d");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("d");
    driver.findElement(By.name("matricola")).clear();
    driver.findElement(By.name("matricola")).sendKeys("d");
    new Select(driver.findElement(By.name("tipoLaurea"))).selectByVisibleText("Triennale");
    driver.findElement(By.id("emailS")).clear();
    driver.findElement(By.id("emailS")).sendKeys("a");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("a");
    driver.findElement(By.name("confermaPassword")).clear();
    driver.findElement(By.name("confermaPassword")).sendKeys("a");
    driver.findElement(By.name("codiceFiscale")).clear();
    driver.findElement(By.name("codiceFiscale")).sendKeys("2");
    driver.findElement(By.name("luogoNascita")).clear();
    driver.findElement(By.name("luogoNascita")).sendKeys("a");
    driver.findElement(By.id("dataS")).clear();
    driver.findElement(By.id("dataS")).sendKeys("12/12/1996");
    driver.findElement(By.id("F")).click();
    driver.findElement(By.name("residenza")).clear();
    driver.findElement(By.name("residenza")).sendKeys("c");
    driver.findElement(By.name("via")).clear();
    driver.findElement(By.name("via")).sendKeys("c");
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("c");
    driver.findElement(By.id("trattamento_dati")).click();
    driver.findElement(By.id("120CFU")).click();
    driver.findElement(By.id("legge")).click();
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Claudio");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.cssSelector("label.flat-btn")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Amato");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.name("matricola")).clear();
    driver.findElement(By.name("matricola")).sendKeys("7888888888");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("emailS")).clear();
    driver.findElement(By.id("emailS")).sendKeys("amatoclaudio");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("aaaaa");
    driver.findElement(By.name("confermaPassword")).clear();
    driver.findElement(By.name("confermaPassword")).sendKeys("aaaaa");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.name("codiceFiscale")).clear();
    driver.findElement(By.name("codiceFiscale")).sendKeys("2fffffffffffffff");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.name("via")).clear();
    driver.findElement(By.name("via")).sendKeys("Via fasulla, 125");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("0988888888");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.xpath("(//a[contains(@href, 'login.jsp')])[2]")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("aaaaaaaaaaaa");
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
