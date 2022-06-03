package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.{BottleDeposit, Item, Sale, SalesTax}
import store.view.SelfCheckoutGUI


class cashcreditpress (states:SelfCheckout) extends state (states){

  this.states.welcome = "thank you"

  override def addItem(barcode: String, item: Item): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
    states.state = new numberpress(states)
    states.state.numberPressed(number)
  }

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {
    this.states.state = new enterpress(states)
    this.states.state.enterPressed()
  }


  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit = {}

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
