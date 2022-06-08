package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HerokuPage;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class HerokuStepDefinitions {
    HerokuPage herokuPage = new HerokuPage();
    List<WebElement> deleteElementleri;

    @Given("add element butonuna basar")
    public void add_element_butonuna_basar() {
        herokuPage.addElementButonu.click();
        deleteElementleri = Driver.getDriver().findElements(By.xpath("//button[text()='Delete']"));
    }

    @Then("Delete butonu gorunur oluncaya kadar bekler")
    public void delete_butonu_gorunur_oluncaya_kadar_bekler() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(herokuPage.deleteButonu));
    }

    @Then("Delete butonunun gorunur oldugunu test eder")
    public void delete_butonunun_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(herokuPage.deleteButonu.isDisplayed());
    }

    @Then("Delete butonuna basar")
    public void delete_butonuna_basar() {
        herokuPage.deleteButonu.click();
        deleteElementleri.remove(deleteElementleri.size() - 1);
    }

    @Then("Delete butonunun gorunmedigini test eder")
    public void delete_butonunun_gorunmedigini_test_eder() {
        Assert.assertTrue(deleteElementleri.isEmpty());
    }
}
