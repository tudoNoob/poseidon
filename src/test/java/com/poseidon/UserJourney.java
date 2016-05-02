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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertTrue;

public class UserJourney {

    public static final String USER_LOGIN = "user";
    public static final String USER_PASSWORD = "user";
    private WebDriver webDriver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() throws Exception {

        final String chrome_driver = System.getenv("CHROME_DRIVER");
        if (chrome_driver != null) {
            System.setProperty("webdriver.chrome.driver", chrome_driver);
            webDriver = new ChromeDriver();
        } else {
            webDriver = new HtmlUnitDriver();
        }
        wait = new WebDriverWait(webDriver, 10);
        webDriver.get("http://localhost:8080");
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriver.quit();
    }


    @Test
    public void userJourneyFunctionalTest() throws Exception {
        shouldLoginWithAdminUser();
        shouldExecuteActionIntoDropdownFromPacient("btn-criarPaciente");
        shouldRegistryOnePacient();
        shouldExecuteActionIntoDropdownFromPacient("btn-pesquisarPaciente");
    }

    public void shouldLoginWithAdminUser() throws Exception {
        WebElement loginInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user.login")));
        loginInput.sendKeys(USER_LOGIN);
        webDriver.findElement(By.id("password.login")).sendKeys(USER_PASSWORD);
        webDriver.findElement(By.id("submit.login")).click();
        String welcomeToPoseidon = webDriver.findElement(By.id("welcome-text")).getText();
        assertThat(welcomeToPoseidon, notNullValue());
    }

    public void shouldExecuteActionIntoDropdownFromPacient(String action) throws Exception {
        WebElement pacientTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paciente-dropdown")));
        pacientTab.click();

        WebElement pacienteCadastro = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(action)));
        pacienteCadastro.click();

        assertTrue(wait.until(ExpectedConditions.titleContains("Paciente")));

    }

    public void shouldRegistryOnePacient() throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitcadastrarpaciente")));

        webDriver.findElement(By.id("nomecadastro")).sendKeys("Voldemort");
        webDriver.findElement(By.id("sobrenomecadastro")).sendKeys("Das Magia");
        webDriver.findElement(By.id("cpfcadastro")).sendKeys("02759756734");
        webDriver.findElement(By.id("emailcadastro")).sendKeys("voldermort_94@mmagia.com");
        webDriver.findElement(By.id("telefonecadastro")).sendKeys("998778987");
        webDriver.findElement(By.id("celularcadastro")).sendKeys("87787765");
        webDriver.findElement(By.id("enderecocadastro")).sendKeys("Rua assombrada");
        webDriver.findElement(By.id("cepcadastro")).sendKeys("90570022");
        webDriver.findElement(By.id("datanscimentocadastro")).sendKeys("09//11//1990");
        webDriver.findElement(By.id("dataultimaconsultacadastro")).sendKeys("11//11//1990");
        webDriver.findElement(By.id("formadepagamentocadastro")).sendKeys("Cartao");

        webDriver.findElement(By.id("submitcadastrarpaciente")).click();

        assertTrue(wait.until(ExpectedConditions.titleContains("Paciente")));
    }
}
