package Gun16;

import _util.BaseStaticDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class _04_RobotOrnek3 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException, AWTException {

        driver.get("http://demo.guru99.com/test/upload/");

        // Ctrl + S --> kaydet kısayol
        Robot rbt = new Robot();

        rbt.keyPress(KeyEvent.VK_CONTROL); // Ctrl
        rbt.keyPress(KeyEvent.VK_S); // S

        Thread.sleep(2000);

        rbt.keyPress(KeyEvent.VK_CONTROL); // Ctrl serbest
        rbt.keyRelease(KeyEvent.VK_S); // S serbest

        rbt.keyPress(KeyEvent.VK_ENTER); // Enter
        rbt.keyRelease(KeyEvent.VK_ENTER); // Enter serbest

        Thread.sleep(2000);

        rbt.keyPress(KeyEvent.VK_LEFT); // Sol
        rbt.keyPress(KeyEvent.VK_ENTER); // Enter

        rbt.keyRelease(KeyEvent.VK_LEFT); // Sol serbest
        Thread.sleep(2000);

        rbt.keyRelease(KeyEvent.VK_ENTER); // Enter serbest

        System.out.println("Test başarılı");

        Thread.sleep(2000);

        driver.quit();

    }
}
