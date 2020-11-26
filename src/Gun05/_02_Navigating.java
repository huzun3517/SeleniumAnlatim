package Gun05;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_Navigating extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("http://www.practiceselenium.com");

        Thread.sleep(1000);
        WebElement link=driver.findElement(By.linkText("Check Out"));
        link.click(); // tıklatma

        Thread.sleep(1000);
        driver.navigate().back(); // geri

        Thread.sleep(1000);
        driver.navigate().forward();// ileri

        driver.manage().window().maximize(); // tarayıcıyı tam ekran yapıyor

        Thread.sleep(2000);
        driver.quit();
    }
}
