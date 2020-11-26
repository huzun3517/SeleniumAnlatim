package Gun11;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _09_ActionTusKontrolSendKeys extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/auto-complete");

        driver.manage().window().maximize();

        // Ahmet --> Shift e basılı durumdayken a tuşuna basarsınız, sonra Shift i bırakıp gerisini yazarsınız.

        WebElement textInput = driver.findElement(By.cssSelector("#autoCompleteSingleContainer"));

        Actions builder = new Actions(driver);

        Action build = builder.moveToElement(textInput) // inputa gidildi
                .click()  // içine tıklandı
                .keyDown(Keys.SHIFT) // büyük harf için önce Shift tuşuna basıldı
                .sendKeys("a") // a tuşuna bastığımızda Shift basılı olduğundan büyük yazdı
                .keyUp(Keys.SHIFT) // büyük harf için bastığımız tuş kontrolünü geri aldık
                .sendKeys("hmet") // kalanını küçük harf yazdı
                .build();

        Thread.sleep(2000);

        build.perform();


        System.out.println("Test başarılı...");

        Thread.sleep(2000);
        driver.quit();
    }
}