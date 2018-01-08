package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AvviaTirocinio {
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
  public void testAvviaTirocinio() throws Exception {
    driver.get(baseUrl + "/IsProjectClaudio/it.tirociniosmart.view.didattica/home_didattica.jsp");
    driver
        .findElement(
            By.xpath("//a[contains(text(),'LISTA\n									STUDENTI')]"))
        .click();
    driver.findElement(By.linkText("VISUALIZZA")).click();
    driver.findElement(By.id("inputFile")).clear();
    driver.findElement(By.id("inputFile"))
        .sendKeys("C:\\Users\\Claudio\\Desktop\\progettoFormativo.pdf");
    driver.findElement(By.id("submitUpload")).click();
    driver
        .findElement(
            By.xpath("//a[contains(text(),'LISTA\n									STUDENTI')]"))
        .click();
    driver.findElement(By.linkText("VISUALIZZA")).click();
    driver.findElement(By.name("file2")).clear();
    driver.findElement(By.name("file2")).sendKeys("C:\\Users\\Claudio\\Desktop\\RegistroOre.pdf");
    driver.findElement(By.id("submitUpload")).click();
    driver
        .findElement(
            By.xpath("//a[contains(text(),'LISTA\n									STUDENTI')]"))
        .click();
    driver.findElement(By.linkText("VISUALIZZA")).click();
    driver.findElement(By.name("file3")).clear();
    driver.findElement(By.name("file3")).sendKeys("C:\\Users\\Claudio\\Desktop\\Valutazione.pdf");
    driver.findElement(By.id("submitUpload")).click();
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
