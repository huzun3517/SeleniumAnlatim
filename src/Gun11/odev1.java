package Gun11;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class odev1 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
        Ödev 1 : http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
        buradaki ülke ve şehirleri findElements ile topluca bularak bir döngü ile bütün şehirleri doğru ülkere dağıtınız.
*/

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        List<WebElement> ulkeler = driver.findElements(By.cssSelector("div#questionDiv>div.destinationBox"));
        List<WebElement> baskentler = driver.findElements(By.cssSelector("div#answerDiv>div"));

        Actions actions = new Actions(driver);

        Action action;

        for (WebElement sehir: baskentler )
        {
            System.out.println();

            for (WebElement ulke : ulkeler) {

                if (ulke.getText().length() != 0) continue;  // dolu olan kutulari atlamak icin

                action = actions.clickAndHold(sehir).moveToElement(ulke).release(ulke).build();
                action.perform();

                System.out.print(sehir.getCssValue("background-color"));

                if(sehir.getCssValue("background-color").equals("rgba(0, 128, 0, 1)")) break;
                Thread.sleep(100);
            }
        }
        System.out.println("\n\nTest başarılı...");

        Thread.sleep(2000);
        driver.quit();
    }
}