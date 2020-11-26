package Gun07;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class _03_odev extends BaseStaticDriver {

        public static void main(String[] args) throws InterruptedException {

/*  TODO
            Senaryo
        1- https://www.saucedemo.com/ sitesini açınız.
        2- login işlemini yapınız (login işlemi ayrı bir static metodda olsun ordan çağırınız)
        3- Açılan sayfadaki bütün ürünleri sepete ekleyiniz.
        4- Sepete tıklayınız
        5- Sepette listelenen bütün ürünleri REMOVE yapınız.
        6- Sağ üst taraftaki sepet imajındaki ürün sayısını gösteren yerin boş olduğunu
           Assert ile kontrol ediniz.
*/

            driver.get("https://www.saucedemo.com/"); // 1.bölüm
            driver.manage().window().maximize();

            logIn(); // 2.bölüm --> static methodumuzu çağırdık

//todo      3.bölüm sepete ekleme
            List<WebElement> list = driver.findElements(By.cssSelector("button.btn_primary.btn_inventory"));

            for (WebElement e: list ) {
                e.click();
            }

            Thread.sleep(1000);

//todo      4.bölüm sepete tıklama
            WebElement sepetTikla = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
            sepetTikla.click();

            Thread.sleep(1000);

//todo      5.bölüm sepetteki tüm ürünleri REMOVE yapma
            List<WebElement> listRemove = driver.findElements(By.cssSelector("button.btn_secondary.cart_button"));

            for (WebElement e: listRemove ) {
                e.click();
            }

//todo      6.bölüm Sağ üst taraftaki sepet imajındaki ürün sayısını gösteren yerin boş olduğunu kontrol etme
//todo      burada yakaladığımız yer sepete eleman eklenince sepetin üzerinde yazan rakamın olduğu yer. oranın 0 sıfır olamsını kontrol ediyoruz.
//          Orasını önce doluyken yakalamak gerekir. Kolay bulabilmek için.
            List<WebElement> sepetNo = driver.findElements(By.cssSelector("span.fa-layers-counter.shopping_cart_badge"));

//          Assert.assertEquals(0, sepetNo.size());  // 1.Yöntem

            Assert.assertTrue(0 == sepetNo.size());  // 2.Yöntem

            System.out.println("Test başarlı...");

            Thread.sleep(3000);

            driver.quit();
        }

        // METHOD 2.Bölüm
        public static void logIn() throws InterruptedException {

            // login işlemleri
            WebElement usernameInput=driver.findElement(By.xpath("//input[@id='user-name']"));
            usernameInput.sendKeys("standard_user");

            Thread.sleep(1000);
            WebElement passwordInput=driver.findElement(By.xpath("//input[@id='password']"));
            passwordInput.sendKeys("secret_sauce");

            Thread.sleep(1000);
            WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
            loginButton.click();
        }
    }