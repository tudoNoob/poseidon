package com.poseidon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class UserJourney {

    public static final String USER_LOGIN = "user";
    public static final String USER_PASSWORD = "user";
    private WebDriver webDriver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws Exception {
        final String chrome_driver = System.getenv("CHROME_DRIVER");
        System.out.println(chrome_driver);
        System.setProperty("webdriver.chrome.driver",chrome_driver);
        webDriver = new ChromeDriver();
        //webDriver = new HtmlUnitDriver();
        wait = new WebDriverWait(webDriver, 10);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriver.quit();
    }

    @Test
    public void shouldLoginWithAdminUser() throws Exception {
        webDriver.get("http://localhost:8080");
        WebElement loginInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user.login")));
        loginInput.sendKeys(USER_LOGIN);
        webDriver.findElement(By.id("password.login")).sendKeys(USER_PASSWORD);
        webDriver.findElement(By.id("submit.login")).click();
        String welcomeToPoseidon = webDriver.findElement(By.id("welcome-text")).getText();
        assertThat(welcomeToPoseidon,notNullValue());
    }

    @Test
    public void shouldRegistryPacient() throws Exception {
        webDriver.get("http://localhost:8080");
        wait = new WebDriverWait(webDriver, 10);
        WebElement pacientTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paciente-dropdown")));
        pacientTab.click();

        WebElement pacienteCadastro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-criarPaciente")));
        pacienteCadastro.click();
    }
}