Feature: US1009 Datatables sitesine 5 farkli giris yapalim

  @dtso
  Scenario Outline: : TC114 kullanici 5 farkli kayit girisi yapabilmeli
    When kullanici "datatablesUrl" anasayfasinda
    Then new butonuna basar
    And isim bolumune "<firstName>" girer
    And soyisim bolumune "<lastName>" girer
    And position bolumune "<position>" girer
    And office bolumune "<office>" girer
    And extension bolumune "<extension>" girer
    And startDate bolumune "<startDate>" girer
    And salary bolumune "<salary>" girer
    And Create tusuna basar
    When kullanici "<firstName>" ile arama yapar
    Then isim bolumunde "<firstName>" oldugunu test eder
    Then sayfayi kapatir


    Examples:
      | firstName | lastName | position | office | extension | startDate  | salary |
      | Alim      | Poyraz   | QA       | ankara | UI        | 2021-10-11 | 10000  |
      | Berk      | Can      | tester   | ankara | api       | 2022-05-05 | 11000  |
      | Veli      | Korkmaz  | BA       | berlin | -         | 2022-07-10 | 40000  |
      | Fatih     | Sahin    | PO       | berlin | -         | 2022-03-12 | 45000  |
      | Ahmet     | Kaya     | Tester   | ankara | database  | 2022-06-03 | 11000  |