package Gun06.cssSelector;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class cssSelector extends BaseStaticDriver {

        public static void main(String[] args) throws InterruptedException {

            driver.get("https://formsmarts.com/form/yu?mode=h5");
            driver.manage().window().maximize();

            //Business
            WebElement businessRadio=driver.findElement(By.cssSelector("input[id$='4586_0']"));
            businessRadio.click();
            Thread.sleep(1000);

            //discover XYZ?
            WebElement dropdownDiscover=driver.findElement(By.cssSelector("select[id$='_4588']"));
            dropdownDiscover.click(); // select e tıklattım
            Thread.sleep(1000);

            //Online Advertising
            WebElement optionOnlineAdvertising=driver.findElement(By.cssSelector("option[value='Online Advertising']"));
            optionOnlineAdvertising.click(); // seçime tıklattım
            Thread.sleep(1000);

            //Every Day
            WebElement buttonEveryDay=driver.findElement(By.cssSelector("input[value='Every Day']"));
            buttonEveryDay.click();
            Thread.sleep(1000);

            //Good
            WebElement goodRadio=driver.findElement(By.cssSelector("input[value='Good']"));
            goodRadio.click();
            Thread.sleep(1000);

            //How long have you been using XYZ? altındaki Select menüsü
            WebElement howLongDropdown=driver.findElement(By.cssSelector("select[id$='_4597']"));
            howLongDropdown.click(); //
            Thread.sleep(1000);

            // Select menüsünün 3.indeksi 4.elemanını buluyorum.
            WebElement secenek4=driver.findElement(By.cssSelector("select[id$='_4597'] > :nth-child(4)"));
            secenek4.click(); //

            Thread.sleep(15000);

            driver.quit();
        }
}