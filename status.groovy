import groovy.json.JsonSlurper

public static String getPaymentStatus(checkoutId) {
  def url = ("https://test.oppwa.com/v1/checkouts/" + checkoutId + "/payment").toURL()
  def connection = url.openConnection()
  connection.setRequestMethod("GET")
  
  def json = new JsonSlurper().parseText(connection.inputStream.text)
  json
}

def status = getPaymentStatus("47FF7BAE1A97B61ED575A8469965AEF9.sbg-vm-tx01")
println status
