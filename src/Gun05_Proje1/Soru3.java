package Gun05_Proje1;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru3 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("https://www.snapdeal.com/"); // siteyi açtım

        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.cssSelector("[id=inputValEnter]"));
        search.sendKeys("teddy bear");

        driver.findElement(By.className("searchTextSpan")).click();

        // DOĞRULATMA BÖLÜMÜ
        WebElement kontrol = driver.findElement(By.className("nnn"));
        String s = kontrol.getText();
        Assert.assertEquals("We've got 965 results for 'teddy bear'",s);
        System.out.println("ekrandaki yazı doğrulandı...");

        WebElement logo = driver.findElement(By.className("cur-pointer"));
        logo.click();

        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.snapdeal.com/",url);
        System.out.println("url doğrulandı...");

        System.out.println("test başarılı");

        Thread.sleep(3000);
        driver.quit();
    }
}