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

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class UserJourney {

    public static final String USER_LOGIN = "user";
    public static final String USER_PASSWORD = "user";
    public static final String SOME_NAME = "Voldemort";
    public static final String SOME_LAST_NAME = "Das Magia";
    public static final String SOME_CPF = "02759756734";
    public static final String SOME_EMAIL = "voldermort_94@mmagia.com";
    public static final String SOME_PHONE = "998778987";
    public static final String SOME_CEL_PHONE = "87787765";
    public static final String SOME_ADDRESS = "Rua assombrada";
    public static final String SOME_CEP = "90570022";
    public static final String SOME_BIRTH_DATE = "09//11//1990";
    public static final String SOME_LAST_SCHEDULE = "11//11//1990";
    public static final String SOME_CARD = "Cartao";
    public static final String BTN_CRIAR_PACIENTE = "btn-criarPaciente";
    public static final String BOTTUN_PESQUISAR_PACIENTE = "btn-pesquisarPaciente";

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
        shouldExecuteActionIntoDropdownFromPacient(BTN_CRIAR_PACIENTE);
        shouldRegistryOnePacient();
        shouldExecuteActionIntoDropdownFromPacient(BOTTUN_PESQUISAR_PACIENTE);
        shouldSearchForPacient(SOME_NAME);
        shouldLogout();
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

        webDriver.findElement(By.id("nomecadastro")).sendKeys(SOME_NAME);
        webDriver.findElement(By.id("sobrenomecadastro")).sendKeys(SOME_LAST_NAME);
        webDriver.findElement(By.id("cpfcadastro")).sendKeys(SOME_CPF);
        webDriver.findElement(By.id("emailcadastro")).sendKeys(SOME_EMAIL);
        webDriver.findElement(By.id("telefonecadastro")).sendKeys(SOME_PHONE);
        webDriver.findElement(By.id("celularcadastro")).sendKeys(SOME_CEL_PHONE);
        webDriver.findElement(By.id("enderecocadastro")).sendKeys(SOME_ADDRESS);
        webDriver.findElement(By.id("cepcadastro")).sendKeys(SOME_CEP);
        webDriver.findElement(By.id("datanscimentocadastro")).sendKeys(SOME_BIRTH_DATE);
        webDriver.findElement(By.id("dataultimaconsultacadastro")).sendKeys(SOME_LAST_SCHEDULE);
        webDriver.findElement(By.id("formadepagamentocadastro")).sendKeys(SOME_CARD);

        webDriver.findElement(By.id("submitcadastrarpaciente")).click();

        assertTrue(wait.until(ExpectedConditions.titleContains("Paciente")));
    }

    public void shouldSearchForPacient(String pacientName) throws Exception {
        WebElement inputForSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nome")));
        inputForSearch.sendKeys(pacientName);
        webDriver.findElement(By.id("idpesquisar")).click();
        List<WebElement> listOfPacients = webDriver.findElements(By.tagName("tr"));
        if (!verifyIfHasTextInTable(SOME_NAME, listOfPacients)) {
            fail();
        }

    }

    public void shouldLogout() throws Exception {
        webDriver.findElement(By.id("btn-logout")).click();

        assertTrue(wait.until(ExpectedConditions.titleContains("Login")));
    }

    private boolean verifyIfHasTextInTable(String toEqual, List<WebElement> trList) {
        for (int i = 1; i < trList.size(); i++) {
            List<WebElement> td = trList.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < td.size(); j++) {
                if (td.get(j).getText().equals(toEqual)) {
                    return true;
                }
            }
        }
        return false;
    }
}
