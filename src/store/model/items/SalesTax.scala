package store.model.items

class SalesTax (saleTax: Double)extends Modifier {


  override def updatePrice(input: Double): Double ={
    input
  }

  override def computeTax(price:Double): Double ={
    var tax: Double = price * (saleTax / 100)
    tax
  }

  override def loyaltyprice(price: Double): Double = {
    price
  }

  override def developerprice(): Double = {
    0.0
  }
}
