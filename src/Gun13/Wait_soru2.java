package Gun13;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_soru2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

 /*TODO     Senaryo
         1- Enable butonuna tıklayınız.
         2- Enable butonuna tıklandıktan sonra ekrana mesaj gelene kadar bekletiniz.
         3- Ekrana gelen mesajın doğruluğunu doğrulatınız.
         4- Checkbox ın kullanılabilirliğini kontrol ediniz.
         5- Disable butonuna tıklayınız.
         6- Disable butonuna tıklandıktan sonra ekrana mesaj gelene kadar bekletiniz.
         7- Ekrana gelen mesajın doğruluğunu doğrulatınız.
         8- Checkbox ın kullanılabilirliğini kontrol ediniz.
*/

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // ENABLE BUTTON
        WebElement enableButton= driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();

        // MESAJ GELENE KADAR BEKLETME
        WebElement messageEnable = driver.findElement(By.cssSelector("p#message"));

        WebDriverWait wait=new WebDriverWait(driver, 15);// sadece süre tanımlandı henüz aktif değil.
        wait.until(ExpectedConditions.elementToBeClickable(messageEnable));

        // ENABLE MESAJINI DOĞRULATMA

        System.out.println(messageEnable.getText());

        Assert.assertEquals("It's enabled!",messageEnable.getText());
        System.out.println("Enable Mesajı doğrulandı...");

        WebElement checkbox = driver.findElement(By.cssSelector("form#input-example>input"));
        Assert.assertTrue(checkbox.isEnabled());
        System.out.println("Checkbox kullanılabilir");

        System.out.println("------------------------------");

        // DİSABLE BUTTON
        WebElement disableButton= driver.findElement(By.xpath("//button[text()='Disable']"));
        disableButton.click();

        // MESAJ GELENE KADAR BEKLETME
        WebElement messageDisable = driver.findElement(By.cssSelector("p#message"));

        wait.until(ExpectedConditions.elementToBeClickable(messageDisable));

        // DİSABLE MESAJINI DOĞRULATMA

        System.out.println(messageDisable.getText());

        Assert.assertEquals("It's disabled!",messageDisable.getText());
        System.out.println("Disable Mesajı doğrulandı...");

        WebElement checkbox2 = driver.findElement(By.cssSelector("form#input-example>input"));
        Assert.assertFalse(checkbox2.isEnabled());
        System.out.println("Checkbox kullanılamaz");

        System.out.println("Test başarılı...");

        Thread.sleep(6000);
        driver.quit();
    }
}
