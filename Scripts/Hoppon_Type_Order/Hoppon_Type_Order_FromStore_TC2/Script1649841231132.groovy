import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.setText(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/input_Choose Your Location_customer_location'),
	'670571')

WebUI.clearText(findTestObject('Hoppon/SignIn/Page_Hoppon - stores Order online food groc_e0fbcb/input_Choose Your Location_customer_location'))

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> suggestionList = driver.findElements(By.xpath('//input[@id=\'location-input\']'))

for (WebElement sl : suggestionList) {
	sl.click()

	sl.sendKeys('Kazhakkoottam, Kerala, India')

	sl.sendKeys(Keys.ARROW_DOWN)

	sl.sendKeys(Keys.ENTER)
}

WebUI.delay(3)

List<WebElement> shopList = driver.findElements(By.xpath('//div[@id=\'outputsort\']/div'))

System.out.println(shopList.size())

(shopList[1]).click()

WebUI.click(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/span_TYPE YOUR ORDER'))

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/button_Ok'))

WebUI.setText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Email_email'),
	GlobalVariable.LoginUsername)

WebUI.setEncryptedText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Password_password'),
	GlobalVariable.LoginPassword)

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Forgot Password_submit'))

WebUI.click(findTestObject('Object Repository/Search_Products/Page_Store Details - Hoppon/span_TYPE YOUR ORDER'))

WebUI.setText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Shopping List_myInput'), 
    'pepsi')

//WebUI.verifyElementText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/span_No matches found in this shop'), 
//    'No matches found in this shop..')

//WebUI.verifyElementText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/textarea_No matches found in this shop_spcl_b77d0b'), 
//    '')

String paceholderText=WebUI.getAttribute(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Shopping List_myInput'), 'placeholder')

WebElement orderInput =driver.findElement(By.xpath("//*[@id='spclordersamplelist']"))

orderInput.click()

orderInput.sendKeys('Sugar 3Kg')

orderInput.sendKeys(Keys.ENTER)

orderInput.sendKeys('Rice  25Kg')

orderInput.sendKeys(Keys.ENTER)

orderInput.sendKeys('Frooti 300 ml')

orderInput.sendKeys(Keys.ENTER)

//WebUI.setText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/textarea_No matches found in this shop_spcl_b77d0b'), 
//    'p')

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/button_Send List'))

WebUI.verifyElementText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/p_Ready to send the List'), 
    'Ready to send the List?')

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/button_Yes'))

WebUI.verifyElementText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/p_Thanks for sending us your list. We will _9f006b'), 
    'Thanks for sending us your list. We will get in touch with you shortly.')

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/button_Ok_1'))


