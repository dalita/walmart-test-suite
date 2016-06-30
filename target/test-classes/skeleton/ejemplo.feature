Feature: Loguearse en gmail
  Scenario: Autenticarse
    Given Dado la pagina de login de gmail
    When Cuando el usuario introduce : usuario  "dalitagh@gmail.com"
    And Usuario presiona boton siguiente
    And Usuario introduce: contrasena "nascarteam888"
    And Usuario clickea boton login
    Then El sistema debe mostrar la lista de correos del usuario




  Scenario: Autenticarse facebook
    Given Dado la pagina de login de facebook
    When Cuando el usuario introduce : user  "dalifaceb@gmail.com"
    And Cuando el user introduce : contrasena "andromeda1"
    And Usuario clickea boton entrar
    Then El sistema debe mostrar el muro del usuario

