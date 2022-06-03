package store.model.checkout.State
import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items._


class numberpress (states:SelfCheckout) extends state (states){


  override def addItem(barcode: String, item: Item): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
    this.states.entered = this.states.entered + number.toString
    this.states.alreadyentered = this.states.entered
  }

  override def clearPressed(): Unit = {
    this.states.entered = ""
    this.states.alreadyentered = ""
  }

  override def enterPressed(): Unit = {
    this.states.entered = ""
    this.states.state = new entercheckout(states)
    this.states.state.enterPressed()
  }

  override def checkoutPressed(): Unit = {
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

  override def prepareStore(): Unit ={
    this.states.state.prepareStore()
  }

  override def cashPressed(): Unit = {
    states.state = new cashpress(states)
  }
  override def creditPressed(): Unit = {}

  override def loyaltyCardPressed(): Unit = {
    states.state = new loyaltyPress(states)
  }
}