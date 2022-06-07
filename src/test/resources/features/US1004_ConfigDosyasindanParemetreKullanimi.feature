Feature: US1004 kullanici parametre ile configuration file'i kullanabilmeli

  @config
  Scenario: TC07 configuration properties dosyasindan paremetre kullanimi

    Given kullanici "techproeducationUrl" anasayfasinda
    Then kullanici 3 sn bekler
    And url'in "techpro" icerdigini test eder
    Then sayfayi kapatir