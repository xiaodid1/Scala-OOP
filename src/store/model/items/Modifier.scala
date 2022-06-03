package store.model.items

abstract class Modifier {

  def updatePrice(input:Double): Double

  def computeTax(price: Double): Double

  def loyaltyprice(price: Double): Double

  def developerprice(): Double

}
