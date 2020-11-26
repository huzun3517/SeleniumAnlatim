package Gun12;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _05_AlertPart3 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

        driver.manage().window().maximize();

        Thread.sleep(1000);

        // Java Script Alert Box  --> Click for Prompt Box tıklatma ve Alert e deger girme
        WebElement buttonPromt = driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
        buttonPromt.click();

        driver.switchTo().alert().sendKeys("Hüseyin");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();


        //ALERT TEXT İNİ ASSERT İLE DOĞRULATMA
        WebElement textActual = driver.findElement(By.cssSelector("p#prompt-demo"));

        Assert.assertTrue(textActual.getText().contains("Hüseyin"));

        System.out.println("Test başarılı...");

        Thread.sleep(2000);
        driver.quit();
    }
}