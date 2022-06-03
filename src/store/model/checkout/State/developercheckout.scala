package store.model.checkout.State

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class developercheckout (states:SelfCheckout) extends state(states){

  this.states.welcome = "cash or credit"

  this.states.entered = ""

  override def addItem(barcode: String, item: Item): Unit = {}

  override def numberPressed(number: Int): Unit = {}

  override def clearPressed(): Unit = {}

  override def enterPressed(): Unit = {}

  override def checkoutPressed(): Unit = {}

  override def cashPressed(): Unit = {
    this.states.state = new cashcreditpress(states)
    this.states.receipt = List()
    this.states.subtotal = 0.0
    this.states.tax = 0.0
  }

  override def creditPressed(): Unit = {
    states.state = new cashcreditpress(states)
    this.states.receipt = List()
    this.states.subtotal = 0.0
    this.states.tax = 0.0
  }

  override def loyaltyCardPressed(): Unit = {}

  override def displayString(): String = {
    this.states.welcome
  }

  override def receiptLines(): List[ReceiptLine] = {
    var finalreciept: List[ReceiptLine] = List()
    var newreceipt: List[ReceiptLine] = List()
    for (i <- states.receipt){
      val items: ReceiptLine = new ReceiptLine(i.description(),i.developeprice())
      newreceipt = newreceipt :+ items
    }
    for (i <- states.receipt){
      this.states.subtotal+=i.developeprice()
      this.states.tax+=i.developeprice()
    }
    finalreciept = newreceipt :+ new ReceiptLine("subtotal",this.states.subtotal) :+
      new ReceiptLine("tax",this.states.tax):+
      new ReceiptLine("total",this.states.subtotal+this.states.tax)
    this.states.tax = 0.0
    this.states.subtotal = 0.0
    finalreciept
  }

  override def prepareStore(): Unit = {}
}
