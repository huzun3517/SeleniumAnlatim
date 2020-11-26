package Gun17;
import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;

public class _05_Odev extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
            Senaryo;
              1- https://www.snapdeal.com/  sitesine gidiniz.
              2- Random Bir tane ürüne tıklatınız.
              3- Açılan yeni window daki ürünü sepete ekletiniz.
              4- Ana Window a dönüp sepete tıklatınız.
              5- Sepete eklenen ürün ile sepete tıklattığınızdaki ekrana çıkan
                 ürün ismi aynı olup olmadığını assert ile kontrol ediniz.
*/

        driver.get("https://www.snapdeal.com/");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        String anaSayfaIDsi = driver.getWindowHandle();
        System.out.println("Ana Sayfa ID = " + anaSayfaIDsi);

        Thread.sleep(5000);

        js.executeScript("window.scrollBy(0,300)");

        //ürünleri liste ekledik
        List<WebElement> urunList = driver.findElements(By.xpath("//div[@class='trendingProd product-relative dp-widget-link col-xs-5 favDp']"));
        WebElement next = driver.findElement(By.xpath("(//i[@class='next-i'])[2]"));

        //random sayı ürettik
        int randomSayi = (int) (Math.random() * urunList.size());
        System.out.println("random sayımız: " + randomSayi); // 10
        int i = 0;

        while (true){

            WebElement urun = urunList.get(randomSayi);

            if (urun.isDisplayed()==true){
                System.out.println("Ürün bulundu...");
                urun.click();
                break;
            }
            i++;
            System.out.println(i + " .kere--> Ürün ekranda görünmedi ve tıklanamadı... Next butonuna tıklandı...");
            next.click();
            Thread.sleep(500);
        }

        //ID LERİ BULDUK. 2.WEBSAYFASINA GEÇTİK.
        Set<String> windowIdler = driver.getWindowHandles();

        for (String ID: windowIdler) {

            if (ID.equals(anaSayfaIDsi)) continue;

            System.out.println("Ürün Sayfası ID = " + ID);

            driver.switchTo().window(ID);
        }

        // 2.Sayfada açılan ürün
        Thread.sleep(2000);
        String eklenenUrun = driver.findElement(By.xpath("//h1[@itemprop='name']")).getText();
        System.out.println("Sepete eklenen ürün = " + eklenenUrun);

        // Cereze tıklatma
        WebElement cerez = driver.findElement(By.xpath("//div[text()='Decline All']"));
        cerez.click();

        // add To Cart
        WebElement addToCart = driver.findElement(By.cssSelector("div#add-cart-button-id"));
        addToCart.click();

        Thread.sleep(500);

        driver.close();
        driver.switchTo().window(anaSayfaIDsi);

        Thread.sleep(1000);

        // Sepete Tıkla
        WebElement sepeteTikla = driver.findElement(By.cssSelector("div.cartInner"));
        sepeteTikla.click();

        Thread.sleep(2000);

        String ekranaCikanUrun = driver.findElement(By.cssSelector(".item-name")).getText();
        System.out.println("Sepette ekrana çıkan ürün = " + ekranaCikanUrun);

        Thread.sleep(1000);

        Assert.assertEquals(eklenenUrun,ekranaCikanUrun);

        System.out.println("Test başarılı...");

        Thread.sleep(3000);
        driver.quit();
    }
}