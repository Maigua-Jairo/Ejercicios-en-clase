import java.util.Scanner;
import java.util.ArrayList;
public class GestionPrecios {
    //Declarar el array
    private ArrayList<Double> precios;
    private Scanner scanner; //Declaramos el Scanner de esta forma para evitar reutilizar el codigo
    //Constructor
    public GestionPrecios(){
        this.precios=new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
   //Metodos
    public void ingresarPrecio(){
        System.out.println("Introduce el precio de la casa o departamento: ");
        double precio=scanner.nextDouble();
        if(precio>0){
            precios.add(precio);
        }
    }
    public void mostrarPrecios() {
        if(precios.isEmpty()){
        System.out.println("No existen precios registrados");
    }else{
            System.out.println("========== PRECIOS ============");
            int contador=1;
            for(Double precio:precios) {
                System.out.println("Inmobiliario "+contador+": $"+precio);
                contador++;
      }
     }
    }
    public void precioMasAlto(){
        if(precios.isEmpty()){
            System.out.println("No existen precios registrados");
        }else{
            double maxPrecio=precios.get(0); //Elemento 0 de la lista como referencia
           for(int i=0;i<precios.size(); i++) {
               if (precios.get(i) > maxPrecio) {
                   maxPrecio = precios.get(i);
               }
           }
            System.out.println("El precio mas alto es: $"+maxPrecio);
        }
    }
    public void precioMasBajo(){
        if(precios.isEmpty()){
            System.out.println("No existen precios registrados");
        }else{
        double minPrecio=precios.get(0);
        for(Double precio: precios) {
            if (precio< minPrecio) {
                minPrecio = precio;
            }
        }
            System.out.println("El precio más bajo es: $"+minPrecio);
        }
    }
    public void preciosIguales(){
        if(precios.isEmpty()){
            System.out.println("No existen precios registrados");
        }else {
                System.out.println("\n=== PRECIOS IGUALES ===");
                boolean hayDuplicados = false;

                // Recorrer el ArrayList
                for (int i = 0; i < precios.size(); i++) {
                    // Buscar si hay otro precio igual adelante
                    for (int j = i + 1; j < precios.size(); j++) {
                        if (precios.get(i).equals(precios.get(j))) {
                            System.out.println("$" + precios.get(i));
                            hayDuplicados = true;
                            break;
                        }
                    }
                }

                if (!hayDuplicados) {
                    System.out.println(" No hay precios iguales.");
                }
            }
    }

    public void buscarPrecio(){
        if(precios.isEmpty()){
            System.out.println("No existen precios registrados");
        }
        else{
            System.out.println("Ingrese el precio a buscar: ");
            double buscar=scanner.nextDouble();
            if(precios.contains(buscar)){
                System.out.println("Se encontró el precio: "+buscar);
            }else{
                System.out.println("No se encontro el precio solicitado.");
            }
        }

    }
}
