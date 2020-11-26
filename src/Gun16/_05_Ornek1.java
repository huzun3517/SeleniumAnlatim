package Gun16;
import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _05_Ornek1 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
    Senaryo
    1- https://www.yogaalliance.org/ sitesine gidiniz.
    2- Become a Member menüsünden  Teachers  a tıklatınız.
    3- Çıkan sayfanın title ının "Teachers | Yoga Alliance"  olup olmadığını assert ile kontrol ediniz.
 */

        driver.get("https://www.yogaalliance.org/");

        Actions actions = new Actions(driver);

        // Become a Member --> yazan Action Class
        WebElement element = driver.findElement(By.xpath("//a[text()='Become a Member']"));

        Action action = actions.moveToElement(element).build();
        action.perform();

        //  Become a Member --> yazan Action Class ın üzerine gelip Teachers tıklandı
        WebElement teacher = driver.findElement(By.xpath("(//a[text()='Teachers'])[2]"));
        teacher.click();

        String beklenen = "Teachers | Yoga Alliance";

        //yeni sayfanın açılmasını burada bekliyoruz.
        WebDriverWait bekle = new WebDriverWait(driver,10);
        bekle.until(ExpectedConditions.titleContains(beklenen));
        // yeni açılan sayfanın title ı beklenen olana kadar bekle

        // Sayfanın title ı alındı
        String title = driver.getTitle();
        System.out.println(title);

        // Assert ile çıkan sayfanın title ı kontrol edildi.
        Assert.assertEquals(title,beklenen);

        System.out.println("Test başarılı");

        Thread.sleep(2000);

        driver.quit();

    }
}