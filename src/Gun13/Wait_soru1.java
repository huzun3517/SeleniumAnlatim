package Gun13;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_soru1 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

 /*TODO     Senaryo
         1- Remove butonuna tıklayınız.
         2- Remove butonu tıklatılınca ekrana mesaj gelene kadar bekletiniz.
         3- Ekrana gelen mesajın doğruluğunu doğrulatınız.
         4- Add butonuna tıklatınız
         5- Add butonu tıklatılınca ekrana mesaj gelene kadar bekletiniz.
         6-Ekrana gelen mesajın doğruluğunu doğrulatınız.
*/

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        // REMOVE BUTTON
        WebElement removeButton= driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();

        // MESAJ GELENE KADAR BEKLETME
        WebElement messageRemove = driver.findElement(By.cssSelector("p#message"));

        WebDriverWait wait=new WebDriverWait(driver, 10);// sadece süre tanımlandı henüz aktif değil.
        wait.until(ExpectedConditions.elementToBeClickable(messageRemove));

        // REMOVE MESAJINI DOĞRULATMA
        System.out.println(messageRemove.getText());

        Assert.assertEquals("It's gone!",messageRemove.getText());
        System.out.println("Remove Mesajı doğrulandı...");

        System.out.println("--------------------------");

        // ADD BUTTON
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();

        // MESAJ GELENE KADAR BEKLETME
        WebElement messageAdd = driver.findElement(By.cssSelector("p#message"));
        wait.until(ExpectedConditions.elementToBeClickable(messageAdd));

        // ADD MESAJINI DOĞRULATMA
        System.out.println(messageAdd.getText());
        Assert.assertEquals("It's back!",messageAdd.getText());
        System.out.println("Add Mesajı doğrulandı...");

        System.out.println("\nTest başarılı...");

        Thread.sleep(6000);
//        driver.quit();
    }
}
