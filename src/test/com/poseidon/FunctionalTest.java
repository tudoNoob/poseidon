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
    private String newQuiropraxist = "Gregory House";
    private String newPacient = "Maria";
    private String newBorn = "test";
    private String newBornPassword = "test";
    private String homeTitle = "Home";
    private String patientTitle = "Paciente";
    private String consultTitle = "Consulta";
    private String quiropraxistTitle = "Quiropraxista";
    private String accountTitle = "Conta";
    private String aboutTitle = "Sobre";
    private String loginTitle = "Login";

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void adminAccess() {
        accessAsAdmin();
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
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Cadastrar Quiropraxista")).click();
       // Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Pesquisar Quiropraxista")).click();
        //Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Deletar Quiropraxista")).click();
        //Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Editar Quiropraxista")).click();
        //Assert.assertEquals(doctorTitle, driver.getTitle());
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Exibir todos Quiropraxistas")).click();
        //Assert.assertEquals(doctorTitle, driver.getTitle());
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
    public void addQuiropraxistAsAdmin() {
        accessAsAdmin();
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Cadastrar Quiropraxista")).click();
        driver.findElement(By.id("user.create")).sendKeys(newQuiropraxist);
        driver.findElement(By.id("cadastrarQuiropraxista.submit")).click();
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Exibir todos Quiropraxista")).click();
        List<WebElement> TRs = driver.findElements(By.tagName("tr"));
        //if (verifyIFaTextInTdIsEqual(newDoctor, TRs) == true) { return; }
        fail("Não encontrado o Quiropraxista " + newQuiropraxist + "!");
    }

    @Test
    public void deleteDoctorAsAdmin() {
        accessAsAdmin();
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Cadastrar Quiropraxista")).click();
        driver.findElement(By.id("user.create")).sendKeys(newQuiropraxist);
        driver.findElement(By.id("cadastrarQuiropraxista.submit")).click();
        driver.findElement(By.linkText("Quiropraxista")).click();
        driver.findElement(By.linkText("Exibir todos Quiropraxistas")).click();
        List<WebElement> TR = driver.findElements(By.tagName("tr"));
        /*if (verifyIFaTextInTdIsEqual(newDoctor, TR) == true){
            driver.findElement(By.linkText("Quiropraxista")).click();
            driver.findElement(By.linkText("Deletar Quiropraxista")).click();
            driver.findElement(By.id("id.quiropraxista")).sendKeys(TR.toString());
            return;
        }*/
        fail("Não foi encontrado o Quiropraxista " + newQuiropraxist + " !");
    }

    @Test
    public void addConsultAsAdmin() {
        accessAsAdmin();
        driver.findElement(By.linkText("Consultas")).click();
        driver.findElement(By.linkText("Cadastrar Consulta")).click();
    }

    @Test
    public void addPacientAsAdmin() {
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
        accessAsAdmin();
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
        if (verifyIFaTextInTdIsEqual(newPacient, TR) == true){ return; }
        fail("Não foi encontrado o paciente " + newPacient + " !");
    }

    @Test
    public void deletePacientAsAdmin() {
        String idPacient = "76";
        addPacientAsAdmin();
        List<WebElement> TR = driver.findElements(By.tagName("tr"));
        if (verifyIFaTextInTdIsEqual(newPacient, TR) == true){
            driver.findElement(By.linkText("Paciente")).click();
            driver.findElement(By.linkText("Deletar Paciente")).click();
            driver.findElement(By.id("id.paciente")).sendKeys(idPacient);
            driver.findElement(By.id("id.nome")).sendKeys(newPacient);
            driver.findElement(By.id("submitdeletar")).click();
            return;
        }
        fail("Não foi encontrado o paciente " + newPacient + " !");
    }

    @Test
    public void aboutAccessAsAdmin() {
        accessAsAdmin();
        driver.findElement(By.linkText("Sobre")).click();
        WebElement txt = driver.findElement(By.id("about"));
        String str = txt.getText();
        String merge = "Criamos está aplicação com o Objetivo de suprir as necessidades do mercado de clinicas de quiropaxia. Criado por Guilherme Matuella, Jader Cunha, Pedro Henrique, Rafael Ahrons e William Ahrons";
        Assert.assertEquals(merge, str);
    }

    @Test
    public void UserAccess() {
        accessAsUser();
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
        driver.findElement(By.linkText("Sobre")).click();
        Assert.assertEquals(aboutTitle, driver.getTitle());
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertEquals(loginTitle, driver.getTitle());
    }

    @Test
    public void addPacientAsUser() {
        String address = "Lucas de Oliveira, 6969, Rio Branco";
        String surmane = "Carvalho";
        String meansOfPayment = "350,00";
        String cep = "98764321";
        String cpf = "0166236969";
        String birthDate = "26922000";
        String email = "maria@gmail.com";
        String lastConsult = "12122012";
        String telephone = "32125415";
        String phone = "84541212";
        accessAsUser();
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
        if (verifyIFaTextInTdIsEqual(newPacient, TR) == true){ return; }
        fail("Não foi encontrado o paciente " + newPacient + " !");
    }

    @Test
    public void deletePacientAsUser() {
        String idPacient = "76";
        addPacientAsUser();
        List<WebElement> TR = driver.findElements(By.tagName("tr"));
        if (verifyIFaTextInTdIsEqual(newPacient, TR) == true){
            driver.findElement(By.linkText("Paciente")).click();
            driver.findElement(By.linkText("Deletar Paciente")).click();
            driver.findElement(By.id("id.paciente")).sendKeys(idPacient);
            driver.findElement(By.id("id.nome")).sendKeys(newPacient);
            driver.findElement(By.id("submitdeletar")).click();
            return;
        }
        fail("Não foi encontrado o paciente " + newPacient + " !");
    }

    @Test
    public void aboutAccessAsUser() {
        accessAsUser();
        driver.findElement(By.linkText("Sobre")).click();
        WebElement txt = driver.findElement(By.id("about"));
        String str = txt.getText();
        String merge = "Criamos está aplicação com o Objetivo de suprir as necessidades do mercado de clinicas de quiropaxia. Criado por Guilherme Matuella, Jader Cunha, Pedro Henrique, Rafael Ahrons e William Ahrons";
        Assert.assertEquals(merge, str);
    }

    @Test
    public void createAnUser() {
        driver.findElement(By.id("btn-newuser")).click();
        driver.findElement(By.id("user.create")).sendKeys(newBorn);
        driver.findElement(By.id("pass.create")).sendKeys(newBornPassword);
        driver.findElement(By.id("createUser.submit")).click();
        fail("Não foi possível criar o usuário " + newBorn + " !");
    }

    public void accessAsAdmin(){
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("user.login")).sendKeys(userAdmin);
        driver.findElement(By.id("password.login")).sendKeys(passwordAdmin);
        driver.findElement(By.id("submit.login")).click();
    }

    public void accessAsUser(){
        driver.get("http://localhost:8081/");
        driver.findElement(By.id("user.login")).sendKeys(user);
        driver.findElement(By.id("password.login")).sendKeys(passwordUser);
        driver.findElement(By.id("submit.login")).click();
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

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}