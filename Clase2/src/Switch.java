import  java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        int numero;
        int resultado;
        String contrasena = "maigua";
        String usuario = "jairo";
        String password, user;
        System.out.println("Ingrese una opcion: ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese su usuario: ");
                user = sc.nextLine();
                System.out.println("Ingrese su contraseña: ");
                password = sc.nextLine();
                if (user.equals(usuario) && password.equals(contrasena)) {
                    System.out.println("Bienvenio al sistema");
                } else {
                    System.out.println("El usuario o contraseña es incorrecto");
                }
                break;
            case 2:
                System.out.println("Ingrese un numero para multiplicar:");
                numero = sc.nextInt();

                //Operacion
                for (int i = 1; i <= 10; i++) {
                    resultado = numero * i;
                    System.out.println(numero + "*" + i + "=" + resultado);
                }
                break;
            case 3:
                while (true) {
                    System.out.println("Ingrese su usuario: ");
                    user = sc.nextLine();
                    System.out.println("Ingrese su contrasena: ");
                    password = sc.nextLine();
                    if (user.equals(usuario) && contrasena.equals(password)) {
                        System.out.println("Bienvenido al sistema");
                        break;
                    } else {
                        System.out.println("Usuario o contraseña incorrectos");
                    }
                    break;

                }
        }
    }
}




