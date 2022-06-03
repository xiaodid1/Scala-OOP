package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.{BottleDeposit, Item, Sale, SalesTax}
import store.view.SelfCheckoutGUI

class enterpress(states:SelfCheckout) extends state (states){


  override def addItem(barcode: String, item: Item): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
    this.states.state = new numberpress(states)
    this.states.state.numberPressed(number)
  }

  override def clearPressed(): Unit = {
  }

  override def enterPressed(): Unit = {
    this.states.welcome = ""
    val error: Item = new Item("error",0.0)
    this.states.receipt = states.receipt :+ error
  }

  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {
    states.state = new cashpress(states)
  }

  override def creditPressed(): Unit = {}

  override def displayString(): String = {
    null
  }

  override def receiptLines(): List[ReceiptLine] = {
    var newreceipt: List[ReceiptLine] = List()
    for (i <- states.receipt){
      val items: ReceiptLine = new ReceiptLine(i.description(),i.price())
      newreceipt = newreceipt :+ items
    }
    newreceipt
  }

  override def prepareStore(): Unit = {
    this.states.state.prepareStore()
  }

  override def loyaltyCardPressed(): Unit = {}
}