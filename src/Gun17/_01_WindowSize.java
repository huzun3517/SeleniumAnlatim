package Gun17;

import _util.BaseStaticDriver;
import org.openqa.selenium.Dimension;

public class _01_WindowSize extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

        Dimension olculer = driver.manage().window().getSize();

        System.out.println(olculer.width); // -->  1382
        System.out.println(olculer.height);// -->  744

        Dimension yeniOlcu = new Dimension(1024,768);
        driver.manage().window().setSize(yeniOlcu);  // yada --> driver.manage().window().setSize(new Dimension(1024,768));

        System.out.println(yeniOlcu.width); // --> 1024
        System.out.println(yeniOlcu.height);// --> 768

        System.out.println("Test başarılı...");

        Thread.sleep(3000);
 //       driver.quit();
    }
}
