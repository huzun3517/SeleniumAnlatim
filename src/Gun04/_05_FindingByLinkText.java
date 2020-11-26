package Gun04;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _05_FindingByLinkText extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com");
        driver.manage().window().maximize();

        //Check Out
        WebElement e = driver.findElement(By.linkText("Check Out"));
        System.out.println(e.getAttribute("data-title"));

        Thread.sleep(3000);

        driver.quit();
    }
}