package trabajoint;

import javax.swing.JOptionPane;
import static trabajoint.Registro.agregarRegistro;
import static trabajoint.Registro.mostrarPersonas;

public class TrabajoInt1 {

  public static void main(String[] args) {
    Registro registro = new Registro();
    
    while (true) {
      String opcion = JOptionPane.showInputDialog(
              "1. Agregar Estudiante\n"
              + "2. Mostrar Estudiantes\n"
              + "3. Salir\n"
              + "Seleccione una opción:");

      switch (opcion) {
        case "1":
          agregarRegistro(registro);
          break;
        case "2":
          mostrarPersonas(registro);
          break;
        case "3":
          System.out.println("Saliendo del programa.");
          System.exit(0);
        default:
          JOptionPane.showMessageDialog(null, "Opción no válida. Inténtelo de nuevo.");
      }
    }      
  }
}