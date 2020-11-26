package Gun17;

import _util.BaseStaticDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class _03_EkranKaydet extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException, IOException {

/*TODO
   Senaryo :
        1- https://opensource-demo.orangehrmlive.com/  sitesine gidiniz.
        2- Şifreyi hatalı vererek Login işlemini yapınız.
        3- ekran görünütüsnü kaydediniz.
 */

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement username=driver.findElement(By.id("txtUsername"));
        username.sendKeys("Admin");

        WebElement password=driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin1234");

        WebElement btnLogin=driver.findElement(By.id("btnLogin"));
        btnLogin.click();

        WebElement hataText = driver.findElement(By.cssSelector("span#spanMessage"));

        System.out.println(hataText.getText());

        Assert.assertEquals("doğru giriş yapıldı...","Invalid credentials",hataText.getText());

        System.out.println("Test Failed");
        // Ekran kaydetme işlemleri burada olacak.

        // 1. Aşama ekran görüntüsü alma değişkenimizi tanımladık.
        TakesScreenshot ts= (TakesScreenshot) driver;

        // 2. Aşama alınacak Ekran görüntü dosyası tipi seçilerek hafızada oluşturuldu.
        File ekranDosyasi = ts.getScreenshotAs(OutputType.FILE);

        // 3.Aşama ekranDosyasını bir dosyaya yazma/kopyalama işlemi yapılıyor.
        // DosyaKopyala (ekranDosyası, ekranGoruntusu.png);
        // Yukarıdaki komut JAVA nın için de yok, bunun için diğer yapılmış bir kütüphane
        // bulup AYNI SELENYUMU eklediğimiz ekleyeceğiz. bu kütüphane common.io bu apache isimli siteden indirilecek.
        FileUtils.copyFile(ekranDosyasi, new File("ekranGoruntuleri/ORANGEhrm/LoginGirisKontrol.png"));
        // hafızadaki ekranDosyasi nı al bunu verdiğim yola ve isme kaydet.
        // jpg,bmp,gif .. olabilir.

        Thread.sleep(5000);
        driver.quit();

    }
}
