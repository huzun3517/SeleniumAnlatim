package Gun17;

import _util.BaseStaticDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class _04_CalculatorTest_Yol2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

/*TODO
    Senaryo
    1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
    2- random 100 e kadar 2 sayı üretiniz.
    3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
    4- Sonuçları Assert ile kontrol ediniz.
    5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.
 */

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        WebElement selectElement = driver.findElement(By.id("selectOperationDropdown"));
        Select islemler = new Select(selectElement);

        Random sayiUreteci = new Random();

        int y = 1;

        for (int i = 0; i < 5; i++) {
//             Double sayi1= sayiUreteci.nextDouble() * 100;
//             Double sayi2= sayiUreteci.nextDouble() * 100;

            System.out.println("************************* " + y++ +".TUR *************************");

            int sayi1 = sayiUreteci.nextInt(100);
            int sayi2 = sayiUreteci.nextInt(100);

//            System.out.println(sayi1);
//            System.out.println(sayi2);

            String EkranIslemSonucu = "";

            for(WebElement islem : islemler.getOptions()) {

                switch (islem.getText()){
                    case "Add":
                        islemler.selectByVisibleText("Add");
                        EkranIslemSonucu = EkrandaIslemYap(sayi1,sayi2,islem.getText());
                        System.out.println("Beklenen = " + sayi1 + " + " + sayi2 + " = " + (sayi1 + sayi2)+"   ----> EkranSonuc = "  + EkranIslemSonucu);
                        Assert.assertEquals( Integer.toString (sayi1+sayi2), EkranIslemSonucu);
                        break;

                    case "Subtract":
                        islemler.selectByVisibleText("Subtract"); // Ekrana yapılacak işlemi seç
                        EkranIslemSonucu = EkrandaIslemYap(sayi1,sayi2,islem.getText()); // sayi1 ve sayi2 yi ekrana gönderip oluşan sonuç alınıyor.
                        System.out.println("Beklenen = " + sayi1 + " - " + sayi2 + " = " + (sayi1 - sayi2)+"   ----> EkranSonuc = "  + EkranIslemSonucu);
                        Assert.assertEquals( Integer.toString (sayi1 - sayi2), EkranIslemSonucu);
                        break;

                    case "Multiply":
                        islemler.selectByVisibleText("Multiply"); // Ekrana yapılacak işlemi seç
                        EkranIslemSonucu = EkrandaIslemYap(sayi1,sayi2,islem.getText()); // sayi1 ve sayi2 yi ekrana gönderip oluşan sonuç alınıyor.
                        System.out.println("Beklenen = " + sayi1 + " * " + sayi2 + " = " + (sayi1 * sayi2)+"   ----> EkranSonuc = "  + EkranIslemSonucu);
                        Assert.assertEquals( Integer.toString (sayi1 * sayi2), EkranIslemSonucu);
                        break;

                    case "Divide":
                        islemler.selectByVisibleText("Divide"); // Ekrana yapılacak işlemi seç
                        EkranIslemSonucu = EkrandaIslemYap(sayi1,sayi2,islem.getText()); // sayi1 ve sayi2 yi ekrana gönderip oluşan sonuç alınıyor.
                        System.out.println("Beklenen = " + sayi1 + " / " + sayi2 + " = " + (sayi1 / sayi2)+"   ----> EkranSonuc = "  + EkranIslemSonucu);
                        Assert.assertEquals( Integer.toString (sayi1 / sayi2), EkranIslemSonucu);
                        break;

                    case "Concatenate":
                        islemler.selectByVisibleText("Concatenate"); // Ekrana yapılacak işlemi seç
                        EkranIslemSonucu = EkrandaIslemYap(sayi1,sayi2,islem.getText()); // sayi1 ve sayi2 yi ekrana gönderip oluşan sonuç alınıyor.
                        System.out.println("Beklenen = " + sayi1 + sayi2 + "   ----> EkranSonuc = "  + EkranIslemSonucu); // kendime kontrol
                        Assert.assertEquals("" + sayi1 + sayi2, EkranIslemSonucu);
                        break;
                }
            }

        }
        System.out.println("Test başarılı...");
        Thread.sleep(5000);
        driver.quit();
    }

    //Ekrandaki istenen işlemi yapıp sonucu gönderir.
    public static String EkrandaIslemYap(Integer sayi1,Integer sayi2, String islem)
    {
        // 1.Sayıyı gönder
        WebElement firstNumber=driver.findElement(By.id("number1Field")); //First number
        firstNumber.clear();
        firstNumber.sendKeys(sayi1.toString());

        // 2.Sayıyı gönder
        WebElement secondNumber=driver.findElement(By.id("number2Field")); // Second number
        secondNumber.clear();
        secondNumber.sendKeys(sayi2.toString());

        // hesapla butonuna bas
        WebElement calculateBtn = driver.findElement(By.id("calculateButton")); // calculate Button
        calculateBtn.click();

        // sonucun gelmesini bekle
        WebDriverWait bekle=new WebDriverWait(driver, 5); // Answer ekrana gelene kadar beklet
        bekle.until(ExpectedConditions.visibilityOfElementLocated(By.id("answerForm")));

        if (!islem.equals("Concatenate")){
            WebElement integersonly = driver.findElement(By.cssSelector("input#integerSelect"));
            integersonly.click();
        }

        // sonucu value attribute ndan al.
        String answer = driver.findElement(By.id("numberAnswerField")).getAttribute("value");

        // sonucu temizle
        WebElement clearBtn = driver.findElement(By.id("clearButton"));
        clearBtn.click();

        // sonucu gönder
        return answer;
    }
}