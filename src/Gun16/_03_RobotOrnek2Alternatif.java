package Gun16;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class _03_RobotOrnek2Alternatif extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException, AWTException {

        driver.get("http://demo.guru99.com/test/upload/");

        // masaüstünde ornek.txt adında bir metin belgesi oluşturduk koddan önce
        // Dosya seç butonuna senKeys olrak masaüstünde yeralan metin belgesinin yolu yazıldı.
        WebElement input = driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\Faruk_PC\\Desktop\\ornek.txt");

        // Submit butonuna tıklatıldı
        WebElement buttonSubmit = driver.findElement(By.id("submitbutton"));
        buttonSubmit.click();

        System.out.println("Test başarılı");

        Thread.sleep(2000);

        driver.quit();

    }
}
