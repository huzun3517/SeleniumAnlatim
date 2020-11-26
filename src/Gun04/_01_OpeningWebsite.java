package Gun04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class _01_OpeningWebsite {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // consola yazılan gereksiz bilgileri sessize aldı.

        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");
        // hangi browseri kullanacağımı ve tarayıcının path ini verdim.

        WebDriver driver = new ChromeDriver(); // çalıştıracağımız driveri kontrol edecek değişkeni tanımladım.

        driver.get("http://www.practiceselenium.com"); // siteyi açtım

        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.quit();


    }
}
