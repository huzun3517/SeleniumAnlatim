package Gun13;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _02_FillingFormTask extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
        İnterview Sorusu :  Implicit ve Explicit

TODO     Implicit : Bütün elemanlar için kullanılır.bir kere tanımlanır.
         Explicit : Tek bir eleman özel Kriter olarak tanımlanır sadece ilgili elemanda geçerli olur
                   ExpectedConditions
                                     .titleIs -> title bu olana kadar bekle
                                     .titleContains -> title ın da bu kelime geçene kadar bekle
                                     .visibilityOfTheElement -> eleman gözükene kadar bekle
                                     .elementToBeClickable -> eleman tıklanabilir olana kadra bekle
                                     .elementToBeSelected -> eleman seçilebilir olana kadra bekle
                                     .alertIsPresent()  -> alert çıkana kadar bekle.
                                     .textToBe -> elemanda verilen txt gözükene kadar bekle.
                                     .InvisibilityOfTheElement -> eleman kaybolana kadar bekle

TODO     Her ikisi tanımlı ise : önce Implicit kullanılır, ve üzerine Explicit in süresi eklenerek
                                  toplam hata sınır süresi ortaya çıkmış olur.

*/

        driver.get("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");

        // Name
        WebElement title= driver.findElement(By.cssSelector("input#title"));
        title.sendKeys("Bekleme Komutu");

        // Comment
        WebElement description= driver.findElement(By.cssSelector("textarea#description"));
        description.sendKeys("Explicit eleman özel kriter oluşana kadar bekleme şeklidir");

        // Submit Buton
        WebElement buttonSubmit= driver.findElement(By.cssSelector("input#btn-submit"));
        buttonSubmit.click();

        WebDriverWait wait=new WebDriverWait(driver, 5);

        Boolean yaziOlustu = wait.until(ExpectedConditions.textToBe(By.xpath("//div[text()='Form submited Successfully!']"),"Form submited Successfully!"));
        System.out.println("İşlem tamamlandı mı? " + yaziOlustu);

        System.out.println("Test başarılı...");

        Thread.sleep(6000);
        driver.quit();
    }
}
