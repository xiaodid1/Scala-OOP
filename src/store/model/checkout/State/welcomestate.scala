package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.{BottleDeposit, Item, Sale, SalesTax}
import store.view.SelfCheckoutGUI

class welcomestate (states:SelfCheckout) extends state (states){


  override def addItem(barcode: String, item: Item): Unit = {
    this.states.itemstore+=(barcode -> item)
  }

  override def numberPressed(number: Int): Unit = {
    this.states.state = new numberpress(states)
    this.states.state.numberPressed(number)
  }

  override def clearPressed(): Unit = {

  }

  override def enterPressed(): Unit = {
    this.states.welcome = ""
    this.states.state = new enterpress(states)
    this.states.state.enterPressed()

  }

  override def checkoutPressed(): Unit = {

  }

  override def cashPressed(): Unit = {
    states.state = new cashpress(states)
  }

  override def creditPressed(): Unit = {

  }

  override def displayString(): String = {
    this.states.welcome
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

  override def loyaltyCardPressed(): Unit = {
    states.state = new loyaltyPress(states)
  }
}
