package Gun15_Proje3;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class proje3 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://app.hubspot.com/login"); // siteyi açtım //

        String anaSayfaIDsi = driver.getWindowHandle();
        System.out.println("Ana Sayfa ID = " + anaSayfaIDsi);

        WebDriverWait wait=new WebDriverWait(driver, 30);

        // E-MAIL BOLUMU
        WebElement eMail = driver.findElement(By.cssSelector("input#username"));
        eMail.sendKeys("huzun3517@gmail.com");

        // PASSWORD BOLUMU
        WebElement password = driver.findElement(By.cssSelector("input#password"));
        password.sendKeys("Huseyin1453");

        // LOGIN BOLUMU
        WebElement loginButton = driver.findElement(By.cssSelector("button#loginBtn"));
        loginButton.click();

        Thread.sleep(500);

        // Sales BOLUMU
        WebElement salesButton = driver.findElement(By.xpath("(//a[@class='primary-link'])[5]"));
        salesButton.click();

        Thread.sleep(500);

        // Deals BOLUMU
        WebElement dealsButton = driver.findElement(By.cssSelector("a#nav-secondary-deals"));
        dealsButton.click();

        Thread.sleep(500);

        //refresh yaptık
        driver.navigate().refresh(); // sayfayı yeniledik.

        Thread.sleep(500);

        // Create Deal BOLUMU
        WebElement createDeal = driver.findElement(By.xpath("//span[text()='Create deal']"));
        createDeal.click();

        // Deal name BOLUMU
        WebElement dealName = driver.findElement(By.cssSelector("input#UIFormControl-19"));
        dealName.sendKeys("Hüseyin");

        // Sales Pipeline BOLUMU
        WebElement salespipeline = driver.findElement(By.xpath("(//span[@class='uiDropdown__buttonCaret private-dropdown__caret private-dropdown__caret--form'])[3]"));
        salespipeline.click();

        Thread.sleep(500);

        //ID LERİ BULDUK. 2.WEBSAYFASINA GEÇTİK.
        Set<String> windowIdler = driver.getWindowHandles();

        for (String ID: windowIdler) {

            if (ID.equals(anaSayfaIDsi)) continue;

            System.out.println(ID);

            driver.switchTo().window(ID);
        }

        // 2.WEB SAYFASININ URL Sİ BURADA ALINDI.
        String url = driver.getCurrentUrl();

       // URL LER ASERT İLE KONTROL EDİLDİ.
        Assert.assertEquals("https://app.hubspot.com/pricing/8445706/sales?upgradeSource=deals-create-deal-general-create-deal-multiple-pipelines-pql-feature-lock&term=annual&edition=starter",url);
        System.out.println("2.Sayfanın url si doğrulandı...");

        Thread.sleep(1000);

        // 2.WEB SAYFASI KAPATILDI
        driver.close();

        // ANA SAYFAYA GEÇİLDİ.
        driver.switchTo().window(anaSayfaIDsi);

        // DEAL STAGE DROPDOWN BÖLÜMÜ
        WebElement elementdealStage = driver.findElement(By.xpath("//span[text()='Appointment scheduled']"));
        elementdealStage.click();

        // RANDOM SEÇTİRDİK.
        List<WebElement> dealStage = driver.findElements(By.cssSelector("ul.private-typeahead-results>li")); //7 tane eleman var.
        int max = dealStage.size();
        dealStage.get(random(0,max)).click();

        Thread.sleep(1000);

        //  Deal Type DROPDOWN BÖLÜMÜ
        WebElement  elementdealtype = driver.findElement(By.xpath("(//span[@class='private-dropdown__button-label uiDropdown__buttonLabel'])[11]"));
        elementdealtype.click();

        // RANDOM SEÇTİRDİK.
        List<WebElement> dealtype = driver.findElements(By.cssSelector("div.Select-menu-outer>div>div")); //3 tane var 1.si boş
        max = dealtype.size();
        dealtype.get(random(1,max)).click();

        Thread.sleep(2000);

        //  create BÖLÜMÜ
        WebElement  create = driver.findElement(By.xpath("//span[@class='private-loading-button__content private-button--internal-spacing']"));
        create.click();

        Thread.sleep(20000);

        //  KALEM BÖLÜMÜ
        WebElement  kalem = driver.findElement(By.xpath("(//span[@class='UIIcon__IconContent-sc-1ngbkfp-0 bVjkIp'])[1]"));
        kalem.click();

        // DEAL NAME DEĞİŞTİRME BÖLÜMÜ
        WebElement nameDeal = driver.findElement(By.cssSelector("input[id^='UIFormControl-']"));
        wait.until(ExpectedConditions.elementToBeClickable(nameDeal));

        nameDeal.clear();
        Thread.sleep(500);
        nameDeal.sendKeys("Ömer Faruk");

        Thread.sleep(1000);

        //  SAVE BÖLÜMÜ
        WebElement  save = driver.findElement(By.xpath("//i18n-string[text()='Save']"));
        save.click();

        Thread.sleep(1000);

        //  NAME DEĞİŞİKLİĞİ DOĞRULAMA
        WebElement  yeniName = driver.findElement(By.cssSelector("h3[class^='m-bottom']"));
        Assert.assertEquals("Ömer Faruk", yeniName.getText());
        System.out.println("Yeni deal Name doğrulandı...");

        //  Actions BÖLÜMÜ
        WebElement  actions = driver.findElement(By.xpath("//span[text()='Actions']"));
        actions.click();

        Thread.sleep(1000);

        //  Delete BÖLÜMÜ
        WebElement  delete = driver.findElement(By.xpath("//i18n-string[text()='Delete']"));
        delete.click();

        Thread.sleep(1000);

        //  Delete Deal BÖLÜMÜ
        WebElement  deleteDeal = driver.findElement(By.xpath("//i18n-string[text()='Delete deal']"));
        deleteDeal.click();

        //Deal'ın artık görünmediğini doğrulama
        Assert.assertFalse(yeniName.getText().equals(driver.findElement(By.xpath("//span[text()='Deals']")).getText()));

        System.out.println("Deal artık görünmüyor...");

        Thread.sleep(5000);
        driver.quit();
    }

    public static int random(int min, int max) {

        int uretilenSayi = (int) (Math.random() * ((max-min))) + min;

        return uretilenSayi;
    }
}