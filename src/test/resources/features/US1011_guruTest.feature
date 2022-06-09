Feature: US1011 Web tabledaki istenen sutunu yazdirma

  @guru
  Scenario: TC16 kullanici sutun basligi ile liste alabilmeli
    Given kullanici "guruUrl" anasayfasinda
    And cookies sorulursa kabul eder
    And "Company" sutunundaki tum degerleri yazdirir
    Then sayfayi kapatir