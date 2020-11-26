package Gun12;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _03_IntroAlert extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
        Interview sorusu
        - Alertleri nasıl kullanırsın (handle edersin)

TODO     driver.switchTo().alert() bununla kullanılır.
         komutları:
         accept --> OK, TAMAM yani olumlu butona basmak
         dismiss --> CANCEL, HAYIR yani olumsuz butona basmak
         getText --> Alertin mesajı alınır
         SendKeys --> Alertin inputuna mesaj göndermek için kullanılır

*/

        driver.get("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

        driver.manage().window().maximize();

        Thread.sleep(1000);

        //Java Script Alert Box
        WebElement clickMe = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        clickMe.click();

        Thread.sleep(2000);

        driver.switchTo().alert().accept(); // Alert kutucuğuna geçildi ve Tamam butonuna basıldı.
        // Web sayfasından Alert kutucuğuna geçildi. switchTo

        System.out.println("Test başarılı...");

        Thread.sleep(2000);
        driver.quit();
    }
}