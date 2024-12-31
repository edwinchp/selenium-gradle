Feature: Price Scrapper for Multiple Stores and Products

  @PriceScrapper
  Scenario Outline: Scrape prices from multiple stores for different products
    Given Yo navego por todas las tiendas busco el producto "<product>"
    Then Debería ver el precio del producto

    Examples:
      | product       |
      | Tomate kg     |
      | Plátano kg    |
      | Cebolla       |
      | Ajo pieza     |
      | Naranja       |
      | Naranja agria |
      | Naranja dulce |
      | Limon         |
      | Leche lala    |
