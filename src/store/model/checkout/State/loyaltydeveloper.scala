package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class loyaltydeveloper (states:SelfCheckout) extends state (states){

  override def addItem(barcode: String, item: Item): Unit = {}

  override def numberPressed(number: Int): Unit = {
    this.states.entered = this.states.entered + number.toString
    this.states.alreadyentered = this.states.entered
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
    states.state = new developercheckout(states)
    this.states.alreadyentered = ""
    this.states.entered = ""
  }

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

  override def loyaltyCardPressed(): Unit = {}

  override def displayString(): String = {
    this.states.entered
  }

  override def receiptLines(): List[ReceiptLine] = {
    var newreceipt: List[ReceiptLine] = List()
    for (i <- states.receipt){
      val items: ReceiptLine = new ReceiptLine(i.description(),i.developeprice())
      newreceipt = newreceipt :+ items
    }
    newreceipt
  }

  override def prepareStore(): Unit = {}
}
