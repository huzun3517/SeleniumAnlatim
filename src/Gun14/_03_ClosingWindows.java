package Gun14;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;

public class _03_ClosingWindows extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
   1- https://www.selenium.dev/ sayfasına gidiniz.
   2- yeni sayfa açan linklere tıklayınız.
   3- Ana sayfanın haricindeki diğer sayfaları kapatınız.
   4- Ana sayfaya tekrar driverı set ediniz.
 */

        driver.get("https://www.selenium.dev/");

        String anasayfaID = driver.getWindowHandle();

        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement link: linkler) {

            link.click();
        }

        Set<String> windowIdler = driver.getWindowHandles();

        for (String ID: windowIdler) {

            System.out.println(ID);

            if (ID.equals(anasayfaID)) continue; // ana sayfa id si geldiğinde sonraki kodları pas geç yani çalıştırma.

            driver.switchTo().window(ID);

            System.out.println("Window title = " + driver.getTitle());

            driver.close();

        }

        // driver en son yukarıdaki kapatılan sayfaya switch olmuştu onu gösteriyordu,
        // eğer alttaki anasayfaya switch eden set eden komut olmasa idi, driver kapatılan sayfayı gösterdiğinden
        // hata verecekti.Bu yüzden en son stiwch işlemini yaparak driver ı ana sayfaya set(switch) ettik
        driver.switchTo().window(anasayfaID);
        System.out.println("Window title = " + driver.getTitle());

        Thread.sleep(2000);

 //       driver.quit();

    }
}
