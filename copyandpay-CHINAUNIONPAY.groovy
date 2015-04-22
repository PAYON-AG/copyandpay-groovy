import groovy.json.JsonSlurper

public static String prepareCheckout() {
  def url = "https://test.oppwa.com/v1/checkouts".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String parameters ="authentication.userId=8a8294174b7ecb28014b9699220015cc" +
          "&authentication.password=sy6KJsT8" +
          "&authentication.entityId=8a8294174b7ecb28014b9699a3cf15d1" +
          "&paymentType=DB" +
          "&amount=50.99" +
          "&currency=USD" 
  connection.outputStream << parameters
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json.id
}

println prepareCheckout()