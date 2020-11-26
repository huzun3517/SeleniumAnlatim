package Gun13;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _01_ExplicitWait extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
        WebElement button= driver.findElement(By.cssSelector("button[onclick='timedText()']"));
        button.click();

        //WebElement text= driver.findElement(By.xpath("//p[text()='WebDriver']"));

        // ExplicitWait
        WebDriverWait wait=new WebDriverWait(driver, 45);// sadece süre tanımlandı henüz aktif değil.
        // yukarıdaki tanımlanan bekletme değişkeni başka elemanlarda da kullanılabir.
        // 45 san kullanılmadı eleman bulunduğu anda işleme devam etti.

        WebElement text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
        // Bu locator daki eleman visible olana kadar bekle.
        // Implicit ve Explicit bekleme kullanıldığında ikisini de kullanır.

        System.out.println("Test başarılı...");

        Thread.sleep(6000);
        driver.quit();

    }
}
