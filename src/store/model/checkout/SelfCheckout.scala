package store.model.checkout

import store.model.items.{BottleDeposit, Item, LoyaltySale, Sale, SalesTax}
import store.model.checkout.State._

class SelfCheckout {

  var state: state = new welcomestate(this)

  var welcome: String = "Hello and welcome to my store"

  var receipt: List[Item] = List()

  var entered: String = ""

  var alreadyentered: String = ""

  var itemstore: Map[String,Item]= Map()

  var subtotal:Double = 0.0

  var tax: Double = 0.0

  var finalreciept: List[ReceiptLine] = List()

  var loyaltyreceipt: List[ReceiptLine] = List()


  def addItem(barcode: String, item: Item): Unit = {

    this.state.addItem(barcode,item)
    // TODO
  }

  def numberPressed(number: Int): Unit = {

    this.state.numberPressed(number)
    // TODO
  }

  def clearPressed(): Unit = {

    this.state.clearPressed()
    // TODO
  }

  def enterPressed(): Unit = {
    this.state.enterPressed()
    // TODO
  }

  def checkoutPressed(): Unit = {

    this.state .checkoutPressed()
    // TODO
  }

  def cashPressed(): Unit = {

    this.state.cashPressed()
    // TODO
  }

  def creditPressed(): Unit = {

    this.state.creditPressed()
    // TODO
  }

  def loyaltyCardPressed(): Unit = {

    this.state.loyaltyCardPressed()
    // TODO
  }

  def displayString(): String = {
    this.state.displayString()
    // TODO
  }

  def receiptLines(): List[ReceiptLine] = {
    this.state.receiptLines()
    // TODO
  }

  def prepareStore(): Unit = {
    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItem to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.
    val item:Item = new Item("item1",100.0)

    val item1:Item = new Item("item2",200.0)

    val item2:Item = new Item("item3",300.0)

    val item3:Item = new Item("item4",400.0)

    val sale:Sale = new Sale(20.0)

    val saletax: SalesTax = new SalesTax(8.0)

    val loyalty: LoyaltySale = new LoyaltySale(10.0)

    val bottleDeposit: BottleDeposit = new BottleDeposit(8.0)

    addItem("01",item)
    addItem("02",item1)
    addItem("03",item2)
    addItem("04",item3)
    item.addModifier(loyalty)
    item.addModifier(sale)
    item.addModifier(saletax)
    item1.addModifier(loyalty)
    item1.addModifier(sale)
    item1.addModifier(saletax)
    item2.addModifier(loyalty)
    item2.addModifier(sale)
    item2.addModifier(saletax)
    item3.addModifier(loyalty)
    item3.addModifier(sale)
    item3.addModifier(saletax)
  }

}
