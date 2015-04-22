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
          "&currency=BRL" +
          "&customParameters[BRADESCO_cpfsacado]=11111111111" +
          "&billing.country=BR" +
          "&billing.postcode=12345678" +
          "&billing.state=SP" +
          "&billing.street1=Amazonstda" +
          "&billing.city=Brasilia" +
          "&customer.givenName=Braziliano" +
          "&customer.surname=Babtiste" +
          "&testMode=EXTERNAL" 
  connection.outputStream << parameters
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json.id
}

println prepareCheckout()