package Gun14;

import _util.BaseStaticDriver;
import org.openqa.selenium.JavascriptExecutor;

public class _05_ScrollToBottomOfThePage extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://triplebyte.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        // sayfanın sonuna kadar git.

        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0,0)");

        // scrollTo : Verilen pixele gider.
        // scrollBy : Verilen kadar daha ileri gider.


        System.out.println("Test başarılı...");
        Thread.sleep(5000);
        driver.quit();

    }
}
