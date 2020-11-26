package Gun10_Proje2;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;

public class Soru3 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/login.html"); // siteyi açtım // 1

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("input#user_login")); //2
        username.sendKeys("username");

        WebElement password = driver.findElement(By.cssSelector("input#user_password")); //2
        password.sendKeys("password");

        Thread.sleep(1000);

        WebElement sing = driver.findElement(By.cssSelector(".btn.btn-primary")); // 2
        sing.click();

        Thread.sleep(1000);

        WebElement paybils = driver.findElement(By.cssSelector("#pay_bills_tab")); // 3
        paybils.click();

        Thread.sleep(1000);

        WebElement purchase = driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")); // 4
        purchase.click();

        Thread.sleep(1000);

        WebElement currency = driver.findElement(By.cssSelector("select[name='currency']")); // 5
        Select menu = new Select(currency);
        int max = menu.getOptions().size();
        menu.selectByIndex(random(1,max));
//      todo burada Select menüsünde 1.index dahil olmalı. 0.indekste değer yok.

        Thread.sleep(1000);

        WebElement amount = driver.findElement(By.cssSelector("#pc_amount")); // 6
        amount.sendKeys("500");

        Thread.sleep(1000);

        WebElement dolar = driver.findElement(By.cssSelector("input#pc_inDollars_true")); // 7
        dolar.click();

        Thread.sleep(1000);

        WebElement purchaseButton = driver.findElement(By.cssSelector("input#purchase_cash")); // 8
        purchaseButton.click();

        Thread.sleep(1000);

        // EKRANDAKİ YAZININ DOĞRULANMASI
        WebElement element = driver.findElement(By.cssSelector("div#alert_content")); // 9
        String message = element.getText();
        Assert.assertEquals("Foreign currency cash was successfully purchased.",message);
        System.out.println("Ekrandaki yazı doğrulandı...");

        System.out.println("Test başarı ile geçmiştir...");

        Thread.sleep(3000);
        driver.quit();
    }

    public static int random(int min, int max) {

        int uretilenSayi = (int) (Math.random() * ((max-min))) + min;

        return uretilenSayi;
    }
}