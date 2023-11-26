package trabajoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona {
  private String nombre;
  private String apellido;
  private String dni;
  private Date fechaNacimiento;

  public Persona() {
  }

  public Persona(String nombre, String apellido, String dni, Date fechaNacimiento) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void mostrarDatos() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println("Nombre: " + nombre);
    System.out.println("Apellido: " + apellido);
    System.out.println("DNI: " + dni);
    System.out.println("Fecha de Nacimiento: " + sdf.format(fechaNacimiento));
  }
  
  public static boolean validarNombre(String nombre){
    return nombre.isEmpty();
  }
  
  public static boolean validarApellido(String apellido){
    return apellido.isEmpty();
  }
    
  public static boolean validarFechaNacimiento(Date fechaNacimiento) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false); // Esto hace que SimpleDateFormat sea estricto en la validación

    try {
      // Intentar parsear la fecha
      Date parsedDate = sdf.parse(sdf.format(fechaNacimiento));

      // Verificar si la fecha original y la fecha parseada son iguales
      return fechaNacimiento.equals(parsedDate);
    } catch (ParseException e) {
      // La excepción ocurrirá si la fecha no es válida
      return false;
    }  }
  
  public static boolean validarDni(String dni){
    if (!dni.isEmpty()) {
      if (dni.length() < 8){
      return false;
      }
    }
    return true;
  }
}
