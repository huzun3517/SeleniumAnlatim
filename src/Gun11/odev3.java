package Gun11;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class odev3 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
        Ödev 3: http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html
        buradaki bütün şehirleri bütün ülkere doğru şekilde topluca dağıtınız.
*/

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");

        List<WebElement> sehirlerList = driver.findElements(By.cssSelector("#allItems>li"));
        List<WebElement> ulkelerList = driver.findElements(By.cssSelector("#dhtmlgoodies_mainContainer>div>ul"));

        Actions actions = new Actions(driver);

        Action action;
        Thread.sleep(500);

        for (WebElement sehir : sehirlerList) {

            for (WebElement ulke : ulkelerList) {

                action = actions.clickAndHold(sehir).moveToElement(ulke).release(ulke).build();
                action.perform();

                if (sehirlerList.get(sehirlerList.size() - 1) == sehir) {
                    System.out.println("Son işlem...");
                    Thread.sleep(3000);
                    driver.switchTo().alert().accept();   // acilan JavaScript penceresini kapatmak icin
                    Thread.sleep(3000);
                }
                if (sehir.getCssValue("background-color").equals("rgba(0, 128, 0, 1)")) break;

            }
        }

        Thread.sleep(2000);
        System.out.println("Test başarılı...");
        driver.quit();

    }
}