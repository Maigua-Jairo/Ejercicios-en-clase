import java.util.Scanner;
public class FOR {
    public static void main(String[] args) {
        Scanner operacion= new Scanner(System.in);
        int numero;
        int resultado;
        System.out.println("Ingrese un numero para multiplicar:");
        numero=operacion.nextInt();

        //Operacion
        for(int i=1;i<=10;i++){
            resultado= numero*i;
            System.out.println(numero+"*"+i+"="+resultado);
        }
    }
}
