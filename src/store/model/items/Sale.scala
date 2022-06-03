package store.model.items

class Sale (var percentOff:Double) extends Modifier {

  val taxreturn: Double = 0.0

  override def updatePrice(input: Double): Double = {
    val off: Double = percentOff / 100
    val newPrice: Double = input - (input * off)
    newPrice
  }

  override def computeTax(price: Double): Double= {
    taxreturn
  }

  override def loyaltyprice(price: Double): Double = {
    price
  }

  override def developerprice(): Double = {
    0.0
  }
}
