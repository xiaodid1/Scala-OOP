package store.model.items

class Item(Description:String,cost:Double){
  var scannedtime: Int = 0

  var outcome: List[Modifier] = List()

  def addModifier(input:Modifier): Unit={
    outcome=outcome:+input
  }
  def tax(): Double={
    var taxs: Double = 0.0
    for (a <- outcome) {
      taxs += a.computeTax(price())
    }
    taxs
  }

  def price(): Double={
    var newprice = cost
    for ( i <- outcome){
      newprice = i.updatePrice(newprice)
    }
    newprice
  }

  def loyaltyprice(): Double ={
    var newprice = price()
    for ( i <- outcome){
      newprice = i.loyaltyprice(newprice)
    }
    newprice
  }

  def loyaltytax(): Double={
    var taxs: Double = 0.0
    for (a <- outcome) {
      taxs += a.computeTax(loyaltyprice())
    }
    taxs
  }

  def developeprice(): Double={
    0.0
  }

  def description(): String={
    Description
  }
  def scanned(): Unit={
    scannedtime+=1
  }
  def timesScanned(): Int={
    scannedtime
  }


}
