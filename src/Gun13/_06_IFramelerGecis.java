package Gun13;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _06_IFramelerGecis extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://chercher.tech/practice/frames");

        //1.Frame Gidildi. Türkiye diye yazıldı.
        driver.switchTo().frame("frame1");
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        input.sendKeys("Türkiye");

        driver.switchTo().defaultContent(); // Ana sayfaya geri getiriyor gittiğim frame den(sayfadan)
//      driver.switchTo().parentFrame(); // bir geri sayfaya git demektir. Yukarıdaki kodla aynı işi görüyor.

        // 2.Frame geçilecek ama öncesinde ana sayfaya gitmem gerekiyor.
        driver.switchTo().frame("frame2");

        WebElement frame2Yazi = driver.findElement(By.xpath("//b[text()='Animals : ']"));
        System.out.println(frame2Yazi.getText());

        System.out.println("Test başarılı");

        Thread.sleep(2000);

        driver.quit();

    }
}
