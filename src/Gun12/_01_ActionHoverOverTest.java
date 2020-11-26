package Gun12;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class _01_ActionHoverOverTest extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement btnBank=driver.findElement(By.cssSelector("#credit2 > a"));

        Actions builder=new Actions(driver);
        Action build=builder.moveToElement(btnBank).build();

        System.out.println("Mouse Üzerine gelmeden önce renk ="+ Color.fromString(btnBank.getCssValue("color")).asHex());
        build.perform();
        System.out.println("Mouse Üzerine geldikten sonra renk ="+ Color.fromString(btnBank.getCssValue("color")).asHex());

        Thread.sleep(6000);
        driver.quit();
    }
}