public class CucumberNote {
    /*
    ----Cucumber framework Olusturma -------
    1- Maven projesi olustur.
    2- Selenium-java, webdrivermanager, io.cucumber-java, io-cucumber-junit kutuphanelerini ekle ve guncelle.
    3- Java klasoru altinda
        utilities, (Driver ve ConfigReader class'larini olustur/kopyala)
        pages,
        runners,
        stepDefinitions packages olustur.
        resources 'klasoru' olusturup altinda
            "US1001amazonSearch.feature" uzantili yeni file olustur.
                - eger yesil gozukmuyorsa: File-Settings-Pluggins'ten 'Cucumber for Java' ekle.
                - feature isimleri genelde User Story ismiyle ayni olur
    4- configuration.properties dosyasini olustur/kopyala
    5- Feature dasyasina Feature-Scenario: yazarak isleme baslariz
        Given-When-Then-And Gherkin Language'dir ve islev olarak hepsi aynidir.
    6- Yazdigimiz Scenario'yu calistirip eksik methodlari kopyalayarak stepDefinitons'ta olusturulabilir
        ya da teker teker secilerek methodlar olusturulabilir.
    7- stepDefinitons'da olusturulan test method'larinin icini doldur.
    8- Test feature dosyasindan yada Runner'dan  calistirilabilir.
----------------------------------------------------------------------------------------
    Runner Class:
        Bir framework'te 1 tek Runner class' yeterli olabilir.
        Runner class'i body'sinde hicbir sey olmaz.
        Runner class'ini onemli yapan 2 adet annotion vardir.
    @RunWith(Cucumber.class):   Notasyonu Runner class'ina calisma ozelligi katar
        Bu notasyon oldugu icin Cucumber framework'unde JUnit kullanmayi tercih ediyoruz

    @CucumberOptions(feature,glue....)
        features: Runner dosyasinin feature dosyalarini nereden bulacagini tarif eder ("src/test/resources/features")
        glue: stepDefinitions dosyalarini nerede bulacagimizi gosterir (glue = "stepDefinitions")
        tags: o an hangi tag'i calistirmak istiyorsak onu belli eder (@nutella) ("@nutella and @java")
                Bu tag feature'da Scenario'dan once koyulmalidir.
                Belirtilen adresteki bu tag'lara ait tum testler calisir
                @wip: work in progres genellikle tag olarak kullanilir

        dryRun: true; testimizi calistirmadan sadece eksik adimlari bize verir
        dryRun: false; yazdigimizda testlerimizi calistirir

----------------------------------------------------------------------------------------
    Background:
        ortak adimlar(stepDefinitons) burada bulunur. Driver calismaya basladiginda buradan baslar.
        @BeforeMethod/Class gibi calisir.

    Parameter:
        - Scenario'da cift tirnek "" icindeki her kelime paremetredir.
        - Cucumber tum sayilari parametre kabul eder. 2 ya da "2"
            @Given("kullanici {string} icin arama yapar")
            public void kullanici_icin_arama_yapar(String istenenKelime) {
                amazonPage.aramaKutusu.sendKeys(istenenKelime + Keys.ENTER)}
        - paremetre ile configurations.properties dosyasi kullanilabilir.
            Bunun icin paremtreyi CongigReader ile okumak yeterlidir.
        - Bir methodu her kullanildiginda Exception olmamasi icin stepDefinitions icinde try-catch kullanilir
----------------------------------------------------------------------------------------
    Test Case olustururken
        - feature dosyasi olustur
        - kullanilacak verileri configuration.properties'e ekle
        - stepDefinitions class acip feature dosyasinda / runner'dan calistirarak consoldaki eksik stepleri yapistir
        - page class'i olusturup icinde contructor olusturduktan sonra gereken locate'leri yap
        - stepDefinitions'da page sayfasindan objekt olusturarak islemler yapilir.

    Scenario Outline: Ayni testte birden fazla data ile ayni adimlar uygulaniyorsa kullanilir
        Testin farkli olan kismi "<value>" seklinde yazilir ve
        testlerin sonunda  Examples: |value| seklinde giris datalari yazilmalidir.

         Scenario Outline: TC01 amazonda listedeki elementleri aratma
            Given kullanici "amazonUrl" anasayfasinda
            Then kullanici "<istenenKelime>" icin arama yapar
            And sonuclarin "<istenenKelimeKontrol>" icerdigini test eder

        Examples:
        | istenenKelime | istenenKelimeKontrol |
        | nutella       | nutella              |

----------------------------------------------------------------------------------------




     */
}
