import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Hoppon_SignIn/Login_Hoppon_TC3'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('Object Repository/AddToCart/Page_Hoppon - stores Order online food grocery vegetables, fruits , home delivery/img'))
WebDriver driver = DriverFactory.getWebDriver()

//variables
String baseURL = WebUI.getUrl()

flag = true

flagOne = true

List<WebElement> cateList

int size

int randCate

List<WebElement> cateItemList

int randCateItem

String buttonText

while (flagOne == true) {
    WebUI.navigateToUrl(baseURL)

    flag = true

    while (flag == true) {
        List<WebElement> storeList = driver.findElements(By.xpath('//div[@id=\'outputsort\']/div'))

        int randInt = (Math.random() * ((storeList.size() - 0) + 1)) + 0

        (storeList[randInt]).click()
		
        cateList = driver.findElements(By.xpath('/html[1]/body[1]/div[10]/div[1]/div[1]/aside[1]/div[1]/div[2]/ul[1]/li'))

        System.out.println(cateList.size())

        size = cateList.size()

        if (size != 0) {
            flag = false
        }
    }
    
    if (flag == false) {
        randCate = ((Math.random() * ((size - 0) + 1)) + 0)

        System.out.println(size)

        (cateList[randCate]).click()

        cateItemList = driver.findElements(By.xpath('/html[1]/body[1]/div[10]/div[1]/div[2]/main[1]/div[3]/ul[1]/li/div[1]/div[2]/button[1]'))

        System.out.println(cateItemList.size())

        randCateItem = ((Math.random() * ((cateItemList.size() - 0) + 1)) + 0)

        System.out.println(randCateItem)

        buttonText = (cateItemList[randCateItem]).getText()

        System.out.println(buttonText)

        if (buttonText.equals('ADD TO CART')) {
            (cateItemList[randCateItem]).click()

            flagOne = false
        }
    } else {
        flagOne = false
    }
}

