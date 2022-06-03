package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class entercheckout (states:SelfCheckout) extends state (states){

  override def addItem(barcode: String, item: Item): Unit = {}

  override def numberPressed(number: Int): Unit = {
    this.states.state = new numberpress(states)
    this.states.state.numberPressed(number)
  }

  override def clearPressed(): Unit = {
    this.states.entered = ""
    this.states.alreadyentered = ""
  }

  override def enterPressed(): Unit = {
    this.states.receipt = states.receipt :+ states.itemstore.getOrElse(states.alreadyentered, new Item("error",0.0))
    this.states.entered = ""
  }

  override def checkoutPressed(): Unit = {
    this.states.state = new checkoutpress(states)
    this.states.alreadyentered = ""
    this.states.entered = ""
  }

  override def cashPressed(): Unit = {
    states.state = new cashpress(states)
  }

  override def creditPressed(): Unit = {}

  override def loyaltyCardPressed(): Unit = {
    states.state = new loyaltyPress(states)
  }

  override def displayString(): String = {
    this.states.entered
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
