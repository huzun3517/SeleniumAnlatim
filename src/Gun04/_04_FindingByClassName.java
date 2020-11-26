package Gun04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class _04_FindingByClassName {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver","C:/Users/Faruk_PC/Selenium/ChromeDriver/chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("http://www.practiceselenium.com");

        driver.manage().window().maximize();

        //Loose Tea
        WebElement e = driver.findElement(By.className("editor_collections"));
        System.out.println(e.getText());


        Thread.sleep(3000);
        driver.quit();
    }
}
