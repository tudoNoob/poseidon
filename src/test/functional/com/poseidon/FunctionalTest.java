package com.poseidon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
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
        String title = "Login";
        Assert.assertEquals(title,driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
