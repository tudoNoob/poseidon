package com.poseidon;

import com.poseidon.controller.PoseidonApplicationTests;
import com.poseidon.model.Consulta;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Text;

public class FunctionalTest extends PoseidonApplicationTests {

     public WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver() ;

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

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
