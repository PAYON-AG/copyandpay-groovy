import groovy.json.JsonSlurper

public static String prepareCheckout() {
  def url = "https://test.oppwa.com/v1/checkouts".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String parameters ="authentication.userId=8a8294174b7ecb28014b9699220015cc" +
          "&authentication.password=sy6KJsT8" +
          "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1" +
          "&paymentType=PA" +
          "&amount=10.00" +
          "&currency=SEK" +
          "&billing.country=SE" +
          "&customer.givenName=Joe" +
          "&customer.surname=Doe" +
          "&cart.items[0].merchantItemId=1" +
          "&cart.items[0].discount=0.00" +
          "&cart.items[0].quantity=5" +
          "&cart.items[0].name=Product 1" +
          "&cart.items[0].price=1.00" +
          "&cart.items[0].tax=6.00" +
          "&customParameters[KLARNA_CART_ITEM1_FLAGS]=32" +
          "&cart.items[1].merchantItemId=2" +
          "&cart.items[1].discount=0.00" +
          "&cart.items[1].quantity=1" +
          "&cart.items[1].name=Product 2" +
          "&cart.items[1].price=1.00" +
          "&cart.items[1].tax=6.00" +
          "&customParameters[KLARNA_CART_ITEM2_FLAGS]=32"
  connection.outputStream << parameters
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json.id
}

println prepareCheckout()