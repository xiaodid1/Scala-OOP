package store.model.items


class SaleTestingItem(description:String,Price:Double){
  var result: List[Sale] = List()

  def addSale(input:Sale): Unit={
    result = result:+input
  }

  def price(): Double={
    var inputprice = Price
    for(i <- result){
      inputprice = i.updatePrice(inputprice)
    }
    inputprice
  }



}
