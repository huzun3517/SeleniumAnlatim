package Gun06.Xpath;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Xpath extends BaseStaticDriver {


        public static void main(String[] args) throws InterruptedException {

            driver.get("https://www.saucedemo.com/");  // siteyi açtım
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

            // ilk ürüne tıklandı ve  eklendi
            Thread.sleep(1000);
            WebElement BackpackElement=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
            BackpackElement.click();

            Thread.sleep(1000);
            WebElement addToCart=driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
            addToCart.click();

            // geri dönüldü
            Thread.sleep(1000);
            WebElement buttonBack=driver.findElement(By.xpath("//button[text()='<- Back']"));
            buttonBack.click();

            // 2. ürün ekleme işlemleri
            // ilk ürüne tıklandı ve  eklendi
            Thread.sleep(1000);
            WebElement boltTshirtTextElement=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));

            boltTshirtTextElement.click();

            Thread.sleep(1000);
            WebElement addToCart2=driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
            addToCart2.click();

            // sepete tıklandı
            Thread.sleep(1000);
            WebElement contSepet=driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
            contSepet.click();

            // checkout tıklandı
            Thread.sleep(1000);
            WebElement buttonCheckOut=driver.findElement(By.xpath("//a[text()='CHECKOUT']"));
            buttonCheckOut.click();

            // isim girişi
            Thread.sleep(1000);
            WebElement firstNameInput=driver.findElement(By.xpath("//input[@id='first-name']"));
            firstNameInput.sendKeys("ismet");

            // soyisim girişi
            Thread.sleep(1000);
            WebElement lastNameInput=driver.findElement(By.xpath("//input[@id='last-name']"));
            lastNameInput.sendKeys("temur");

            // postal-code girişi
            Thread.sleep(1000);
            WebElement postalCode=driver.findElement(By.xpath("//input[@id='postal-code']"));
            postalCode.sendKeys("12345");

            // checkout tıklandı
            Thread.sleep(1000);
            WebElement continueButton=driver.findElement(By.xpath("//input[@class='btn_primary cart_button']"));
            continueButton.click();

            // 1.ürünün fiyatı
            Thread.sleep(1000);
            WebElement urun1Fiyat=driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[1]"));
            String txtFiyat1=urun1Fiyat.getText();

            // 2.ürünün fiyatı
            Thread.sleep(1000);
            WebElement urun2Fiyat=driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[2]"));
            String txtFiyat2=urun2Fiyat.getText();

            // toplam
            Thread.sleep(1000);
            WebElement toplamEl=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
            String txtToplam=toplamEl.getText();

            System.out.println("fiyat 1="+txtFiyat1);
            System.out.println("fiyat 2="+txtFiyat2);
            System.out.println("toplam="+txtToplam);

            double urunFiyatToplam=stringToDouble(txtFiyat1)+stringToDouble(txtFiyat2);
            double toplam=stringToDouble(txtToplam);

            Assert.assertTrue(toplam == urunFiyatToplam);


            Thread.sleep(6000);
            driver.quit();
        }


    public static double stringToDouble(String strTutar)
    {
        // $29.99
        String duzeltilmisHali=strTutar.replaceAll("[^\\d.]","");
        // d yani sayı ve . haricindekileri(^) , bosluk ata yani sil
        // 29.99

        return  Double.parseDouble(duzeltilmisHali);
    }
}