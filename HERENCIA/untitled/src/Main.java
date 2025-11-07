import javax.print.attribute.standard.DocumentName;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);

    //DATOS
    Persona persona1= new Persona("1753657905", "Jairo Maigua", 20);
    Estudiante estudiante= new Estudiante("1234567890", "Diego Camacho", 20, "202410189");
    Docente docente= new Docente("0987654321", "Anthony Ledesma", 20, "LENGUAJE Y COMUNICACION");

    persona1.Imprimir();
    estudiante.Imprimir();
    docente.Imprimir();

    }
}