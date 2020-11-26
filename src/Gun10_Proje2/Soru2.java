package Gun10_Proje2;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Soru2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/login.html"); // siteyi açtım // 1

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("input#user_login")); //2
        username.sendKeys("username");

        WebElement password = driver.findElement(By.cssSelector("input#user_password")); //2
        password.sendKeys("password");

        WebElement sing = driver.findElement(By.cssSelector(".btn.btn-primary")); // 2
        sing.click();

        WebElement paybils = driver.findElement(By.cssSelector("#pay_bills_tab")); // 3
        paybils.click();

        Thread.sleep(1000);

        WebElement Payee = driver.findElement(By.cssSelector("#sp_payee")); //4
        Select menu = new Select(Payee);
        int max = menu.getOptions().size();
        menu.selectByIndex(random(max));

        Thread.sleep(1000);

        WebElement account = driver.findElement(By.cssSelector("select#sp_account")); //5
        menu= new Select(account);
        max = menu.getOptions().size();
        menu.selectByIndex(random(max));

        Thread.sleep(1000);

        WebElement amount = driver.findElement(By.cssSelector("#sp_amount")); //6
        amount.sendKeys("150");

        Thread.sleep(1000);

        WebElement date = driver.findElement(By.cssSelector("#sp_date")); //7
        date.click();
        WebElement month = driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w")); //7
        month.click();
        WebElement day = driver.findElement(By.xpath("//a[text()='18']")); //7
        day.click();

        Thread.sleep(1000);

        WebElement description = driver.findElement(By.cssSelector("input#sp_description")); //8
        description.sendKeys("Borcu ödedim.");

        Thread.sleep(1000);

        WebElement pay = driver.findElement(By.cssSelector("input#pay_saved_payees")); //9
        pay.click();

        // EKRANDA ÇIKAN MESAJIN ASERT İLE KONTROLU
        WebElement element = driver.findElement(By.cssSelector("div#alert_content")); // 10
        String message = element.getText();
        Assert.assertEquals("The payment was successfully submitted.",message);
        System.out.println("Ekrandaki mesaj doğrulandı...");

        System.out.println("Test başarı ile geçmiştir...");

        Thread.sleep(3000);
        driver.quit();
    }


    public static int random(int max) {

        Random random = new Random();

        int uretilenSayi = random.nextInt(max);

        return uretilenSayi;
    }
}