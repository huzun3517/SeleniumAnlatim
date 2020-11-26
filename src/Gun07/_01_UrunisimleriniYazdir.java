package Gun07;
import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class _01_UrunisimleriniYazdir extends BaseStaticDriver {

        public static void main(String[] args) throws InterruptedException {

/*      TODO
            1- https://www.saucedemo.com/ sitesini açınız.
            2- Login işlemini yapınız
            3- Burada gözüken ürünlerin isimlerini yazdırınız.
*/

            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            // login işlemleri
            WebElement usernameInput=driver.findElement(By.xpath("//input[@id='user-name']"));
            usernameInput.sendKeys("standard_user");

            Thread.sleep(1000);
            WebElement passwordInput=driver.findElement(By.xpath("//input[@id='password']"));
            passwordInput.sendKeys("secret_sauce");

            Thread.sleep(1000);
            WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
            loginButton.click();

            // ilk ürünün yerine baktım--> "Sauce Labs Backpack" classını alınca altında 6 ürün var bunları listeye atıyorum.
            List<WebElement> urunler=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

            for(WebElement urun: urunler)
            {
                System.out.println(urun.getText());
            }


            Thread.sleep(6000);
            driver.quit();
        }
}