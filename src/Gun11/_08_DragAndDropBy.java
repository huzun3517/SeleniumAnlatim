package Gun11;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _08_DragAndDropBy extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");

        driver.manage().window().maximize();

        WebElement slider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]"));

        Actions builder = new Actions(driver);
        Action build = builder.dragAndDropBy(slider,100,0).build();

        Thread.sleep(5000);
        build.perform();

        System.out.println("Test başarılı...");

        Thread.sleep(6000);
        driver.quit();
    }
}