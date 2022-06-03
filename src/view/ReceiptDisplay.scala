package store.view

import scalafx.scene.control.TextArea
import store.model.checkout.ReceiptLine

class ReceiptDisplay() extends TextArea {

  val receiptDisplayWidth: Int = 30

  editable = false
  prefColumnCount = receiptDisplayWidth
  prefRowCount = 17
  style = "-fx-font: 12 consolas;"

  def addLine(line: ReceiptLine): Unit ={
    this.text.value += formatReceiptItem(line.description, line.amount) + '\n'
  }

  def formatReceiptItem(description: String, price: Double): String = {
    val priceString: String = "$%.2f".format(price)
    val remainingSpace = this.receiptDisplayWidth - priceString.length() - 1
    val truncatedDescription: String = description.substring(0, 0.max(remainingSpace.min(description.length())))
    val padding: String = " " * (this.receiptDisplayWidth - priceString.length - truncatedDescription.length)
    truncatedDescription + padding + priceString
  }

}
