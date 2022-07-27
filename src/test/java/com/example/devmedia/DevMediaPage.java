package com.example.devmedia;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DevMediaPage {

    private WebDriver driver;
    private WebElement searchTitle;
    private WebElement searchResult;
    String titulo = "//*[local-name()='svg']/*[local-name()='title']";


    @BeforeEach
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void testTitle() {
        driver.get("https://www.devmedia.com.br/");

        searchResult = driver.findElement(By.xpath(titulo));
        //assertTrue(searchResult.isDisplayed());
        assertThat(driver.getTitle()).startsWith("Plataforma para Programadores");
    }

}
