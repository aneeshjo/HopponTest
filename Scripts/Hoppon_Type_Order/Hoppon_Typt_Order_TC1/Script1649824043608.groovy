import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

//import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI as Keys
WebUI.comment('To check the functionality of Type order')

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://shoptest.hopponapp.com/')

WebUI.delay(3)

WebUI.setText(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/input_Choose Your Location_customer_location'), 
    '670571')

WebUI.delay(3)

WebUI.clearText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Choose Your Location_customer_location (1)'))

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> suggestionList = driver.findElements(By.xpath('//input[@id=\'location-input\']'))

for (WebElement sl : suggestionList) {
    sl.click()

    sl.sendKeys('Kazhakkoottam, Kerala, India')

    WebUI.delay(3)

    sl.sendKeys(Keys.ARROW_DOWN)

    sl.sendKeys(Keys.ENTER)
}

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/span_QUICK ORDER'))

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/a_Type Your Order'))

WebUI.verifyElementText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/p_Please login to type your Order'), 
    'Please login to type your Order.')

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/button_Ok'))

WebUI.setText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Email_email'), 
    GlobalVariable.LoginUsername)

WebUI.setEncryptedText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Password_password'), 
    GlobalVariable.LoginPassword)

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Forgot Password_submit'))

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/span_QUICK ORDER'))

WebUI.click(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/a_Type Your Order_1'))

//WebUI.verifyElementText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/h4_Hoppon - Type your List below'), 
//    'Hoppon - Type your List below')

//WebUI.verifyElementText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/p_Just type the List of item(s) that you wa_e28db9'), 
//    'Just type the List of item(s) that you want, and send the List. Someone will get back to you shortly.')

WebUI.comment('Adding Key Item Without Selecting a Shop')

WebUI.setText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/input_Shopping List_myInput'),
	'pepsi')

//WebUI.verifyElementText(findTestObject('Object Repository/TypeOrder/Page_Hoppon - stores Order online food groc_e0fbcb/div_Please select a shop'), 
//    'Please select a shop.')

WebElement dropDownList =driver.findElement(By.xpath("//select[@id='spclordershopname2']"))

dropDownList.click()

dropDownList.sendKeys('Pr')

dropDownList.sendKeys(Keys.ARROW_DOWN)

dropDownList.sendKeys(Keys.ENTER)

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

