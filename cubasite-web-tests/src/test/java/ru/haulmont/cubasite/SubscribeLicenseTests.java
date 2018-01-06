package ru.haulmont.cubasite;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class SubscribeLicenseTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void SubscribeLicenseTests() {
        wd.get("http://192.168.44.162:8280/");
        wd.findElement(By.linkText("Sign in")).click();
        wd.findElement(By.id("edit-name")).click();
        wd.findElement(By.id("edit-name")).clear();
        wd.findElement(By.id("edit-name")).sendKeys("yuselia+1@yandex.ru");
        wd.findElement(By.id("edit-pass")).click();
        wd.findElement(By.id("edit-pass")).clear();
        wd.findElement(By.id("edit-pass")).sendKeys("1qaz");
        wd.findElement(By.id("edit-submit")).click();
        wd.findElement(By.linkText("Store")).click();
        wd.findElement(By.xpath("//div[@class='field-items']/div/cwb-main/iron-lazy-pages/cwb-market/iron-lazy-pages/cwb-home/div/div[1]/cwb-button-link/a/cwb-button/div")).click();
        wd.findElement(By.cssSelector("input.style-scope.cwb-input")).click();
        wd.findElement(By.cssSelector("input.style-scope.cwb-input")).clear();
        wd.findElement(By.cssSelector("input.style-scope.cwb-input")).sendKeys("2");
        wd.findElement(By.xpath("//div[@id='blockSelect']//iron-icon[normalize-space(.)='']")).click();
        wd.findElement(By.xpath("//paper-listbox[@id='periodListBox']//div[normalize-space(.)='$59.98']")).click();
        wd.findElement(By.id("checkboxContainer")).click();
        wd.findElement(By.xpath("//cwb-option-dialog[@id='licenseDialog']//div[normalize-space(.)='Cancel']")).click();
        wd.findElement(By.xpath("//cwb-cart-license-agreement[@id='licenseAgreementElement']/div/paper-checkbox/div[2]/div")).click();
        wd.findElement(By.xpath("//cwb-hold-block[@id='holdBlock']//div[normalize-space(.)='CONTINUE']")).click();
        wd.findElement(By.xpath("//cwb-hold-block[@id='holdBlock']/div/div/div[2]/cwb-cart-layout-block[3]/div/cwb-button/div")).click();
        wd.findElement(By.xpath("//cwb-option-dialog[@id='showCartInfoCodeModal']/paper-dialog/div[2]/cwb-button[2]/div")).click();
        wd.findElement(By.linkText("account")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
