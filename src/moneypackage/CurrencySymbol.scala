package moneypackage

abstract class CurrencySymbol(val currency: Currency)

object zl extends CurrencySymbol(PLN)
object `€` extends CurrencySymbol(EUR)
object $ extends CurrencySymbol(USD)