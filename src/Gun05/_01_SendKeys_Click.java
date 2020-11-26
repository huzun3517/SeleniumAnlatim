package Gun05;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_SendKeys_Click extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("http://www.practiceselenium.com");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        WebElement link=driver.findElement(By.linkText("Check Out"));
        link.click(); // tıklatma

        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("info@techno.study"); // text gönderme

        WebElement name=driver.findElement(By.id("name"));
        name.sendKeys("ismet"); // text gönderme

        WebElement address=driver.findElement(By.id("address"));
        address.sendKeys("evet artık biz geldik: yeni testerlar"); // text gönderme

        WebElement button = driver.findElement(By.className("btn-primary"));
        button.click();

        WebElement menu = driver.findElement(By.id("wsb-element-00000000-0000-0000-0000-000450914921"));
        String menuTxt = menu.getText();
        Assert.assertEquals("Menu",menuTxt);

        String url = driver.getCurrentUrl();
        Assert.assertEquals("http://www.practiceselenium.com/menu.html?",url);

        Thread.sleep(6000);
        driver.quit();
    }
}
