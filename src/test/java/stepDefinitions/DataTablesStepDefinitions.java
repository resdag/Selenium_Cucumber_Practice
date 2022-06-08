package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DatatablesPage;

public class DataTablesStepDefinitions {
    DatatablesPage datatablesPage = new DatatablesPage();

    @Then("new butonuna basar")
    public void new_butonuna_basar() {
        datatablesPage.newButonu.click();
    }

    @Then("isim bolumune {string} girer")
    public void isim_bolumune_girer(String firstName) {
        datatablesPage.firstName.sendKeys(firstName);

    }

    @Then("soyisim bolumune {string} girer")
    public void soyisim_bolumune_girer(String lastName) {
        datatablesPage.lastName.sendKeys(lastName);
    }

    @Then("position bolumune {string} girer")
    public void position_bolumune_girer(String position) {
        datatablesPage.position.sendKeys(position);
    }

    @Then("office bolumune {string} girer")
    public void office_bolumune_girer(String office) {
        datatablesPage.office.sendKeys(office);
    }

    @Then("extension bolumune {string} girer")
    public void extension_bolumune_girer(String extension) {
        datatablesPage.extn.sendKeys(extension);
    }

    @Then("startDate bolumune {string} girer")
    public void start_date_bolumune_girer(String startDate) {
        datatablesPage.startDate.sendKeys(startDate);
    }

    @Then("salary bolumune {string} girer")
    public void salary_bolumune_girer(String salary) {
        datatablesPage.salary.sendKeys(salary);

    }

    @Then("Create tusuna basar")
    public void create_tusuna_basar() {
        datatablesPage.create.click();

    }

    @When("kullanici {string} ile arama yapar")
    public void kullaniciIleAramaYapar(String firstName) {
        datatablesPage.search.sendKeys(firstName);
    }

    @Then("isim bolumunde {string} oldugunu test eder")
    public void isimBolumundeOldugunuTestEder(String firstName) {
        Assert.assertTrue(datatablesPage.aramaSonucIlkElement.getText().contains(firstName));
    }
}
