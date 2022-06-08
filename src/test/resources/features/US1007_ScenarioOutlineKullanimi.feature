# amazon sayfasina gidip sirasiyla nutella, java, elma, armut aratip
# sonuclarin aranan kelimeyi icerdigini test edelim
Feature: US1007 kullanici amazonda istedigi kelimeleri aratir

  @soutline
  Scenario Outline: TC12 amazonda listedeki elementleri aratma
    Given kullanici "amazonUrl" anasayfasinda
    Then kullanici "<istenenKelime>" icin arama yapar
    And sonuclarin "<istenenKelimeKontrol>" icerdigini test eder

    Examples:
      | istenenKelime | istenenKelimeKontrol |
      | nutella       | nutella              |
      | java          | java                 |
      | elma          | elma                 |
      | armut         | armut                |

