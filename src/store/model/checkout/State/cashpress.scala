package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class cashpress(states: SelfCheckout) extends state (states){
  override def addItem(barcode: String, item: Item): Unit = {

  }

  override def numberPressed(number: Int): Unit = {}

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {}

  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {
    states.state = new cashpress(states)
  }

  override def creditPressed(): Unit = {
    states.state = new creditpress (states)
  }

  override def loyaltyCardPressed(): Unit = {}

  override def displayString(): String = {
    ""
  }

  override def receiptLines(): List[ReceiptLine] = {
    var newreceipt: List[ReceiptLine] = List()
    for (i <- states.receipt){
      val items: ReceiptLine = new ReceiptLine(i.description(),i.price())
      newreceipt = newreceipt :+ items
    }
    newreceipt
  }

  override def prepareStore(): Unit = {}
}
