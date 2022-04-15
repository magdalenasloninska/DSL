package moneypackage

case class CurrencyConverter(conversion: Map[(Currency, Currency), BigDecimal]) {

    def convert(from: Currency, to: Currency): BigDecimal = {
        conversion(from, to)
    }

    def convert(from: CurrencySymbol, to: CurrencySymbol): BigDecimal = {
        conversion(from.currency, to.currency)
    }
}