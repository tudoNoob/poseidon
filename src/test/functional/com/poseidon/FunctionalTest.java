package com.poseidon;

import com.poseidon.controller.PoseidonApplicationTests;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FunctionalTest extends PoseidonApplicationTests {

     public WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver() ;

    }

    @Test
    public void shouldReturnTitleOfPage() {
        driver.get("http://localhost:8081/");
        String title = "Home";
        String user = "admin";
        String password = "admin";
        driver.findElement(By.id("user.login")).sendKeys(user);
        driver.findElement(By.id("password.login")).sendKeys(password);
        driver.findElement(By.id("submit.login")).click();
        Assert.assertEquals(title,driver.getTitle());
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
