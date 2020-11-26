package Gun14;

import _util.BaseStaticDriver;
import org.openqa.selenium.JavascriptExecutor;

public class _04_Scrollintro extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
            Selenium da Sayfayı aşağı kaydırılması gereken durumlar vardır:
            Bunlar , sayfa kaydırıldıkça yüklenen elemanlar için ve sayfanın üstünde oluşan
            ek popuplar ın konumunun kaydırılmasıdır. Çünkü üzerinde popup olan eleman tıklatılamaz.

TODO        Bu işlem javascript executer ile yapılır.Bu interface sayesinde
            sayfa kaydırma işlemi ve javascript komutları çalıştırılabilir sayfa üzerinde.
 */


        driver.get("https://triplebyte.com/");

        // JavaScript komutlarını çalıştırmak için önce js değişkeni tanımlandı.
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 5000)");
        // javascript komutu internetten bulunarak , executeScript metodu ile çalıştırıldı
        // window.scrollBy(0, 5000)  : window u kaydı x ve y miktarınca.
        // Burada sayfa 5000 pixel kaydırıldı.

        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -2000)");
        // Burada sayfa -2000 pixel kaydırıldı.  - (eksi verildiğinden yukarı kaydırıldı.)

        Thread.sleep(5000);
        driver.quit();

    }
}
