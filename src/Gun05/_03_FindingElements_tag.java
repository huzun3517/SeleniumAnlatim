package Gun05;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class _03_FindingElements_tag extends BaseStaticDriver {

        public static void main(String[] args) throws InterruptedException {

            driver.get("http://www.practiceselenium.com");

        //    WebElement e = driver.findElement();

            List<WebElement> liste = driver.findElements(By.tagName("li")); // tagname yani etiketi li olan bütün elemanlar

            for (WebElement e: liste) {
                System.out.println(e.getText());
            }

            Thread.sleep(3000);
            driver.quit();
        }
    }