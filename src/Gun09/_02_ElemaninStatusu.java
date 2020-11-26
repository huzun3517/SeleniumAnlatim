package Gun09;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_ElemaninStatusu extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
        boolean isEnabled();  -> Kullanılabiliyor mu?
        boolean isSelected(); -> seçili mi?  checkbox, radiobutton
        boolean isDisplayed(); -> Görünüyor mu?

TODO    isEnabled
        Monday -> true
        Sunday -> false

TODO    isSelected();
        Tuesday -> true
        Thursday -> false


TODO    isDisplayed();
        Monday -> true
        Sunday -> true
*/

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //TUESDAY BUTONU
        WebElement tuesday = driver.findElement(By.cssSelector("#gwt-debug-cwCheckBox-Tuesday-input"));
        System.out.println(tuesday.isDisplayed()); // gözüküyor --> true
        System.out.println(tuesday.isEnabled()); // kullanılabilir durumda -->true
        System.out.println(tuesday.isSelected()); // seçili değil -->false

        Thread.sleep(3000);
        tuesday.click();
        System.out.println(tuesday.isSelected()); // son aşamada seçildi -->true

        //SUNDAY butonu
        WebElement sunday = driver.findElement(By.id("gwt-debug-cwCheckBox-Sunday-input"));
        System.out.println(sunday.isEnabled()); // kullanılabilir durumda -->false

        Thread.sleep(3000);
        driver.quit();

//TODO        isDisplayed() özlliği bir önceki günün facebook sayfasındaki 2.emailde gösterildi.
    }
}