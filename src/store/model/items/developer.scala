package store.model.items

class developer extends Modifier {

  override def updatePrice(input: Double): Double = {
    input
  }

  override def computeTax(price: Double): Double = {
    price
  }

  override def loyaltyprice(price: Double): Double = {
    price
  }

  override def developerprice(): Double = {
    0.0
  }
}
