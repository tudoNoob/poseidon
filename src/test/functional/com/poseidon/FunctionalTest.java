package com.poseidon;

import com.poseidon.controller.PoseidonApplicationTests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

import static org.junit.Assert.fail;


public class FunctionalTest extends PoseidonApplicationTests {

    private WebDriver driver;
    private String userAdmin = "admin";
    private String passwordAdmin = "admin";
    private String user = "user";
    private String passwordUser = "user";
    private String homeTitle = "Home";
    private String patientTitle = "Paciente";
    private String consultTitle = "Consulta";
    private String doctorTitle = "Médico";
    private String accountTitle = "Conta";
    private String aboutTitle = "Sobre";
    private String loginTitle = "Login";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void adminAccess() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("user.login")).sendKeys(userAdmin);
        driver.findElement(By.id("password.login")).sendKeys(passwordAdmin);
        driver.findElement(By.id("submit.login")).click();
        Assert.assertEquals(homeTitle, driver.getTitle());
        driver.findElement(By.linkText("Paciente")).click();
        driver.findElement(By.linkText("Cadastrar Paciente")).click();
        Assert.assertEquals(patientTitle, driver.getTitle());
        driver.findElement(By.linkText("Paciente")).click();
        driver.findElement(By.linkText("Deletar Paciente")).click();
        Assert.assertEquals(patientTitle, driver.getTitle());
        driver.findElement(By.linkText("Paciente")).click();
        driver.findElement(By.linkText("Pesquisar Paciente")).click();
        Assert.assertEquals(patientTitle, driver.getTitle());
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Cadastrar Consulta")).click();
        Assert.assertEquals(consultTitle, driver.getTitle());
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Deletar Consulta")).click();
        Assert.assertEquals(consultTitle, driver.getTitle());
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Editar Consulta")).click();
        Assert.assertEquals(consultTitle, driver.getTitle());
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Exibir calendário de Consultas")).click();
        Assert.assertEquals(consultTitle, driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Cadastrar Médico")).click();
        Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Pesquisar Médico")).click();
        Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Deletar Médico")).click();
        Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Editar Médico")).click();
        Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Exibir todos Médicos")).click();
        Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Criar Conta")).click();
        Assert.assertEquals(accountTitle, driver.getTitle());
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Editar Conta")).click();
        Assert.assertEquals(accountTitle, driver.getTitle());
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Deletar Conta")).click();
        Assert.assertEquals(accountTitle, driver.getTitle());
        driver.findElement(By.linkText("Contas")).click();
        driver.findElement(By.linkText("Exibir todas Contas")).click();
        Assert.assertEquals(accountTitle, driver.getTitle());
        driver.findElement(By.linkText("Sobre")).click();
        Assert.assertEquals(aboutTitle, driver.getTitle());
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertEquals(loginTitle, driver.getTitle());
    }

    @Test
    public void aboutAccessAsUser() {
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("user.login")).sendKeys(user);
        driver.findElement(By.id("password.login")).sendKeys(passwordUser);
        driver.findElement(By.id("submit.login")).click();
        driver.findElement(By.linkText("Sobre")).click();
        WebElement txt = driver.findElement(By.id("about"));
        String str = txt.getText();
        String merge = "Criamos está aplicação com o Objetivo de suprir as necessidades do mercado de clinicas de quiropaxia. Criado por Guilherme Matuella, Jader Cunha, Pedro Henrique, Rafael Ahrons e William Ahrons";
        Assert.assertEquals(merge, str);
    }

    @Test
    public void addDoctorAsAdmin() {
        driver.get("http://localhost:8081/");
        String newDoctor = "Michael Jackson";
        driver.findElement(By.id("user.login")).sendKeys(userAdmin);
        driver.findElement(By.id("password.login")).sendKeys(passwordAdmin);
        driver.findElement(By.id("submit.login")).click();
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Cadastrar Médico")).click();
        driver.findElement(By.id("user.create")).sendKeys(newDoctor);
        driver.findElement(By.id("cadastrarMedico.submit")).click();
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Exibir todos Médicos")).click();
        List<WebElement> TRs = driver.findElements(By.tagName("tr"));
        if (verifyIFaTextInTdIsEqual(newDoctor, TRs) == true) { return; };
        fail("Não encontrado o médico " + newDoctor + "!");
    }

    private boolean verifyIFaTextInTdIsEqual(String toEqual, List<WebElement> trList) {
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


    @Test
    public void deleteDoctorAsAdmin() {
        driver.get("http://localhost:8081/");
        String newDoctor = "Gregory House";
        driver.findElement(By.id("user.login")).sendKeys(userAdmin);
        driver.findElement(By.id("password.login")).sendKeys(passwordAdmin);
        driver.findElement(By.id("submit.login")).click();
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Cadastrar Médico")).click();
        driver.findElement(By.id("user.create")).sendKeys(newDoctor);
        driver.findElement(By.id("cadastrarMedico.submit")).click();
        driver.findElement(By.linkText("Médico")).click();
        driver.findElement(By.linkText("Exibir todos Médicos")).click();
        List<WebElement> TR = driver.findElements(By.tagName("tr"));
        if (verifyIFaTextIsEqual(newDoctor, TR) == true){
            driver.findElement(By.linkText("Médico")).click();
            driver.findElement(By.linkText("Deletar Médico")).click();
            driver.findElement(By.id("id.medico")).sendKeys(TR.toString());
            return;
        }
        fail("Não foi encontrado o médico " + newDoctor + " !");
    }

    private Boolean verifyIFaTextIsEqual(String txtEqual, List<WebElement> trsList){
        for(int i=1; i < trsList.size(); i++) {
            List<WebElement> td = trsList.get(i).findElements(By.tagName("td"));
            for (int j = 0; j < td.size(); j++) {
                if (td.get(j).getText().equals(txtEqual))
                    return true;
            }
        }
        return false;
    }

    @Test
    public void addConsultAsAdmin() {
        driver.get("http://localhost:8081/");
        String newConsult = "Gregory House";
        driver.findElement(By.id("user.login")).sendKeys(userAdmin);
        driver.findElement(By.id("password.login")).sendKeys(passwordAdmin);
        driver.findElement(By.id("submit.login")).click();
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Cadastrar Consulta")).click();
    }

    @Test
    public void addPacientAsAdmin() {
        driver.get("http://localhost:8081/");
        String newPacient = "Maria";
        String address = "Padre Chagas, 6969, Moinhos de Vento";
        String surmane = "Silva";
        String meansOfPayment = "250,00";
        String cep = "123456789";
        String cpf = "0166239969";
        String birthDate = "20022000";
        String email = "maria@gmail.com";
        String lastConsult = "12122012";
        String telephone = "32125415";
        String phone = "84541212";
        driver.findElement(By.id("user.login")).sendKeys(userAdmin);
        driver.findElement(By.id("password.login")).sendKeys(passwordAdmin);
        driver.findElement(By.id("submit.login")).click();
        driver.findElement(By.linkText("Paciente")).click();
        driver.findElement(By.linkText("Cadastrar Paciente")).click();
        driver.findElement(By.id("nomecadastro")).sendKeys(newPacient);
        driver.findElement(By.id("enderecocadastro")).sendKeys(address);
        driver.findElement(By.id("sobrenomecadastro")).sendKeys(surmane);
        driver.findElement(By.id("cepcadastro")).sendKeys(cep);
        driver.findElement(By.id("cpfcadastro")).sendKeys(cpf);
        driver.findElement(By.id("datanscimentocadastro")).sendKeys(birthDate);
        driver.findElement(By.id("emailcadastro")).sendKeys(email);
        driver.findElement(By.id("dataultimaconsultacadastro")).sendKeys(lastConsult);
        driver.findElement(By.id("telefonecadastro")).sendKeys(telephone);
        driver.findElement(By.id("formadepagamentocadastro")).sendKeys(meansOfPayment);
        driver.findElement(By.id("celularcadastro")).sendKeys(phone);
        driver.findElement(By.id("submitcadastrarpaciente")).click();
        driver.findElement(By.linkText("Paciente")).click();
        driver.findElement(By.linkText("Pesquisar Paciente")).click();
        driver.findElement(By.id("nome")).sendKeys(newPacient);
        driver.findElement(By.id("idpesquisar")).click();
        List<WebElement> TR = driver.findElements(By.tagName("tr"));
        if (verifyIFaTextIsEqual(newPacient, TR) == true){ return; }
        fail("Não foi encontrado o paciente " + newPacient + " !");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}