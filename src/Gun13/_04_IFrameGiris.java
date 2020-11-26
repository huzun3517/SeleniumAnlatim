package Gun13;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _04_IFrameGiris extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://chercher.tech/practice/frames");

//        driver.switchTo().frame(0); // index ile de bulunabilir. (1.YOL)

          driver.switchTo().frame("frame1"); // id veya name ile de bulunabilir. (2.YOL)

//        WebElement cerceve1 = driver.findElement(By.id("frame1")); // element olarak bulunup
//        driver.switchTo().frame(cerceve1); // bu şekilde de diğer sayfaya geçilebilir. (3.YOL)

        // Topic --> frame1
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        input.sendKeys("Almanya");

        System.out.println("Test başarılı");

        Thread.sleep(2000);

        driver.quit();

    }
}