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
    Cucumber'da Test Case olustma
        - feature dosyasi olustur
        - kullanilacak verileri configuration.properties'e ekle
        - stepDefinitions class acip feature dosyasinda / runner'dan calistirarak consoldaki eksik stepleri yapistir
        - page class'i olusturup icinde contructor olusturduktan sonra gereken locate'leri yap
        - stepDefinitions'da page sayfasindan objekt olusturarak islemler yapilir.
----------------------------------------------------------------------------------------
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
Cucumber Rapor Ekleme
    * Runner dosyasina plugin eklenerek html raporlama yapilir.
            plugin = {"html:target/cucumber-reports.html"}, //dosyayi burada olusturur
    * Rapor almak icin test Runner class'tan calistiririlmalidir
    * json ve xml raporlar icin de rapor almak icin 2 plugin daha eklemeliyiz
            plugin = {"html:target/cucumber-reports.html",
                    "json:target/json-reports/cucumber.json", //Rest Assures kullanilirsa
                    "junit:target/xml-report/cucumber.xml"}, //Soap API kullanilirsa
    * Testi Runner'dan calistirinca target altinda cucumber-report'lar olusur.
----------------------------------------------------------------------------------------
Hooks ve Screen Shot Ekleme
    * Hooks senaryolardan once ve sonra calisan kod bloklaridir
    * Bu kodlar icin stepDefinitions'a Hooks adinda bir class olustur.(isim farkli olabilir)
    * Failed olan her senaryodan sonra Screen Shot almak icin @After method'u kullanilir
        @After
        public void tearDown(Scenario scenario) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            if (scenario.isFailed()) {
                scenario.attach(screenshot, "image/png", "screenshots");
            }
            Driver.closeDriver();
        }
    * Rapor almak icin testi yine Runner'dan calistirmaliyiz
    * Failed olan test icin target altindaki cucumber-report.html'ye ScreenShot'i ekler.
    * Testi güzellestirmek icin plugin eklenebilir
            - maven-cucumber-reporting
                    Bunu kullanmak icin terminalden calistirilmalidir. Terminalden calistirma icin 2 plugin ekledik
            - maven-failsafe-plugin
            - maven-surefire-plugin
        * plugin'e gore runners> TestRunner olani calistiracagimiz icin TestRunner olmalidir.
        * Testi Terminalden calistirmak icin 'mvn clean verify' yazilir ve Ctrl+ENTER ile calistirilir
        * Test bitiminde olusan raporlar target>cucumber-html-reports>js>report-feature ve digerleridir.
----------------------------------------------------------------------------------------
Parelel Testing (Birden fazla browser'i es zamanli Calistirma)
    * Istedigimiz senaryolara ayni tagi verip, bu tag ile runnerdan SIRALI calistirabiliriz
    * Ayni anda birden fazla browser kullanmak icin farkli taglari calistiracak istedigimiz kadar Runner olustururuz
    * Bu durumda birden fazla runner'i birlikte calistirmak icin pom-xml'e 2 plugin eklemeliyiz
                    - maven-failsafe-plugin ---> adimlardan biri failed olsada calistirir
                    - maven-surefire-plugin ---> <threatCount> tag'i arasinda istenen browser sayisi girilir
                        Bu sayi kadar TestRunner olusturulmalidir
    * Detayli rapor almak icin test yine 'mvn clean verify' ile calistirilmalidir.
        Bu komutla runner>TestRunner'daki tum tag'lar calistirilmis olur.

     */
}
