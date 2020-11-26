package Gun08;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class _02_UrunlerVeSepetKontrol extends BaseStaticDriver {

        public static void main(String[] args) throws InterruptedException {

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


            // ürünlerin isimlerini bir list e attık
            List<WebElement> urunler=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

            List<String> urunAdlari=new ArrayList<>();

            for(WebElement urun: urunler)
            {
                urunAdlari.add(urun.getText());
            }

            // ürünleri sepete ekledik.
            List<WebElement> urunlerSepeteEkle=driver.findElements(By.xpath("//button[@class='btn_primary btn_inventory']"));
            for(WebElement sepetEkle: urunlerSepeteEkle)
            {
                sepetEkle.click();
            }

            Thread.sleep(1000);
            WebElement sepet=driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
            sepet.click();


            // Sepetteki ürünlerin isimlerini bir list e attık
            List<WebElement> sepettekiUrunler=driver.findElements(By.xpath("//div[@class='inventory_item_name']"));

            List<String> sepettekiUrunAdlari=new ArrayList<>();

            for(WebElement urun: sepettekiUrunler)
            {
                sepettekiUrunAdlari.add(urun.getText());
            }


            for(int i=0; i<sepettekiUrunAdlari.size(); i++)
            {
                // 1.Yöntem
                if (!sepettekiUrunAdlari.get(i).equals( urunAdlari.get(i)))
                    Assert.fail("Ürün adları eşit değil="+sepettekiUrunAdlari.get(i)+" "+urunAdlari.get(i));
                // direk hata oluştur.

                //2.Yöntem
                //Assert.assertEquals("Ürünler eşit değil", sepettekiUrunAdlari.get(i), urunAdlari.get(i));
            }

            Thread.sleep(6000);
            driver.quit();
        }

}