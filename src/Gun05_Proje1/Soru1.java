package Gun05_Proje1;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru1 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demoqa.com/text-box"); // siteyi açtım

        driver.manage().window().maximize();

        WebElement name = driver.findElement(By.id("userName"));
        name.sendKeys("Automation");

        WebElement mail = driver.findElement(By.id("userEmail"));
        mail.sendKeys("huzun@gmail.com");

        WebElement adress = driver.findElement(By.id("currentAddress"));
        adress.sendKeys("Testing Current Address");

        WebElement adress2 = driver.findElement(By.id("permanentAddress"));
        adress2.sendKeys("Testing Permanent Address");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        // KONTROL 1
        WebElement checkname = driver.findElement(By.id("name"));
        String s = checkname.getText();
        Assert.assertTrue(s.contains("Automation"));
        System.out.println("Automation Full Name'nin içinde yer alıyor...");

        // KONTROL 2
        WebElement checkname2 = driver.findElement(By.id("email"));
        String s2 = checkname2.getText();
        Assert.assertTrue(s2.contains("huzun@gmail.com"));
        System.out.println("huzun@gmail Email'in içinde yer alıyor...");

        System.out.println("Test başarı ile geçmiştir...");

        Thread.sleep(5000);
        driver.quit();
    }
}