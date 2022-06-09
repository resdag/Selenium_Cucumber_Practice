package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GuruPage;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class guruStepDefinitions {
    GuruPage guruPage = new GuruPage();

    @Given("cookies sorulursa kabul eder")
    public void cookies_sorulursa_kabul_eder() {
        Driver.getDriver().switchTo().frame(guruPage.cookiesIframe);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(guruPage.acceptCookies)).click();

    }

    @Given("{string} sutunundaki tum degerleri yazdirir")
    public void sutunundaki_tum_degerleri_yazdirir(String istenenSutun) {

        List<WebElement> tabloBaslikListesi = guruPage.baslikListesi;
        int istenenBaslikIndexi = -10;
        for (int i = 0; i < tabloBaslikListesi.size(); i++) {
            if (tabloBaslikListesi.get(i).getText().equals(istenenSutun)) {
                istenenBaslikIndexi = i + 1;
                break;
            }
        }

        if (istenenBaslikIndexi != -10) { // baslik bulundu ise
            List<WebElement> istenenSutundakiElementler =
                    Driver.getDriver().findElements(By.xpath("//tbody//tr//td[" + istenenBaslikIndexi + "]"));
            for (WebElement each : istenenSutundakiElementler
            ) {
                System.out.println(each.getText());
            }
        } else { // baslik bulunamadi ise
            System.out.println("istenen baslik bulunamadi");
        }
    }
}
