package Gun13;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _05_IFrameOrnek extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        // Ekrandaki video penceresini kapatma
        driver.switchTo().frame("flow_close_btn_iframe");
        WebElement kapatButonu= driver.findElement(By.id("closeBtn"));
        kapatButonu.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
