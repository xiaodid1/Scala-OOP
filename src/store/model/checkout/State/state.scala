package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

abstract class state (states: SelfCheckout){
  def addItem(barcode: String, item: Item): Unit
  def numberPressed(number: Int): Unit
  def clearPressed(): Unit
  def enterPressed(): Unit
  def checkoutPressed(): Unit
  def cashPressed(): Unit
  def creditPressed(): Unit
  def loyaltyCardPressed(): Unit
  def displayString(): String
  def receiptLines(): List[ReceiptLine]
  def prepareStore(): Unit
}
