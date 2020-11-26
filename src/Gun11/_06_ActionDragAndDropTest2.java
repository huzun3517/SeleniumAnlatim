package Gun11;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _06_ActionDragAndDropTest2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
   Senaryo :
   1- http://demo.guru99.com/test/drag_drop.html Siteyi açınız.
   2- Bank butonunu sürükleyerek alttaki ilk kutucuğa bırakınız.
   3- Daha sonra kutucuk içinde BANK butonunun textini kontrol ediniz.
   4- Assert ile doğrulayınız.
 */


        driver.get("http://demo.guru99.com/test/drag_drop.html");

        driver.manage().window().maximize();

        WebElement bankButton=driver.findElement(By.id("credit2"));
        WebElement kutu=driver.findElement(By.id("bank"));

        Actions builder=new Actions(driver);
        Action build=builder.dragAndDrop(bankButton, kutu).build();
        build.perform();


        WebElement kutuIcerigi=driver.findElement(By.cssSelector("#bank > li"));

        Assert.assertTrue(   kutuIcerigi.getText().equals(bankButton.getText())  );

        System.out.println("Test başarılı...");

        Thread.sleep(6000);
        driver.quit();

    }
}