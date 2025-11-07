public  class Persona {
    String cedula;
    String nombre;
    int edad;

    public Persona (String cedula, String nombre, int edad){
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void ImprimirEstudiante(){
        System.out.println("========  DATOS PERSONALES ========");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("Cedula: " + this.cedula);
    }
}
 class Estudiante extends Persona{
   String codigo;

   public Estudiante(String cedula, String nombre, int edad,  String codigo){
       super(cedula, nombre, edad); //Super llama al metodo constructor de Persona
       this.codigo=codigo;
   }

   public void ImprimirDocente(){
       System.out.println("========  DATOS PERSONALES  DEL ESTUDIANTE ========");
       super.Imprimir(); //Super ayuda a traer
       System.out.println("Codigo: " + this.codigo);
   }
}

class Docente extends Persona{ //Extends hace que una clase herede de una clase padre
 String materias;              //A la derecha siempre va la clase padre

    public Docente(String cedula, String nombre, int edad, String materias){
        super(cedula, nombre, edad);
        this.materias = materias;
    }

    public void Imprimir(){
        System.out.println("========  DATOS PERSONALES DEL DOCENTE ========");
        super.Imprimir();
        System.out.println("Materias: " + this.materias);
    }
}