package store.model.items

class BottleDeposit (deposit: Double) extends Modifier {

  override def updatePrice(input: Double): Double ={
    input
  }

  override def computeTax(price: Double): Double = {
    deposit
  }

  override def loyaltyprice(price: Double): Double ={
    price
  }

  override def developerprice(): Double = {
    0.0
  }
}
