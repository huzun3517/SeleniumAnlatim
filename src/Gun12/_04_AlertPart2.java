package Gun12;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _04_AlertPart2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

        driver.manage().window().maximize();

        Thread.sleep(1000);

        // Java Script Confirm Box
        WebElement clickMe2 = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        clickMe2.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        //ALERT in TEXT İNİ ASSERT İLE DOĞRULATMA
        WebElement textActual = driver.findElement(By.xpath("//p[text()='You pressed Cancel!']"));
        String hataStr = textActual.getText();

        Assert.assertEquals("You pressed Cancel!",hataStr);

        System.out.println("Test başarılı...");

        Thread.sleep(2000);
        driver.quit();
    }
}