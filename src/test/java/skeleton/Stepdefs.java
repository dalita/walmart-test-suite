package skeleton;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class Stepdefs {

    public static WebDriver driver;


    /*autenticarse gmail*/

    @Given("^Dado la pagina de login de gmail$")
    public void dado_la_pagina_de_login_de_gmail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.google.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(1000);
/*        driver.findElement(By.xpath("/*//*[@id=\"account-menu\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(" /*//*[@id=\"login\"]")).click();
        throw new PendingException();*/
    }

    @When("^Cuando el usuario introduce : usuario  \"([^\"]*)\"$")
    public void cuando_el_usuario_introduce_usuario(String arg1) throws Throwable {

//        fnHighlightMe(driver,userElement);
        WebElement userEl = driver.findElement(By.xpath(" //*[@id=\"Email\"]"));
//        fnHighlightMe(driver,passElement);
        userEl.sendKeys(arg1);


    }

    @When("^Usuario presiona boton siguiente$")
    public void usuario_presiona_boton_siguiente() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(" //*[@id=\"next\"]")).click();
        Thread.sleep(1000);
    }

    @When("^Usuario introduce: contrasena \"([^\"]*)\"$")
    public void usuario_introduce_contrasena(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement passEl = driver.findElement(By.xpath(" //*[@id=\"Passwd\"]"));
        passEl.sendKeys(arg1);
    }

    @When("^Usuario clickea boton login$")
    public void usuario_clickea_boton_login() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath(" //*[@id=\"signIn\"]")).click();
        Thread.sleep(1000);
    }

    @Then("^El sistema debe mostrar la lista de correos del usuario$")
    public void el_sistema_debe_mostrar_la_lista_de_correos_del_usuario() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
   /*     WebElement email = driver.findElement(By.xpath("#\\:2w"));
     /*  if(!email.getText().equalsIgnoreCase("valenredevil@gmail.com"))
           throw new Exception("Mala autenticacion");
        */
      //  System.out.println(email.getText());

    }


    //autenticarse facebook

    @Given("^Dado la pagina de login de facebook$")
    public void dado_la_pagina_de_login_de_facebook() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Thread.sleep(1000);
    }

    @When("^Cuando el usuario introduce : user  \"([^\"]*)\"$")
    public void cuando_el_usuario_introduce_usuario_faceb(String arg1) throws Throwable {

        // Write code here that turns the phrase above into concrete actions
        WebElement userElement = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        userElement.sendKeys(arg1);
        //        fnHighlightMe(driver,userElement);
    }
    @And("^Cuando el user introduce : contrasena \"([^\"]*)\"$")
    public void cuando_el_usuario_introduce_pwd_faceb(String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement passElement = driver.findElement(By.xpath(" //*[@id=\"pass\"]"));
//        fnHighlightMe(driver,passElement);
        passElement.sendKeys(arg2);
        Thread.sleep(1000);
        //comentario
    }


    @And("^Usuario clickea boton entrar$")
    public void usuarioClickeaBotonEntrar() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"u_0_m\"]")).click();
    }


    @Then("^El sistema debe mostrar el muro del usuario$")
    public void el_sistema_debe_mostrar_el_muro_del_usuario() throws Throwable {

    }
}