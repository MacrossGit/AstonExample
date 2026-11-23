import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private final By cookie = By.cssSelector("button#cookie-agree");
    private final By heading = By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > h2");
    private final By paymentSystems = By.cssSelector("div.pay__partners, footer .partner-list");
    private final By visa = By.cssSelector("img[alt='Visa'], img[alt='VISA']");
    private final By visa2 = By.cssSelector("img[alt='Verified By Visa'], img[alt='Visa'], img[alt='VISA']");
    private final By masterCard = By.cssSelector("img[alt='MasterCard']");
    private final By masterCardSecureCode = By.cssSelector("img[alt='MasterCard Secure Code'], img[alt='MasterCard']");
    private final By belCard = By.cssSelector("img[alt='Белкарт'], img[alt='BELKART']");
    private final By buttonMoreDetailed = By.cssSelector("#pay-section > div > div > div.col-12.col-xl-8 > section > div > a");
    private final By phone = By.cssSelector("input.phone#connection-phone");
    private final By sumRub = By.cssSelector("input#connection-sum");
    private final By buttonNext = By.cssSelector("div.pay__forms form#pay-connection button.button.button__default");
    private final By phoneNumber = By.cssSelector("input#connection-phone");
    private final By sum = By.cssSelector("input#connection-sum");
    private final By email = By.cssSelector("input#connection-email");
    private final By dropDownButton = By.cssSelector("div.select__wrapper button.select__header");
    private final By dropDownList = By.cssSelector("ul.select__list");
    private final By internetPhone = By.cssSelector("input#internet-phone");
    private final By internetSum = By.cssSelector("input#internet-sum.total_rub");
    private final By internetEmail = By.cssSelector("input#internet-email");
    private final By instalmentAccount = By.cssSelector("input#score-instalment");
    private final By instalmentSum = By.cssSelector("input#instalment-sum");
    private final By instalmentEmail = By.cssSelector("input#instalment-email");
    private final By arrearsAccount = By.cssSelector("input#score-arrears");
    private final By arrearsSum = By.cssSelector("input#arrears-sum");
    private final By arrearsEmail = By.cssSelector("input#arrears-email");
    private final By paymentFrame = By.cssSelector("iframe.payment-widget-iframe");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage coockiClic() {
        if (!driver.findElements(cookie).isEmpty()) {
            waitAndClick(cookie);
        }
        return this;
    }

    public String getHeading() {
        return waitAndGetText(heading);
    }

    public boolean checkPaymentSystems() {
        return waitForElementIsVisible(paymentSystems);
    }

    public boolean checkVisa() {
        return waitForElementIsVisible(visa);
    }

    public boolean checkVisa2() {
        return waitForElementIsVisible(visa2);
    }

    public boolean checkMasterCard() {
        return waitForElementIsVisible(masterCard);
    }

    public boolean checkMasterCardSecureCode() {
        return waitForElementIsVisible(masterCardSecureCode);
    }

    public boolean checkBelcard() {
        return waitForElementIsVisible(belCard);
    }

    public MainPage clickButtonMoreDetailed() {
        waitAndClick(buttonMoreDetailed);
        return this;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public MainPage numberPhone(String number) {
        waitClearAndType(phone, number);
        return this;
    }

    public MainPage rubSum(String amount) {
        waitClearAndType(sumRub, amount);
        return this;
    }

    public MainPage next() {
        waitAndClick(buttonNext);
        return this;
    }

    public String checkphoneNumber() {
        return getAttribute(phoneNumber, "placeholder");
    }

    public String checkSumma() {
        return getAttribute(sum, "placeholder");
    }

    public String checkEmail() {
        return getAttribute(email, "placeholder");
    }

    public MainPage clickButtonDropDownList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownButton));
        waitAndClick(dropDownButton);
        return this;
    }

    public MainPage selectByText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownButton));
        waitAndClick(dropDownButton);
        By item = By.xpath("//li[contains(@class,'select__item') and .//p[contains(text(),'" + text + "')]]");
        wait.until(ExpectedConditions.elementToBeClickable(item));
        waitAndClick(item);
        return this;
    }

    public MainPage clickButtonByNumber(int number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownButton));
        waitAndClick(dropDownButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownList));
        By item = By.cssSelector("li.select__item:nth-child(" + number + ")");
        wait.until(ExpectedConditions.elementToBeClickable(item));
        waitAndClick(item);
        return this;
    }

    public String getinternetNumberPhone() {
        return getAttribute(internetPhone, "placeholder");
    }

    public String getSumHomeInternet() {
        return getAttribute(internetSum, "placeholder");
    }

    public String getEmailInternetHome() {
        return getAttribute(internetEmail, "placeholder");
    }

    public String getAccountNumber() {
        return getAttribute(instalmentAccount, "placeholder");
    }

    public String getInstalmentSum() {
        return getAttribute(instalmentSum, "placeholder");
    }

    public String getEmailInstallmentPlan() {
        return getAttribute(instalmentEmail, "placeholder");
    }

    public String getScoreArrears() {
        return getAttribute(arrearsAccount, "placeholder");
    }

    public String getArrearsSum() {
        return getAttribute(arrearsSum, "placeholder");
    }

    public String getArrearsEmail() {
        return getAttribute(arrearsEmail, "placeholder");
    }

    public PaymentFramePage switchToPaymentFrame() {
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFrame));
        driver.switchTo().frame(frame);
        return new PaymentFramePage(driver);
    }
}
