package Gun16;

import _util.BaseStaticDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _01_Robot_Intro extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException, AWTException {

/*TODO
             İnterview Soruları :
     1- Windows popupları nasıl kontrol edersiniz ? Robot class la
     2- Dosya yükleme işlemini ne ile yaparsınız ? Robot class la
*/

        driver.get("https://www.cleartrip.com/");

        Robot rbt = new Robot();

        // Tab tuşuna basarak X nın üzerine geldik.
        Thread.sleep(4000);
        rbt.keyPress(KeyEvent.VK_TAB); // keyPress ile TAB tuşuna basıldı.
        rbt.keyRelease(KeyEvent.VK_TAB); // keyRelease ile TAB tuşu bırakıldı.

        // Tab tuşuna basarak İzin ver butonunun üzerine geldik.
        Thread.sleep(2000);
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);

        // Tab tuşuna basarak Engelle butonunun üzerine geldik.
        Thread.sleep(4000);
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);

        // Enter tuşuna basıldı ve bırakıldı
        Thread.sleep(4000);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Test başarılı");

        Thread.sleep(2000);

        driver.quit();

    }
}
