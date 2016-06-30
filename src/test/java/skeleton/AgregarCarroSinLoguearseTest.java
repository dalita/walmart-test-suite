package skeleton;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AgregarCarroSinLoguearseTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://interdico.net/";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testAgregarCarroSinLoguearse() throws Exception {
    driver.get("https://10.0.159.33/GM/category/_/N-wvk0ae");
   
    /**comprobar que entro a la pagina deseada*/
    boolean present = false;
    String pageName = driver.getTitle();
    if(pageName.equals("Gmail: Email from Google")){
        present = true;
    } 
    Assert.assertTrue( "No entrada la pagina principal",present);
    /*fin de combrobar que entro a la pagina deseada*/
    
    driver.findElement(By.cssSelector("div.submenu > ul > li > a")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Televisores')])[2]")).click();
    driver.findElement(By.xpath("//div[@id='productBox[1012798]']/a/div[2]/p")).click();
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
