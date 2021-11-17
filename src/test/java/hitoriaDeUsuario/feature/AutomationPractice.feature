Feature: Ejercicios de Automatizacion - Registro de un nuevo usuarios

  @testPruebaweb01
  Scenario Outline: Cliente generado con todos los datos del cliente en la WEB
    Given la aplicacion Automation Practice se encuentra abierto
    When seleciona la opcion Sign In en el Header en la pantalla del Home
    And ingresa su Correo "<email>" y click en Crea tu Cuenta en la seccion Create an Account
    And ingresamos los datos personales como "<title>", "<firstName>", "<lastName>", "<email>", "<password>" en la seccion Create an Account
    And ingresamos su fecha de Cumpleaños "<day>", "<mounth>", "<year>" en la seccion Create an Account
    And nos suscribimos al Boletin y las ofertas de Socio en la seccion Create an Account
    And ingresamos muestra direccion "<firstName>", "<lastName>", "<company>", "<address>", "<address2>", "<city>" en la seccion Create an Account Address
    And seleccionamos el Pais "<country>", "<state>", "<codePostal>", "<other>", "<phoneHome>", "<phoneMobile>", "<reference>" en la seccion Create an Account Address
    And selecciona el boton Register en la seccion Create an Account
    Then se muestra el nombre del Usuario Creado "<firstName>" "<lastName>" en el Header de la pantalla del Home

    Examples:
      | email                           | password  | title | firstName     | lastName      | day | mounth | year | company  | address             | address2             | city | country       | state       | codePostal | other | phoneHome | phoneMobile | reference              |
      | pruebasMoises001@mailinator.com | 123456789 | Mr.   | Moises Andres | Huaman Roncal | 15  | August | 1989 | medicser | Calle los pinos 122 | Paseo del Bosque 111 | peru | United States | Puerto Rico | 00601      | uhuhu | 01555326  | 974683888   | Al costado de una casa |

