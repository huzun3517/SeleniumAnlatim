package Gun08;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _03_SelectClassGiris extends BaseStaticDriver {

   /*
TODO        select  class ı
            görünen text ile seçim:  selectByVisibleText
            value si ile seçim    :  selectByValue
            indexi ile seçim      :  selectByIndex

TODO        seçim yaptırılabilir.

TODO        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

TODO        Select menu = new Select(dropDownMenu);

TODO        menu.selectByVisibleText("Automotive");
            menu.selectByValue("search-alias=automotive-intl-ship");
            menu.selectByIndex(2);
     */

    public static void main(String[] args) throws InterruptedException {

/*
TODO  Senaryo :
      1- https://www.amazon.com/ sitesine gidin.
      2- "Books" i seçin
      3- Arama butonuna tıklatarak sonuçları gösterin.

*/

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement menuDropDown= driver.findElement(By.id("searchDropdownBox"));
        Select menu= new Select(menuDropDown);
        menu.selectByVisibleText("Books");

        WebElement ara= driver.findElement(By.id("nav-search-submit-text"));
        ara.click();

        System.out.println("Test Başarılı...");

        Thread.sleep(6000);
        driver.quit();
    }


}
