package Gun14;

import _util.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _01_OpenWindows extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.selenium.dev/");

        // Sayfada yeni pencere açan linkleri bulmak için target=_blank attribute olan a (link) tagleri bulundu.
        List<WebElement> linkler = driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement link: linkler) {

            link.click();
        }

        // driverdan bu açılan yeni pencerelerin id leri alındı.Bu idlerin driver.getWindowHandles() ile
        // alıyoruz. üretilen idler Set<String> olarak döndüğünden bu tür bir değişkene aldık.
        Set<String> windowIdleri = driver.getWindowHandles();

        // idleri yazdırdık.
        for (String id: windowIdleri) {
            System.out.println(id);
        }

//        CDwindow-C66B36A6E1EB488D0A159938513869A5
//        CDwindow-FB2D632626CCC07395FC93E8B03B97AC
//        CDwindow-A56A183BA7498CCF588B6C402D3B6C20

        System.out.println("Test başarılı");

        Thread.sleep(2000);

        driver.quit();

    }
}
