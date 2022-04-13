import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Hoppon_SignIn/Login_Hoppon_TC3'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('SHOP BY PROMOS', false)

WebUI.click(findTestObject('Shop_By_Promo/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/a_shop by promos'))

WebDriver driver1 = DriverFactory.getWebDriver()

String selector = 'div.col-md-12.col-sm-12.col-xs-12'

ArrayList items = driver1.findElements(By.cssSelector(selector))

ArrayList list1 = new ArrayList()


WebUI.click(findTestObject('Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/i_Sign in_fa fa-question fa-stack-1x enquirepopup'))

WebUI.verifyTextPresent('ENQUIRE', false)

WebUI.verifyElementPresent(findTestObject('Object Repository/Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/promoDetails'), 
    0)

WebUI.setText(findTestObject('Object Repository/Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/textarea_Enter Your enquiries here_specialinstruction'), 
    'Test data')

WebElement phoneInput = driver1.findElement(By.xpath('//input[@id=\'enquire_number\']'))

if (phoneInput.getText() != '') {
    WebUI.clearText(findTestObject('Object Repository/Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/input_Contact Number_number'))
}

WebUI.setText(findTestObject('Object Repository/Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/input_Contact Number_number'), 
    '123456789')

WebUI.click(findTestObject('Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/button_Submit'))

WebUI.verifyTextPresent('Please enter a valid Phone number.', false)

WebUI.click(findTestObject('Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/button_Ok'))

WebUI.setText(findTestObject('Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/input_Contact Number_number'), 
    '9048248781')

WebUI.click(findTestObject('Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/button_Submit'))

WebUI.click(findTestObject('Shop_By_Promo/ForEnquiry/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/button_No'))

WebUI.delay(3)

WebUI.navigateToUrl('https://shoptest.hopponapp.com/promos/')

WebElement cartBag = driver1.findElement(By.xpath('//span[@id=\'loggedincart\']/a'))

String EmptyCart = cartBag.getText()

System.out.println(EmptyCart)

WebUI.click(findTestObject('Object Repository/Shop_By_Promo/ForAddToCart/Page_Promos - Hoppon/AddtocartIcon'))

String cartWithItem = cartBag.getText()

System.out.println(cartWithItem)

if (EmptyCart != cartWithItem) {
    WebUI.click(findTestObject('Shop_By_Promo/ForAddToCart/Page_Promos - Hoppon/a_1 Item(s)                                                            in cart'))
}

WebUI.navigateToUrl('https://shoptest.hopponapp.com/promos/')

List<WebElement> categoryList = driver1.findElements(By.xpath('//*[@class=\'btn btn-category indsutryimage\']'))

(categoryList[14]).click()

List<WebElement> dropDownList = driver1.findElements(By.xpath('//select[@id=\'promosfilterstore\']/option'))

System.out.println(dropDownList.size())

for (WebElement dDL : dropDownList) {
    dDL.click()

    WebUI.delay(4)

    List<WebElement> todaysPromoListOne = driver1.findElements(By.xpath('//div[@id=\'outputsort\']/div/div'))

    System.out.println(todaysPromoListOne.size())

    if (todaysPromoListOne.size() == 0) {
        WebUI.verifyTextPresent('NO PROMOS FOUND IN THIS STORE.', false)
    }
    
    WebUI.delay(4)
}

WebUI.navigateToUrl('https://shoptest.hopponapp.com/promos/')

