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

if (WebUI.verifyElementClickable(findTestObject('Hoppon/SignIn/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/a_Sign In')) == 
true) {
    print('It is clickable')
} else {
    'It is not clickable'
}

WebUI.delay(5)

WebUI.click(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/span_Sign In'))

WebUI.verifyTextPresent('LOGIN', false)

WebUI.setText(findTestObject('Hoppon/Login/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/input_Email_email'), 
    GlobalVariable.LoginUsername)

WebUI.setEncryptedText(findTestObject('Hoppon/Login/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/input_Password_password'), 
    GlobalVariable.LoginPassword)

WebUI.click(findTestObject('Hoppon/Login/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/input_Forgot Password_submit'))

WebUI.waitForElementVisible(findTestObject('Hoppon/Login/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/span_Aneesh'), 
    6)

WebUI.verifyTextPresent('Aneesh', false)


