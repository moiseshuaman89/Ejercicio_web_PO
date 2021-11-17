package hitoriaDeUsuario.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import util.Driver;

public class AutomationPracticeSteps extends Driver{
    @Given("^la aplicacion Automation Practice se encuentra abierto$")
    public void laAplicacionAutomationPracticeSeEncuentraAbierto() {
        Assert.assertTrue("No se encuentra abierto Automation Practice...", automationPracticeHomePage.irWebAutomationPractice());
    }

    @When("^seleciona la opcion Sign In en el Header en la pantalla del Home$")
    public void selecionaLaOpcionSignInEnElHeaderEnLaPantallaDelHome() {
        automationPracticeHomePage.clickBottonSignIn();
    }

    @And("^ingresa su Correo \"([^\"]*)\" y click en Crea tu Cuenta en la seccion Create an Account$")
    public void ingresaSuCorreoYClickEnCreaTuCuentaEnLaSeccionCreateAnAccount(String email) throws Throwable {
        automationPracticeHomePage.ingresarEmailYBtnCreate(email);
    }

    @And("^ingresamos los datos personales como \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" en la seccion Create an Account$")
    public void ingresamosLosDatosPersonalesComoEnLaSeccionCreateAnAccount(String title, String firstName, String lastName, String email, String password) throws Throwable {
        createAccountPage.registerUserDatosPersonales(title, firstName, lastName, email, password);
    }

    @And("^ingresamos su fecha de Cumpleaños \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" en la seccion Create an Account$")
    public void ingresamosSuFechaDeCumpleañosEnLaSeccionCreateAnAccount(String day, String mounth, String year) throws Throwable {
        createAccountPage.registerFechaCumpleaños(day, mounth, year);
    }

    @And("^nos suscribimos al Boletin y las ofertas de Socio en la seccion Create an Account$")
    public void nosSuscribimosAlBoletinYLasOfertasDeSocioEnLaSeccionCreateAnAccount() {
        createAccountPage.aceptarSuscripcionYOfertas();
    }

    @And("^ingresamos muestra direccion \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" en la seccion Create an Account Address$")
    public void ingresamosMuestraDireccionEnLaSeccionCreateAnAccountAddress(String firstName, String lastName, String company, String address, String address2, String city) throws Throwable {
        createAccountPage.registerUserAddress(firstName, lastName, company, address, address2, city);
    }

    @And("^seleccionamos el Pais \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" en la seccion Create an Account Address$")
    public void seleccionamosElPaisEnLaSeccionCreateAnAccountAddress(String country, String state, String codePostal, String informationAd, String phoneHome, String phoneMobil, String aliasAddress) throws Throwable {
        createAccountPage.countryUSoOther(country, state, codePostal, informationAd, phoneHome, phoneMobil, aliasAddress);
    }

    @And("^selecciona el boton Register en la seccion Create an Account$")
    public void seleccionaElBotonRegisterEnLaSeccionCreateAnAccount() {
        createAccountPage.btnregister();
    }

    @Then("^se muestra el nombre del Usuario Creado \"([^\"]*)\" \"([^\"]*)\" en el Header de la pantalla del Home$")
    public void seMuestraElNombreDelUsuarioCreadoEnElHeaderDeLaPantallaDelHome(String firstName, String lastName) throws Throwable {
        Assert.assertTrue("El Nombre del usuario no es el Correcto...",automationPracticeHomePage.validarRegistroNewUser(firstName, lastName));
    }
}