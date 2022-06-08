package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutoExPage {
    public AutoExPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    public WebElement signupLoginButton;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignup;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement newUserNameBoxElement;

    @FindBy(xpath = "//button[text()='Signup']")
    public WebElement signupButton;

    @FindBy(xpath = "//*[text()='Enter Account Information']")
    public WebElement enterAccountInfoTextElement;

    @FindBy(xpath = "//input[@value='Mr']")
    public WebElement acountInfoMrRadioButton;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement acountCreatedTextBox;

    @FindBy(xpath = "//a[text()='Continue']")
    public WebElement acountCreatedContinueButton;

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement userNameElement;

    @FindBy(xpath = "//*[text()=' Delete Account']")
    public WebElement deleteAccountElement;

}
