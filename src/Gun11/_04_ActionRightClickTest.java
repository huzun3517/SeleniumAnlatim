package Gun11;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _04_ActionRightClickTest extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //Right Click Me butonu
        WebElement rightClickMeButton = driver.findElement(By.cssSelector("button#rightClickBtn"));

        Actions builder = new Actions(driver);

        Action build = builder.moveToElement(rightClickMeButton).contextClick().build();

        Thread.sleep(2000);

        build.perform();


        WebElement mesaj = driver.findElement(By.id("rightClickMessage"));
        Assert.assertEquals("You have done a right click",mesaj.getText());

//      Assert.assertTrue("You have done a right click" == mesaj.getText());

        System.out.println("Test başarılı...");

        Thread.sleep(3000);
        driver.quit();
    }
}