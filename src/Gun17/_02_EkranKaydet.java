package Gun17;

import _util.BaseStaticDriver;
import org.apache.commons.io.FileUtils;  // dosyamı ekleyince bu kütüphane eklendi...
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class _02_EkranKaydet extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException, IOException {
/*
 TODO
   Senaryo :
        1- https://opensource-demo.orangehrmlive.com/  sitesine gidiniz.
        2- Login işlemini yapınız.
        3- Welcome yazan sağ üst tarafta kullanıcı adının geçip geçmediğini kontrol ediniz.
        4- Eğer Kullanıcı adınız gözükmüyorsa , ekran görünütüsnü kaydedip, ilgili kişiye gönderiniz.
 */


        driver.get("https://opensource-demo.orangehrmlive.com/");

        //LOGIN BOLUMU
        WebElement username = driver.findElement(By.cssSelector("input#txtUsername"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.cssSelector("input#txtPassword"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
        loginButton.click();

        WebElement userName = driver.findElement(By.id("welcome"));
        String welcomeText = userName.getText();
        System.out.println(welcomeText);

//        Assert.assertTrue("HATA:....", welcomeText.contains("Linda"));

        if (welcomeText.contains("Admin")) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
            // Ekran kaydetme işlemleri burada olacak.

            // 1.Aşama ekran görüntüsü alma değişkenimizi tanımladık.
            TakesScreenshot ts = (TakesScreenshot) driver;

            // 2.Aşama alınacak Ekran görüntü dosyası tipi seçilerek hafızada oluşturuldu.
            File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);

//          3.Aşama ekranDosyasını bir dosyaya yazma / kopyalama işlemi yapılıyor.

//          DosyaKopyala (ekranDosyası, ekranGoruntusu.png);
//          Yukarıdaki komut JAVA nın içinde yok, bunun için diğer yapılmış bir kütüphane bulup
//           AYNI SELENIUM eklediğimiz ekleyeceğiz. bu kütüphane common.io bu apache isimli siteden
//          https://mvnrepository.com/artifact/commons-io/commons-io
//          dosya adı --> commons-io-2.7

            FileUtils.copyFile(ekranDosyasi,new File("ekranGoruntuleri/ORANGEhrm/LoginKontrol.png"));
            // hafızadaki ekrandosyasını al bunu verdiğim yola ve isme kaydet.
            // jpg,bmp,gif... olabilir.
 }

        Thread.sleep(3000);
        driver.quit();
    }
}
