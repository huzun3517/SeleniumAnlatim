package Gun14;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class _06_ScrollToWebElement extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://triplebyte.com/");

        // Top engineering roles come to you --> bu yazıya kadar git
        WebElement element = driver.findElement(By.xpath("//h4[text()='Top engineering roles come to you']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();",element);
        // arguments[0]      :  virgülden sonraki ilk eleman
        // scrollIntoView()  :  gözükene kadar scroll yap

        System.out.println("Test başarılı...");
        Thread.sleep(5000);
        driver.quit();

    }
}
