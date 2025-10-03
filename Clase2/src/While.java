import java.util.Scanner;
public class While {
    public static void main(String[] args) {
        Scanner credenciales=new Scanner(System.in);
        String contrasena="maigua";
        String usuario="jairo";
        String user, passsword;

        while(true){
            System.out.println("Ingrese su usuario: ");
            user=credenciales.nextLine();
            System.out.println("Ingrese su contrasena: ");
            passsword=credenciales.nextLine();
            if (user.equals(usuario)&&contrasena.equals(passsword)){
                System.out.println("Bienvenido al sistema");
                break;
            }else {
                System.out.println("Usuario o contraseña incorrectos");
            }
        }
    }

}
