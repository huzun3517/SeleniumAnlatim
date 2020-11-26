package Gun10_Proje2;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Soru1 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/login.html"); // siteyi açtım // 1

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("input#user_login")); //2
        username.sendKeys("username");

        WebElement password = driver.findElement(By.cssSelector("input#user_password")); //2
        password.sendKeys("password");

        WebElement sing = driver.findElement(By.cssSelector(".btn.btn-primary")); // 2
        sing.click();

        Thread.sleep(1000);

        WebElement transfer = driver.findElement(By.cssSelector("li#transfer_funds_tab")); // 3
        transfer.click();

        Thread.sleep(1000);

        WebElement accountFrom = driver.findElement(By.cssSelector("#tf_fromAccountId")); //4
        Select menu = new Select(accountFrom);
        int max = menu.getOptions().size();
        menu.selectByIndex(RandomDegerAta(max));

        Thread.sleep(1000);

        WebElement accountTo = driver.findElement(By.cssSelector("#tf_toAccountId")); //5
        menu = new Select(accountTo);
        max = menu.getOptions().size();
        menu.selectByIndex(RandomDegerAta(max));

        Thread.sleep(1000);

        WebElement amount = driver.findElement(By.cssSelector("#tf_amount")); //6
        amount.sendKeys("100");

        Thread.sleep(1000);

        WebElement description = driver.findElement(By.cssSelector("#tf_description")); //7
        description.sendKeys("Para yatırıldı...");

        Thread.sleep(1000);

        WebElement continueButton = driver.findElement(By.cssSelector("#btn_submit")); //8
        continueButton.click();

        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.cssSelector("#btn_submit")); //9
        submitButton.click();

        Thread.sleep(1000);

        WebElement element = driver.findElement(By.cssSelector("div.alert.alert-success")); // 10
        String message = element.getText();
        Assert.assertEquals("You successfully submitted your transaction.",message);
        System.out.println("Yazı doğrulandı...");

        System.out.println("Test başarı ile geçmiştir...");

        Thread.sleep(3000);
        driver.quit();
    }

        public static int RandomDegerAta(int max) {

            Random random = new Random();

            int uretilenSayi = random.nextInt(max);

        return uretilenSayi;
    }
}