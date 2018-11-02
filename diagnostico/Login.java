import java.io.Console;

/**
 * Clase de implementación de Diagnóstico.
 *
 * @author psep
 */
public class Login {

  /**
   * Atributo para la contraseña actual.
   */
  public String currentPasswd;

  /**
   * Atributo para la nueva contraseña.
   */
  public String newPasswd1;

  /**
   * 2do Atributo para la nueva contraseña.
   */
  public String newPasswd2;

  /**
   * Método principal de Login.
   *
   * Se genera una instancia de Login, donde se solicita el ingreso
   * de la contraseña actual, seguido de la nueva contraseña. Se valida
   * que la contraseña nueva no sea igual a la actual, para luego solicitar
   * reingresar la nueva contraseña y se valida que sea igual a la ingresada
   * anteriormente.
   */
  public static void main(String[] args) {
    try {
      Login login = new Login();
      Console console = System.console();
      login.currentPasswd = new String(console.readPassword("Ingrese su contraseña actual: "));
      login.newPasswd1 = new String(console.readPassword("Ingrese nueva contraseña: "));

      if (!login.validaPass2()) {
        System.err.println("Error: La contraseña nueva no puede ser igual a la actual");
      } else {
        login.newPasswd2 = new String(console.readPassword("Reingrese nueva contraseña: "));
        if (!login.validaPass1()) {
          System.err.println("Error: Las contraseñas nuevas no coinciden!");
        } else {
          System.out.println("Contraseña cambiada con éxito");
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * Método que valida el doble ingreso de la nueva
   * contraseña a fin de confirmar.
   *
   * @return boolean
   */
  public boolean validaPass1() {
    if (this.newPasswd1.equals(this.newPasswd2)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Método que valida que la contraseña anterior no
   * sea igual a la nueva.
   *
   * @return boolean
   */
  public boolean validaPass2() {
    if (!this.newPasswd1.equals(this.currentPasswd)) {
      return true;
    } else {
      return false;
    }
  }

}
