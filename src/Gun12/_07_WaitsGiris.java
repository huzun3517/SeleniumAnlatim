package Gun12;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class _07_WaitsGiris extends BaseStaticDriver {

/*TODO
        Selenium Bekletme Konusu:
        Thread.sleep : bu selenium a özel değil, java ya ait yazılımın herhangi bir yerinde verilen süre kadar bekler.

TODO    Implicit wait :
        Tüm sayfadaki elemanlar için bir bekleme süresi atanıyor. Ancak eleman bulunduğu anda daha fazla beklemiyor.
        Bütün elemanlar geçerli. NoSuchElement hatasını vermek için verilen süre kadar eleman bulunana kadar bekler.

TODO    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);

TODO    pageLoadTimeout :
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        30 sn süresinde sayfanın yüklenmesini bekliyor, bu süreden sonra timeout düşerek hata verir.
        driver.get() de driver.navigate.To
*/

    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        // Click me to start timer -->Button tıklatma
        WebElement button=driver.findElement(By.xpath("//button[@onclick='timedText()']"));
        button.click();

        //Thread.sleep(30000); --> kullanmadık. Çünkü yukarıda bekletme kullandık. Tüm sayfadaki elemanlar için bir bekleme süresi atanıyor.
        WebElement webDriverText=driver.findElement(By.xpath("//p[text()='WebDriver']"));

        System.out.println(webDriverText.getText());

        Thread.sleep(1000);
        driver.quit();

    }
}
