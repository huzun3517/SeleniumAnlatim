package Gun05_Proje1;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demo.applitools.com/"); // siteyi açtım

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("ttechno@gmail.com");

        WebElement pasword = driver.findElement(By.id("password"));
        pasword.sendKeys("techno123.");

        driver.findElement(By.id("log-in")).click();

        WebElement kontrol1 = driver.findElement(By.id("time"));
        String s = kontrol1.getText();
        Assert.assertEquals("Your nearest branch closes in: 30m 5s",s);
        System.out.println(s + " --> yazısı doğrulandı...");

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.applitools.com/app.html",url);
        System.out.println(url + " --> url doğrulandı...");

        System.out.println("Test başarı ile geçmiştir...");

        Thread.sleep(3000);
        driver.quit();
    }
}