// Clase principal con menú

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2 {
    private static ArrayList<Olimpiada> olimpiadas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE OLIMPIADAS ===");
            System.out.println("1. Crear nueva Olimpiada");
            System.out.println("2. Agregar Evento a Olimpiada");
            System.out.println("3. Registrar Atleta en Evento");
            System.out.println("4. Registrar Equipo en Evento");
            System.out.println("5. Consultar Olimpiadas y Eventos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            try {
                switch(opcion) {
                    case 1:
                        crearOlimpiada();
                        break;
                    case 2:
                        agregarEvento();
                        break;
                    case 3:
                        registrarAtleta();
                        break;
                    case 4:
                        registrarEquipo();
                        break;
                    case 5:
                        consultarInformacion();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (DatosInsuficientesException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } while(opcion != 6);
    }

    private static void crearOlimpiada() throws DatosInsuficientesException {
        System.out.print("Nombre de la Olimpiada: ");
        String nombre = scanner.nextLine();
        System.out.print("Año: ");
        String anio = scanner.nextLine();

        if(nombre.isEmpty() || anio.isEmpty()) {
            throw new DatosInsuficientesException("El nombre y año son obligatorios");
        }

        Olimpiada olimpiada = new Olimpiada(nombre, anio);
        olimpiadas.add(olimpiada);
        System.out.println("Olimpiada creada exitosamente!");
    }

    private static void agregarEvento() throws DatosInsuficientesException {
        if(olimpiadas.isEmpty()) {
            throw new DatosInsuficientesException("No hay olimpiadas registradas");
        }

        System.out.println("\nOlimpiadas disponibles:");
        for(int i = 0; i < olimpiadas.size(); i++) {
            System.out.println(i + ". " + olimpiadas.get(i).getNombreOlimpiada());
        }

        System.out.print("Seleccione olimpiada: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre del evento: ");
        String nombreEvento = scanner.nextLine();
        System.out.print("Fecha: ");
        String fecha = scanner.nextLine();

        if(nombreEvento.isEmpty() || fecha.isEmpty()) {
            throw new DatosInsuficientesException("El nombre y fecha del evento son obligatorios");
        }

        Evento evento = new Evento(nombreEvento, fecha);
        olimpiadas.get(indice).agregarEvento(evento);
        System.out.println("Evento agregado exitosamente!");
    }

    private static void registrarAtleta() throws DatosInsuficientesException {
        Evento evento = seleccionarEvento();

        System.out.print("Nombre del atleta: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
        String fechaNac = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Deporte: ");
        String deporte = scanner.nextLine();

        if(nombre.isEmpty() || cedula.isEmpty() || fechaNac.isEmpty() || nacionalidad.isEmpty() || deporte.isEmpty()) {
            throw new DatosInsuficientesException("Todos los datos del atleta son obligatorios");
        }

        Atleta atleta = new Atleta(nombre, cedula, fechaNac, nacionalidad, deporte);
        evento.registrarParticipante(atleta);
        System.out.println("Atleta registrado exitosamente!");
    }

    private static void registrarEquipo() throws DatosInsuficientesException {
        Evento evento = seleccionarEvento();

        System.out.print("Nombre del equipo: ");
        String nombre = scanner.nextLine();
        System.out.print("Cédula/Registro: ");
        String cedula = scanner.nextLine();
        System.out.print("Fecha de formación (dd/mm/aaaa): ");
        String fechaNac = scanner.nextLine();
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Número de integrantes: ");
        int integrantes = scanner.nextInt();

        if(nombre.isEmpty() || cedula.isEmpty() || fechaNac.isEmpty() || nacionalidad.isEmpty() || integrantes <= 0) {
            throw new DatosInsuficientesException("Todos los datos del equipo son obligatorios y válidos");
        }

        Equipo equipo = new Equipo(nombre, cedula, fechaNac, nacionalidad, integrantes);
        evento.registrarParticipante(equipo);
        System.out.println("Equipo registrado exitosamente!");
    }

    private static Evento seleccionarEvento() throws DatosInsuficientesException {
        if(olimpiadas.isEmpty()) {
            throw new DatosInsuficientesException("No hay olimpiadas registradas");
        }

        System.out.println("\nOlimpiadas disponibles:");
        for(int i = 0; i < olimpiadas.size(); i++) {
            System.out.println(i + ". " + olimpiadas.get(i).getNombreOlimpiada());
        }

        System.out.print("Seleccione olimpiada: ");
        int indiceOlimpiada = scanner.nextInt();
        scanner.nextLine();

        Olimpiada olimpiada = olimpiadas.get(indiceOlimpiada);

        if(olimpiada.getEventos().isEmpty()) {
            throw new DatosInsuficientesException("Esta olimpiada no tiene eventos");
        }

        System.out.println("\nEventos disponibles:");
        for(int i = 0; i < olimpiada.getEventos().size(); i++) {
            System.out.println(i + ". " + olimpiada.getEventos().get(i).getNombreEvento());
        }

        System.out.print("Seleccione evento: ");
        int indiceEvento = scanner.nextInt();
        scanner.nextLine();

        return olimpiada.getEventos().get(indiceEvento);
    }

    private static void consultarInformacion() {
        if(olimpiadas.isEmpty()) {
            System.out.println("No hay información registrada");
            return;
        }

        System.out.println("\n=== INFORMACIÓN DE OLIMPIADAS ===");
        for(Olimpiada o : olimpiadas) {
            System.out.println("\nOlimpiada: " + o.getNombreOlimpiada() + " (" + o.getAnio() + ")");

            for(Evento e : o.getEventos()) {
                System.out.println("  Evento: " + e.getNombreEvento() + " - Fecha: " + e.getFecha());
                System.out.println("  Participantes:");

                // 5. Polimorfismo
                for(Participante p : e.getParticipantes()) {
                    System.out.println("    - " + p.obtenerTipo());
                }
            }
        }
    }
}