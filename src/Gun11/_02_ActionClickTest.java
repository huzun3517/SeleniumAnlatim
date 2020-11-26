package Gun11;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _02_ActionClickTest extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        driver.manage().deleteAllCookies(); // sitelerin bizim bilgilerimizi tutarak bazen engel çıkardığı cookies leri sildik.
        driver.manage().window().maximize();

        //Click Me Butonu
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Thread.sleep(1000);

        // builder--> inşa etmek
        Actions builder = new Actions(driver); // driver üzerinden aksiyonları çalıştırmak için değişken tanımladım

        Action build = builder.moveToElement(clickButton).click().build(); // aksiyonlar değişkenine bir aksiyon ekledim.
        // Henüz işlem olmadı.

        build.perform();

        System.out.println("Test başarılı...");

        Thread.sleep(3000);
        driver.quit();
    }
}
