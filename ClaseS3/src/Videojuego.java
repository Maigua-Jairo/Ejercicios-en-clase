import java.util.Scanner;
public class Videojuegos {
    private String codigoPartida;
    private double daño;

    //Constructores
    public Videojuegos() {
        codigoPartida= "1234A";
        daño= 0;
    }
    public Videojuegos(String codigoPartida, double daño){
        this.codigoPartida=codigoPartida;
        this.daño=daño;
    }

    public void MostrarInformacion(){
        System.out.println("El jugador con el codigo"+codigoPartida+"realizo un daño total de: "+daño);
    }
    public void CalculoDaño(double calculo){
        

    }
}