package Gun08;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _04_SelectEBay extends BaseStaticDriver {

    public static void main(String[] args) {

/*
TODO      Senaryo :
          1- https://www.ebay.com/ sitesini açın
          2- Arama seçim menüsünden 2984  değerli elemanı seçtiriniz.
          3- Arama işlemini yaptırınız.

 */

        driver.get("https://www.ebay.com/");

//TODO  sitelerin bizim bilgilerimizi tutarak bazen engel çıkardığı cookies leri sildik.
        driver.manage().deleteAllCookies();

        driver.manage().window().maximize();

        WebElement menuDropDown= driver.findElement(By.cssSelector("#gh-cat"));
        Select menu= new Select(menuDropDown);
        menu.selectByValue("2984");

        WebElement ara= driver.findElement(By.cssSelector("#gh-btn"));
        ara.click();

        System.out.println("Test Başarılı...");

    }
}