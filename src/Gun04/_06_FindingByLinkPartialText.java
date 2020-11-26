package Gun04;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _06_FindingByLinkPartialText extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com");

        driver.manage().window().maximize();

        //Our Passion
        WebElement e = driver.findElement(By.partialLinkText("Passion"));
        System.out.println(e.getAttribute("href"));

        Thread.sleep(3000);

        driver.quit();


    }
}
