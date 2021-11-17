package hitoriaDeUsuario.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class AutomationPracticeHomePage extends BasePage {

    public @FindBy(xpath = "//img[@class='logo img-responsive']") WebElement imgLogoWeb;
    public @FindBy(xpath = "//a[@class='login']") WebElement btnSignIn;
    public @FindBy(id = "email_create") WebElement inputEmail;
    public @FindBy(id = "SubmitCreate") WebElement btnCreateOnAccount;
    public @FindBy(xpath = "//a[@class='account']") WebElement textUserLogin;

    public AutomationPracticeHomePage() throws IOException {
        super();
    }

    public boolean irWebAutomationPractice() {
        boolean okPage = false;
        getDriver().get("http://automationpractice.com/index.php");
        if(WaitUntilWebElementIsVisible(imgLogoWeb))
            okPage=true;
        return okPage;
    }
    public void clickBottonSignIn()  {
        waitAndClickElement(btnSignIn);
    }
    public void ingresarEmailYBtnCreate(String email) throws Exception{
        sendKeysToWebElement(inputEmail,email);
        waitAndClickElement(btnCreateOnAccount);
    }

    public boolean validarRegistroNewUser(String firstName, String lastName) throws Exception {
        boolean okUser= false;
        String userLogin= getTextToWebElement(textUserLogin);
        String nameCompleted = firstName + " " + lastName;
        System.out.println("Name User: "+ userLogin+" "+ nameCompleted);
        if (nameCompleted.equals(userLogin))
            okUser=true;
        return okUser;
    }


}
