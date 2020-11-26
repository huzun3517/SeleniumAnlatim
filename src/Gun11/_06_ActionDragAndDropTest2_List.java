package Gun11;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _06_ActionDragAndDropTest2_List extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
   Senaryo :
   1- http://demo.guru99.com/test/drag_drop.html Siteyi açınız.
   2- Bank butonunu sürükleyerek alttaki ilk kutucuğa bırakınız.
   3- Daha sonra kutucuk içinde BANK butonunun textini kontrol ediniz.
   4- Assert ile doğrulayınız.
 */

        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> buttonList = driver.findElements(By.cssSelector("a.button.button-orange"));
        List<WebElement> kutuList = driver.findElements(By.cssSelector("div.shoppingCart"));

        for (WebElement kutu: kutuList)

            for (WebElement button: buttonList) {
                Action action = actions.dragAndDrop(button,kutu).build();
                Thread.sleep(500);
                action.perform();
            }

        //PERFECT YAZISINI DOGRULATMA
        WebElement perfectButton = driver.findElement(By.xpath("//a[text()='Perfect!']"));

        Assert.assertEquals("Başaramadınız...","Perfect!",perfectButton.getText());

        System.out.println("Test başarılı...");

        Thread.sleep(6000);
        driver.quit();

    }
}