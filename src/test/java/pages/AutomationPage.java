package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationPage {
    public AutomationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='login']")
    public WebElement singInButton;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//i[@class='icon-user left']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement gender;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//*[text()='Welcome to your account. Here you can manage all of your personal information and orders.']")
    public WebElement positiveResultText;

    @FindBy(xpath = "//*[text()='Invalid email address.']")
    public WebElement negativeResultText;

}
