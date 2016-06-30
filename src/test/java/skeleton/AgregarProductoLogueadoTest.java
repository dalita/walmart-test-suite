package skeleton;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AgregarProductoLogueadoTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://interdico.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAgregarProductoLogueado() throws Exception {
    driver.get("https://10.0.159.33/GM/");
    driver.findElement(By.xpath("//section[@id='header']/header/div/div[2]/div[2]/div/div/div/span")).click();
    driver.findElement(By.id("quickloginusernameinput")).clear();
    driver.findElement(By.id("quickloginusernameinput")).sendKeys("dalitagh@gmail.com");
    driver.findElement(By.id("quickloginpasswordinput")).clear();
    driver.findElement(By.id("quickloginpasswordinput")).sendKeys("nascarteam1");
    driver.findElement(By.id("loginsubmitbutton")).click();
    driver.findElement(By.cssSelector("li.js-trigger-dptos.active > span")).click();
    driver.findElement(By.cssSelector("div.submenu > ul > li > a")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Televisores')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='productBox[1962741]']/a/div[2]/p")).click();
    driver.findElement(By.id("add-button")).click();
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
