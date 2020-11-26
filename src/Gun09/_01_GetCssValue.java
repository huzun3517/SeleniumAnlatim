package Gun09;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _01_GetCssValue extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.snapdeal.com/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //Search products Çubuğu
        WebElement btn=driver.findElement(By.id("inputValEnter"));

//TODO   tag in içdeki keylerin değerlerini almamızı sağlar
        System.out.println(btn.getAttribute("name"));
        System.out.println(btn.getAttribute("type"));
        System.out.println(btn.getAttribute("class"));

        System.out.println("------------------------------------");

        // Search Butonu
        WebElement btnAra=driver.findElement(By.className("searchformButton"));

        // Elemeanın CSS yani ekran gözüken tüm özelliklerini; font renk vs ulaşmamızı sağlar
        System.out.println(btnAra.getCssValue("color"));
        System.out.println(btnAra.getCssValue("font-size"));
        System.out.println(btnAra.getCssValue("background"));

        Thread.sleep(3000);
        driver.quit();
    }
}