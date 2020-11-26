package Gun04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class _03_FindingBlydNotFoundException {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.practiceselenium.com");

        driver.manage().window().maximize();

        try {
            WebElement e = driver.findElement(By.id("bulamadiginda ne olacak"));
            System.out.println(e.getText());

        }catch (Exception ex) {

            System.out.println("eleman bulunamadı" + ex.getMessage());
        }

        Thread.sleep(3000);

        driver.quit();
    }
}
