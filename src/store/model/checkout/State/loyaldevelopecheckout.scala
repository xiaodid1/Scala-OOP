package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class loyaldevelopecheckout (states: SelfCheckout) extends state (states){
  override def addItem(barcode: String, item: Item): Unit = ???

  override def numberPressed(number: Int): Unit = ???

  override def clearPressed(): Unit = ???

  override def enterPressed(): Unit = ???

  override def checkoutPressed(): Unit = ???

  override def cashPressed(): Unit = ???

  override def creditPressed(): Unit = ???

  override def loyaltyCardPressed(): Unit = ???

  override def displayString(): String = ???

  override def receiptLines(): List[ReceiptLine] = ???

  override def prepareStore(): Unit = ???
}
