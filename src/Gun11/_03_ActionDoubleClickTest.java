package Gun11;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _03_ActionDoubleClickTest extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //Double Click Me Butonu
        WebElement doubleClickButton = driver.findElement(By.cssSelector("button#doubleClickBtn"));

        Actions builder = new Actions(driver);

        Action build = builder.moveToElement(doubleClickButton).doubleClick().build();

        Thread.sleep(2000);

        build.perform();

        System.out.println("Test başarılı...");

        Thread.sleep(3000);
        driver.quit();
    }
}
