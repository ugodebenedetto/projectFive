package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class InserisciTirocinioBoundary {
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
  public void testInserisciTirocinioBoundary() throws Exception {
    driver.get(baseUrl
        + "/IsProjectClaudio/it.tirociniosmart.view.tutorAccademico/home_tutor_accademico.jsp");
    driver
        .findElement(
            By.xpath("//a[contains(text(),'I MIEI\n									TIROCINI')]"))
        .click();
    driver.findElement(By.linkText("Aggiungi Tirocinio")).click();
    driver.findElement(By.id("nam")).clear();
    driver.findElement(By.id("nam")).sendKeys("a");
    driver.findElement(By.id("obi")).clear();
    driver.findElement(By.id("obi")).sendKeys("a");
    driver.findElement(By.id("des")).clear();
    driver.findElement(By.id("des")).sendKeys("a");
    driver.findElement(By.name("Tipo")).clear();
    driver.findElement(By.name("Tipo")).sendKeys("a");
    driver.findElement(By.id("sed")).clear();
    driver.findElement(By.id("sed")).sendKeys("a");
    driver.findElement(By.id("res")).clear();
    driver.findElement(By.id("res")).sendKeys("a");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("nam")).clear();
    driver.findElement(By.id("nam")).sendKeys("ad");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("nam")).clear();
    driver.findElement(By.id("nam")).sendKeys("Cinque");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("obi")).clear();
    driver.findElement(By.id("obi")).sendKeys("Quindici caratteri da inserire");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("des")).clear();
    driver.findElement(By.id("des")).sendKeys("Altri quindici caratteri");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.name("Tipo")).clear();
    driver.findElement(By.name("Tipo")).sendKeys("Tre");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("sed")).clear();
    driver.findElement(By.id("sed")).sendKeys("T3e");
    driver.findElement(By.id("submitRegistration")).click();
    driver.findElement(By.id("sed")).clear();
    driver.findElement(By.id("sed")).sendKeys("TRE");
    driver.findElement(By.id("num")).clear();
    driver.findElement(By.id("num")).sendKeys("50");
    driver.findElement(By.id("res")).clear();
    driver.findElement(By.id("res")).sendKeys("TRE");
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
