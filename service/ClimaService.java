package service;

import com.google.gson.*;
import model.Clima;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.format.DateTimeFormatter;

public class ClimaService {
    private static final String API_KEY = "d32427b391d4d8c0a57c54e9ddfc6fc5";
    private static final String BASE_URL ="http://api.openweathermap.org/data/2.5/weather";


    public static void busquedaDatosPorCiudad(String ciudad) throws IOException, InterruptedException {
        // Reemplaza los espacios en el nombre de la ciudad para que se pueda usar en la URL correctamente
        ciudad = ciudad.replace(" ", "+");
        String direccion = BASE_URL + String.format("?q=%s&appid=%s&units=metric&lang=es", ciudad, API_KEY);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        String nombreCiudad = jsonObject.get("name").getAsString();
        double temperaturaActual = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
        double sensacionTermica = jsonObject.getAsJsonObject("main").get("feels_like").getAsDouble();
        double temperaturaMinima = jsonObject.getAsJsonObject("main").get("temp_min").getAsDouble();
        double temperaturaMaxima = jsonObject.getAsJsonObject("main").get("temp_max").getAsDouble();
        String descripcion = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();

        Clima respuestaInformacion = new Clima(nombreCiudad, temperaturaActual, sensacionTermica, temperaturaMinima, temperaturaMaxima, descripcion);
        presentarReporte(respuestaInformacion);
    }
    public static void presentarReporte(Clima reporte) {
        DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");

        String reporteEnTexto = "--------------------------\n" +
                "Reporte del Clima: \n" +
                "Ciudad: " + reporte.getNombre() + "\n" +
                "Fecha: " + reporte.getFechaDeSolicitud().format(formatterDay) + "\n" +
                "Horario: " + reporte.getFechaDeSolicitud().format(formatterHour) + "\n" +
                "\n" +
                "Temperatura actual: " + reporte.getTemperaturaActual() + "\n" +
                "Sensación Térmica: " + reporte.getSensacionTermica() + "\n" +
                "Descripcion: " + reporte.getDescripcion() + "\n" +
                "\n" +
                "Temperatura mínima: " + reporte.getTemperaturaMinima() + "\n" +
                "Temperatura máxima: " + reporte.getTemperaturaMaxima() + "\n" +
                "--------------------------";
        System.out.println(reporteEnTexto);
    }

}
