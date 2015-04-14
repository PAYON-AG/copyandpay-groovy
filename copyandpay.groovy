import groovy.json.JsonSlurper

public static String prepareCheckout() {
  def url = "https://test.oppwa.com/v1/checkouts".toURL()
  def connection = url.openConnection()

  connection.setRequestMethod("POST")
  connection.doOutput = true
  String parameters ="authentication.userId=8a8294184b4f2868014b4f86f767015d" +
          "&authentication.password=F8T7N4PD" +
          "&authentication.entityId=8a8294184b4f2868014b4f87bf160173" +
          "&paymentType=DB" +
          "&amount=50.99" +
          "&currency=EUR" 
  connection.outputStream << parameters
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json.id
}

println prepareCheckout()