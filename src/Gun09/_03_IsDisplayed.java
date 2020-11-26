package Gun09;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _03_IsDisplayed extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.facebook.com/");
        driver.manage().deleteAllCookies(); // sitelerin bizim bilgilerimizi tutarak bazen engel çıkardığı
                                            // cookies leri sildik.
        driver.manage().window().maximize();

        WebElement btnYeniHesap=driver.findElement(By.cssSelector("a[id^='u_'][id$='_2']"));
        btnYeniHesap.click();

        Thread.sleep(3000);

        //FACEBOOK 1.E-MAİL BÖLÜMÜ
        WebElement email=driver.findElement(By.cssSelector("input[id^='u_'][id$='_g']"));

        //FACEBOOK 2.E-MAİL BÖLÜMÜ
        WebElement tEmail=driver.findElement(By.cssSelector("input[id^='u_'][id$='_j']"));

        System.out.println(tEmail.isDisplayed()); //--> false önce görünür değil
        email.sendKeys("ismet@hotmail.com");

        System.out.println(tEmail.isDisplayed()); // --> true  çünkü 1.E-Mail girilince 2.si aktif oluyor
        tEmail.sendKeys("ismet@hotmail.com");

        Thread.sleep(3000);
        driver.quit();
    }
}
