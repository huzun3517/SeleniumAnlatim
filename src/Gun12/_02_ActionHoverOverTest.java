package Gun12;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _02_ActionHoverOverTest extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.etsy.com/");

        driver.manage().window().maximize();

        Thread.sleep(1000);

        //Ekranda çıkan Çerezlere tıklattık
        WebElement cerez = driver.findElement(By.cssSelector("button.wt-btn.wt-btn--secondary.wt-width-full"));
        cerez.click();

        Thread.sleep(1000);

        //KLEIDUNG & SCHUHE ACTION CLASS
        WebElement clothingMenu = driver.findElement(By.cssSelector("span#catnav-primary-link-10923"));

        Actions builder = new Actions(driver);

        Action build = builder.moveToElement(clothingMenu).build();
        build.perform();

        Thread.sleep(2000);

        //KINDER & BABYS ACTION CLASS
        WebElement kidsMenu = driver.findElement(By.cssSelector("span#side-nav-category-link-10941"));
        build = builder.moveToElement(kidsMenu).build();
        build.perform();


        System.out.println("Test başarılı...");

        Thread.sleep(2000);
        driver.quit();
    }
}