package store.model.items


class LoyaltySale (var percent: Double) extends Modifier{

  var taxturn: Double  = 0.0
  override def updatePrice(input: Double): Double = {
    input
  }

  override def computeTax(price: Double): Double = {
    0.0
  }

  override def loyaltyprice(input: Double): Double ={
    val off: Double = percent / 100
    val newPrice: Double = input - (input * off)
    newPrice
  }

  override def developerprice(): Double = {
    0.0
  }
}
