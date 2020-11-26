package Gun08;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _05_FacebookSelect extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
/*TODO
       "İnterview larda dinamik eleman nedir ? ne nasıl bulursunuz ?
       Sayfa yenilendiğinde id ler veya locator lar değişiyorsa buna dinamik eleman denir.
       Aşağıdaki fonksiyonlar ile bulunur.

TODO    Özet Bilgi
        u_0_2
        u_1_2
        u_2_2
        u_3_2
        u_4_2
        u_6_2

TODO    u_ başlıyor
        _2 bitiyor

TODO    a[id^='u_'][id$='_2']

TODO    CSS de
        ^ -> ile başlayan
        $ -> ile biten
        * -> içinde geçen

TODO     Xpath
        //a[starts-with(@id,'u_')]  -> ile başlayan
        //a[ends-with(@id,'_2')]    -> ile biten
        //a[contains(@id,'u_')]     -> içinde geçen
*/

        driver.get("https://www.facebook.com/");
        driver.manage().deleteAllCookies(); // sitelerin bizim bilgilerimizi tutarak bazen engel çıkardığı
                                            // cookies leri sildik.
        driver.manage().window().maximize();

        //YENİ HESAP OLUŞTUR
        WebElement btnYeniHesap=driver.findElement(By.cssSelector("a[id^='u_'][id$='_2']"));
        btnYeniHesap.click();

        // AD
        Thread.sleep(3000);
        WebElement txtilkAd=driver.findElement(By.cssSelector("input[id^='u_'][id$='_b']"));
        txtilkAd.sendKeys("ismet");

        // SOYAD
        WebElement txtSoyad=driver.findElement(By.cssSelector("input[id^='u_'][id$='_d']"));
        txtSoyad.sendKeys("temur");

        // E-MAİL
        WebElement email=driver.findElement(By.cssSelector("input[id^='u_'][id$='_g']"));
        email.sendKeys("ismet@hotmail.com");

        //E-MAİL TEKRAR
        WebElement tEmail=driver.findElement(By.cssSelector("input[id^='u_'][id$='_j']"));
        tEmail.sendKeys("ismet@hotmail.com");

        //ŞİFRE
        WebElement yeniSifre=driver.findElement(By.id("password_step_input"));
        yeniSifre.sendKeys("1234");

        // GÜN
        WebElement EGun=driver.findElement(By.id("day"));
        Select gun=new Select(EGun);
        gun.selectByValue("10");

        // AY
        WebElement EAy=driver.findElement(By.id("month"));
        Select ay=new Select(EAy);
        ay.selectByValue("10");

        // YIL
        WebElement EYil=driver.findElement(By.id("year"));
        Select yil=new Select(EYil);
        yil.selectByVisibleText("1973");

        // CİNSİYET-->ERKEK
        WebElement cinsiyet=driver.findElement(By.cssSelector("input[id^='u_'][id$='_5']"));
//TODO                                        2.yol-->   span[id^='u_'][id$='_o']>:nth-child(2)
        cinsiyet.click();

        Thread.sleep(6000);
        driver.quit();
    }
}
