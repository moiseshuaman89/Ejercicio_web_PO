package hitoriaDeUsuario.page;

import net.serenitybdd.screenplay.actions.Scroll;
import org.jruby.RubyProcess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class CreateAccountPage extends BasePage {

    public @FindBy(id = "id_gender1") WebElement inputRadioButtonMr;
    public @FindBy(id = "id_gender2") WebElement inputRadioButtonMrs;
    public @FindBy(id = "customer_firstname") WebElement inputCustomerFirstName;
    public @FindBy(id = "customer_lastname") WebElement inputCustomerLastName;
    public @FindBy(id = "email") WebElement inputEmail;
    public @FindBy(id = "passwd") WebElement inputPastword;
    public @FindBy(id = "days") WebElement comboBoxDayBirth;
    public @FindBy(xpath = "//select[@id='days']/option[@value='@label']") WebElement selectDaysCombo;
    public @FindBy(id = "months") WebElement comboBoxMonthBirth;
    public @FindBy(xpath = "//select[@id='months']/option[@value='@label']") WebElement selectMounthCombo;
    public @FindBy(id = "years") WebElement comboBoxYearsBirth;
    public @FindBy(xpath = "//select[@id='years']/option[@value='@label']") WebElement selectYearCombo;
    public @FindBy(id = "newsletter") WebElement checkNewsletterInput;
    public @FindBy(id = "optin") WebElement checkOptinInput;
    public @FindBy(id = "firstname") WebElement inputFirstName;
    public @FindBy(id = "lastname") WebElement inputLastName;
    public @FindBy(id = "company") WebElement inputCompany;
    public @FindBy(id = "address1") WebElement inputAddress1;
    public @FindBy(id = "address2") WebElement inputAddress2;
    public @FindBy(id = "city") WebElement inputCity;
    public @FindBy(id = "id_country") WebElement comboId_country;
    public @FindBy(xpath = "//select[@id='id_country']/option[text()='@label']") WebElement selectCountryCombo;
    public @FindBy(id = "id_state") WebElement comboId_state;
    public @FindBy(xpath = "//select[@id='id_state']/option[text()='@label']") WebElement selectStateCombo;
    public @FindBy(id = "postcode") WebElement inputPostcode;
    public @FindBy(id = "other") WebElement inputOther;
    public @FindBy(id = "phone") WebElement inputPhone;
    public @FindBy(id = "phone_mobile") WebElement inputPhone_Mobile;
    public @FindBy(id = "alias") WebElement inputAlias;
    public @FindBy(id = "submitAccount") WebElement btnRegister;

    public CreateAccountPage() throws IOException {
        super();
    }

    public void registerUserDatosPersonales(String title, String firstName, String lastName, String email, String password) throws Exception {

        if(title.equals("Mr."))
            waitAndClickElement(inputRadioButtonMr);
        else
            waitAndClickElement(inputRadioButtonMrs);
        sendKeysToWebElement(inputCustomerFirstName,firstName);
        sendKeysToWebElement(inputCustomerLastName, lastName);
        inputEmail.clear();
        sendKeysToWebElement(inputEmail, email);
        sendKeysToWebElement(inputPastword, password);
    }

    public void registerFechaCumpleaños(String day, String mounth, String year) throws Exception{
        System.out.println("Day0");

        dayBirth(day);
        mounthBirth(mounth);
        yearBirth(year);
    }

    public void dayBirth(String day) throws Exception{
        if(!day.equals("")){
            System.out.println("Day1");
            comboBoxDayBirth.click();
            System.out.println("Day2");
            String xpathDay= replaceLabelXpath(selectDaysCombo,day);
            waitAndClickElementsUsingByLocator(By.xpath(xpathDay));
        }else{
            throw new Exception("Debe de ingresar una Dia de Cumpleaños");
        }
    }

    public void mounthBirth(String mounth) throws Exception{
        String numeroMounth="";
        if(!mounth.equals("")){
            comboBoxMonthBirth.click();
            if(mounth.equals("January"))
                numeroMounth="1";
            if(mounth.equals("February"))
                numeroMounth="2";
            if(mounth.equals("March"))
                numeroMounth="3";
            if(mounth.equals("April"))
                numeroMounth="4";
            if(mounth.equals("May"))
                numeroMounth="5";
            if(mounth.equals("June"))
                numeroMounth="6";
            if(mounth.equals("July"))
                numeroMounth="7";
            if(mounth.equals("August"))
                numeroMounth="8";
            if(mounth.equals("September"))
                numeroMounth="9";
            if(mounth.equals("October"))
                numeroMounth="10";
            if(mounth.equals("November"))
                numeroMounth="11";
            if(mounth.equals("December"))
                numeroMounth="12";
            String xpathDay= replaceLabelXpath(selectMounthCombo,numeroMounth);
            waitAndClickElementsUsingByLocator(By.xpath(xpathDay));
        }else{
            throw new Exception("Debe de ingresar una Dia de Cumpleaños");
        }
    }

    public void yearBirth(String year) throws Exception{
        if(!year.equals("")){
            comboBoxYearsBirth.click();
            String xpathDay= replaceLabelXpath(selectYearCombo,year);
            waitAndClickElementsUsingByLocator(By.xpath(xpathDay));
        }else{
            throw new Exception("Debe de ingresar una Dia de Cumpleaños");
        }
    }

    public void aceptarSuscripcionYOfertas() {
        checkNewsletterInput.click();
        checkOptinInput.click();
    }

    public void registerUserAddress(String firstName, String lastName, String company, String address, String address2, String city) throws Exception{
        Scroll.to(inputFirstName);
        inputFirstName.clear();
        sendKeysToWebElement(inputFirstName,firstName);
        inputLastName.clear();
        sendKeysToWebElement(inputLastName, lastName);
        sendKeysToWebElement(inputCompany, company);
        sendKeysToWebElement(inputAddress1, address);
        sendKeysToWebElement(inputAddress2, address2);
        sendKeysToWebElement(inputCity, city);
    }

    public void countryUSoOther(String country, String state, String codePostal, String informationAd, String phoneHome, String phoneMobil, String aliasAddress) throws Exception{
        if(!country.equals("")){
            comboId_country.click();
            String xpathCountry= replaceLabelXpath(selectCountryCombo,country);
            waitAndClickElementsUsingByLocator(By.xpath(xpathCountry));
            if(country.equals("United States")) {
                comboId_state.click();
                String xpathGenerico= replaceLabelXpath(selectStateCombo, state);
                waitAndClickElementsUsingByLocator(By.xpath(xpathGenerico));
                sendKeysToWebElement(inputPostcode,codePostal);
            }else
                throw new Exception("Debes de seleccionar el Country: United States");
            sendKeysToWebElement(inputOther,informationAd);
            sendKeysToWebElement(inputPhone,phoneHome);
            sendKeysToWebElement(inputPhone_Mobile,phoneMobil);
            inputAlias.clear();
            sendKeysToWebElement(inputAlias,aliasAddress);
        }
    }

    public void btnregister(){
        waitAndClickElement(btnRegister);
    }
}
