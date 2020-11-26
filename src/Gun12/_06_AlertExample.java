package Gun12;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _06_AlertExample extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.manage().window().maximize();

        Thread.sleep(1000);

        //Delete Customer Form
        WebElement customer = driver.findElement(By.cssSelector("input[name='cusid']"));
        customer.sendKeys("Hasan");

        // Submit Button
        WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit']"));
        submitButton.click();

        // Alert in text Mesajı -->getText
        String alertMesaj = driver.switchTo().alert().getText();
        System.out.println(alertMesaj);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        System.out.println("Test başarılı...");

        Thread.sleep(2000);
        driver.quit();
    }
}