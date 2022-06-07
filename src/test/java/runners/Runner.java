package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//JUnit'ten geldigi icin Cucumber'da TestNG kullanilmaz
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@parametre",
        //tags = "@ikisi and @java",
        dryRun = true
)

public class Runner {
    /*
    Bir framework'te 1 tek Runner class' yeterli olabilir.
    Runner class'i body'sinde hicbir sey olmaz.
    Runner class'ini onemli yapan 2 adet annotion vardir.
    @RunWith(Cucumber.class) notasyonu Runner class'ina calisma ozelligi katar
    Bu notasyon oldugu icin Cucumber framework'unde JUnit kullanmayi tercih ediyoruz

    features: Runner dosyasinin feature dosyalarini nereden bulacagini tarif eder
    glue: step definitions dosyalarini nerede bulacagimizi gosterir
    tags: o an hangi tag'i calistirmak istiyorsak onu belli eder

    dryRun: true; testimizi calistirmadan sadece eksik adimlari bize verir
    dryRun: false; yazdigimizda testlerimizi calistirir

     */

}
