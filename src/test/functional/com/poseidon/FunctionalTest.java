package com.poseidon;

import com.poseidon.controller.PoseidonApplicationTests;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static org.junit.Assert.fail;


public class FunctionalTest extends PoseidonApplicationTests {

    public WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void adminAccess() {
        driver.get("http://localhost:8081/");
        String homeTitle = "Home";
        String patientTitle = "Paciente";
        String consultTitle = "Consulta";
        String doctorTitle = "Médico";
        String accountTitle = "Conta";
        String aboutTitle = "Sobre";
        String loginTitle = "Login";
        String user = "admin";
        String password = "admin";
        driver.findElement(By.id("user.login")).sendKeys(user);
        driver.findElement(By.id("password.login")).sendKeys(password);
        driver.findElement(By.id("submit.login")).click();
        Assert.assertEquals(homeTitle,driver.getTitle());
        driver.findElement(By.linkText("Paciente")).click();
        driver.findElement(By.linkText("Cadastrar Paciente")).click();
        Assert.assertEquals(patientTitle,driver.getTitle());
        driver.findElement(By.linkText("Paciente")).click();
        driver.findElement(By.linkText("Deletar Paciente")).click();
        Assert.assertEquals(patientTitle,driver.getTitle());
        driver.findElement(By.linkText("Paciente")).click();
        driver.findElement(By.linkText("Pesquisar Paciente")).click();
        Assert.assertEquals(patientTitle,driver.getTitle());
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Cadastrar Consulta")).click();
        Assert.assertEquals(consultTitle,driver.getTitle());
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Deletar Consulta")).click();
        Assert.assertEquals(consultTitle,driver.getTitle());
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Editar Consulta")).click();
        Assert.assertEquals(consultTitle,driver.getTitle());
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Exibir calendário de Consultas")).click();
        Assert.assertEquals(consultTitle,driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Cadastrar Médico")).click();
        Assert.assertEquals(doctorTitle,driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Pesquisar Médico")).click();
        Assert.assertEquals(doctorTitle,driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Deletar Médico")).click();
        Assert.assertEquals(doctorTitle,driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Editar Médico")).click();
        Assert.assertEquals(doctorTitle,driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Exibir todos Médicos")).click();
        Assert.assertEquals(doctorTitle,driver.getTitle());
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Criar Conta")).click();
        Assert.assertEquals(accountTitle,driver.getTitle());
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Editar Conta")).click();
        Assert.assertEquals(accountTitle,driver.getTitle());
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Deletar Conta")).click();
        Assert.assertEquals(accountTitle,driver.getTitle());
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Exibir todas Contas")).click();
        Assert.assertEquals(accountTitle,driver.getTitle());
        driver.findElement(By.linkText("Sobre")).click();
        Assert.assertEquals(aboutTitle,driver.getTitle());
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertEquals(loginTitle,driver.getTitle());
    }

    @Test
    public void aboutAccessAsUser() {
        driver.get("http://localhost:8081/");
        String user = "user";
        String password = "user";
        driver.findElement(By.id("user.login")).sendKeys(user);
        driver.findElement(By.id("password.login")).sendKeys(password);
        driver.findElement(By.id("submit.login")).click();
        driver.findElement(By.linkText("Sobre")).click();
        WebElement txt = driver.findElement(By.id("about"));
        String str = txt.getText();
        String merge = "Criamos está aplicação com o Objetivo de suprir as necessidades do mercado de clinicas de quiropaxia. Criado por Guilherme Matuella, Jader Cunha, Pedro Henrique, Rafael Ahrons e William Ahrons";
        Assert.assertEquals(merge,str);
    }

    @Test
    public void addDoctorAsUser() {
        driver.get("http://localhost:8081/");
        String user = "admin";
        String password = "admin";
        String newDoctor = "Michael Jackson";
        driver.findElement(By.id("user.login")).sendKeys(user);
        driver.findElement(By.id("password.login")).sendKeys(password);
        driver.findElement(By.id("submit.login")).click();
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Cadastrar Médico")).click();
        driver.findElement(By.id("user.create")).sendKeys(newDoctor);
        driver.findElement(By.id("cadastrarMedico.submit")).click();
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Exibir todos Médicos")).click();
        List<WebElement> TRs = driver.findElements(By.tagName("tr"));
        if (verifyIFaTextInTdIsEqual(newDoctor, TRs)) return;
        fail("Não encontrado o médico Michael Jackson!");
    }

    private boolean verifyIFaTextInTdIsEqual(String toEqual, List<WebElement> trList) {
        for(int i = 1; i < trList.size(); i++){
            List<WebElement> td = trList.get(i).findElements(By.tagName("td"));
            for(int j=0; j < td.size(); j++){
                if(td.get(j).getText().equals(toEqual)){
                    return true;
                }
            }
        }
        return false;
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
