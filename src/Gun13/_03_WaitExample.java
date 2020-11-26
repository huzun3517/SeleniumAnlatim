package Gun13;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _03_WaitExample extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
      Senaryo
    1-  https://www.demoblaze.com/index.html  siteyi açınız.
    2- Samsung galaxy s6  linkine tıklayınız.
    3- Sepete ekleyiniz.
    4- Çıkan alerte accept yapınız.

     wait.until(ExpectedConditions.alertIsPresent());
*/

        driver.get("https://www.demoblaze.com/index.html");

        //Samsung galaxy s6 link
        WebElement button= driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']"));
        button.click();

        //Add to cart --> Sepete ekle
        WebElement addToCart= driver.findElement(By.cssSelector("a.btn.btn-success.btn-lg"));
        addToCart.click();

        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        System.out.println("Test başarılı...");

        Thread.sleep(6000);
        driver.quit();
    }
}
