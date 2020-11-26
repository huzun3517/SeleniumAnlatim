package Gun11;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _07_ActionDragAndDropTest3 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        driver.manage().window().maximize();

        WebElement krediButton = driver.findElement(By.id("credit1"));

        WebElement kutu = driver.findElement(By.id("loan"));

        Actions builder = new Actions(driver);

 //       1.YÖNTEM
 //       Action build = builder.dragAndDrop(krediButton,kutu).build();
 //       build.perform();

        Action build = builder.clickAndHold(krediButton).moveToElement(kutu).release().build();
        build.perform();
        // kredi butonuna tıklat ve eline al, sonra hedefe git yani
        // bırakacağın yere git, ve release yani gerçekleştir, yani bırak.
        System.out.println("Test başarılı...");

        Thread.sleep(6000);
        driver.quit();
    }
}