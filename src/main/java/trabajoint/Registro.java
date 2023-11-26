package trabajoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static trabajoint.Persona.validarApellido;
import static trabajoint.Persona.validarDni;
import static trabajoint.Persona.validarNombre;

import static trabajoint.Persona.validarFechaNacimiento;

public class Registro {
  private final ArrayList<Persona> personas = new ArrayList<>();
  
  public void agregar(Persona persona){
    personas.add(persona);
  }
  
  public ArrayList<Persona> getPersonas(){
    return personas;
  }
  
  public void mostrarPersonas(){
    for (Persona persona: personas){
      persona.mostrarDatos();
      System.out.println("_______________");
    }
  }
  
  public static void agregarRegistro(Registro registro) {
    Persona persona = new Persona();

    String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
    String apellido = JOptionPane.showInputDialog("Ingrese el apellido:");

    if ((validarApellido(apellido)) || (validarNombre(nombre))) {
      JOptionPane.showMessageDialog(null, "El nombre y el apellido no pueden estar en blanco.");
      return;
    }

    persona.setNombre(nombre);
    persona.setApellido(apellido);

    String dni = JOptionPane.showInputDialog("Ingrese el DNI:");

    if (!validarDni(dni)) {
      JOptionPane.showMessageDialog(null, "El DNI debe ser un número válido de 8 dígitos.");
      return;
    }

    persona.setDni(dni);

    String fechaNacimientoStr = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/MM/yyyy):");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
      Date fechaNacimiento = sdf.parse(fechaNacimientoStr);

      if (!validarFechaNacimiento(fechaNacimiento)) {
        JOptionPane.showMessageDialog(null, "La fecha de nacimiento no es válida.");
        return;
      }

      persona.setFechaNacimiento(fechaNacimiento);
    } catch (ParseException e) {
      JOptionPane.showMessageDialog(null, "Error al ingresar la fecha. Asegúrese de usar el formato correcto.");
      return;
    }

    registro.agregar(persona);
    JOptionPane.showMessageDialog(null, "Persona agregada exitosamente.");
  }
  
  public static void mostrarPersonas(Registro registro) {
    StringBuilder mensaje = new StringBuilder();
    for (Persona persona : registro.getPersonas()) {
      mensaje.append("Nombre: ").append(persona.getNombre()).append("\n");
      mensaje.append("Apellido: ").append(persona.getApellido()).append("\n");
      mensaje.append("DNI: ").append(persona.getDni()).append("\n");
      mensaje.append("Fecha de Nacimiento: ").append(persona.getFechaNacimiento()).append("\n");
      mensaje.append("______________\n");
    }
    JOptionPane.showMessageDialog(null, mensaje.toString());
  }
}
