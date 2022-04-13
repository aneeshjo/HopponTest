import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys

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

WebUI.click(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/a_Log in with Facebook'))

WebUI.setText(findTestObject('Hoppon/SignIn/Page_Log in to Facebook  Facebook/input_Log in to Facebook_email'), GlobalVariable.Username)

WebUI.setEncryptedText(findTestObject('Hoppon/SignIn/Page_Log in to Facebook  Facebook/input_Log in to Facebook_pass'), GlobalVariable.Password)

WebUI.click(findTestObject('Hoppon/SignIn/Page_Log in to Facebook  Facebook/button_Log In'))

WebUI.setText(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/input_Please enter Phone number_mob-number'), 
    '9048248781')

WebUI.click(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/button_Submit'))

WebUI.click(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/button_Ok'))

WebUI.delay(10)

WebUI.click(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/input_Privacy Policy_otpmycheck'))

WebUI.click(findTestObject('Hoppon/SignIn/NewObjects/Page_Hoppon - stores Order online food groc_e0fbcb/button_Submit_1'))

