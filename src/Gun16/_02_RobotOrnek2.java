package Gun16;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class _02_RobotOrnek2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException, AWTException {

        driver.get("http://demo.guru99.com/test/upload/");

        /*    Aşağıdaki bölüm açılan reklamı kapatıyor... */
        WebDriverWait bekle = new WebDriverWait(driver,10);
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.id("flow_close_btn_iframe")));
        //bekle.until(ExpectedConditions.visibilityOf()) bu kullanılamadı çünkü WebElement istiyor, halbuki zaten element yok.
        // o yüzden yukarıda locator dan yola çıktık.

        // Ekrandaki video penceresini kapatma
        driver.switchTo().frame("flow_close_btn_iframe");
        WebElement kapatButonu= driver.findElement(By.id("closeBtn"));
        kapatButonu.click();

        driver.switchTo().defaultContent(); // Anasayfaya geri döndük

        Thread.sleep(5000);

        WebElement btnUpload = driver.findElement(By.cssSelector("div#file_wraper0"));
        btnUpload.click();

        // Stringi hafızaya-clipboard a kopyalama kodu
        StringSelection stringSelection = new StringSelection("C:\\Users\\Faruk_PC\\Desktop\\ornek.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection , null);
        // Verilen String i clipboard a set ediyor.

        Robot rbt = new Robot();

        Thread.sleep(4000);
        rbt.keyPress(KeyEvent.VK_CONTROL); // Ctrl tuşa basıldı.
        rbt.keyPress(KeyEvent.VK_V); // V tuşuna basıldı.
        // üst satırlarda hafızaya kopyalama yapılmıştı şimdi ise Ctrl + V ye basılıp yapıştırma yapıldı

        // Basılılı olan Ctrl ve V tuşunu serbest bıraktık.
        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_V);

        // Enter a bastık
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER); // Enter ı serbest bıraktık

        System.out.println("Test başarılı");

        Thread.sleep(2000);

        driver.quit();

    }
}
