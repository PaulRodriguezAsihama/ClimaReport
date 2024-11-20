import java.io.IOException;
import java.util.Scanner;

import static service.ClimaService.busquedaDatosPorCiudad;

public class ReporteClima {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        var respuesta = 0;
        while (respuesta != 7) {
            System.out.println(
                    "\nChallenge Reporte del Clima: \n" +
                            "*********************************************************\n" +
                            "Elija una ciudad para obtener el reporte meteorológico: \n" +
                            "1. La Paz  \n" +
                            "2. Buenos Aires \n" +
                            "3. Bogotá \n" +
                            "4. Washington \n" +
                            "5. Santa Cruz de la Sierra \n" +
                            "6. Presentar el reporte de otra ciudad \n" +
                            "7. Salir \n" +
                            "*************************************** \n"
            );

            System.out.println("Elija una opción escribiendo el número correspondiente: ");
            respuesta = Integer.parseInt(lectura.nextLine());

            switch (respuesta) {
                case 1 -> busquedaDatosPorCiudad("La Paz");
                case 2 -> busquedaDatosPorCiudad("Buenos Aires");
                case 3 -> busquedaDatosPorCiudad("Bogotá");
                case 4 -> busquedaDatosPorCiudad("Washington");
                case 5 -> busquedaDatosPorCiudad("Santa Cruz");
                case 6 -> {
                    //Nombre de la ciudad ingresado por el usuario
                    System.out.println("Escriba el nombre de una ciudad: ");
                    var busquedaCiudad = lectura.nextLine();
                    busquedaDatosPorCiudad(busquedaCiudad);
                }
                case 7 -> {
                    System.out.println("Saliendo del Reporte del Clima, hasta pronto...");
                    break;
                }
                default -> {
                    System.out.println("Opción no válida, inténtalo de nuevo.\n");
                }
            }
        }
    }
}

