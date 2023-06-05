package com.example.tripsfrontend.http;

import com.example.tripsfrontend.model.Train;
import com.example.tripsfrontend.model.Trip;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HttpRequestHandler {

    public final DateTimeFormatter localTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public final DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final Gson gson;

    public HttpRequestHandler() {
        gson = createGsonInstance();
    }

    public void addTrain(Train train) {
        try {
            URL url = new URI("http://localhost:8080/trains/").toURL();
            HttpURLConnection connection = openConnection(url, "POST");
            String jsonTrain = gson.toJson(train);
            sendJsonRequest(connection, jsonTrain);
            handleResponse(connection, train.getClass().getSimpleName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTrip(Trip trip) {
        try {
            URL url = new URI("http://localhost:8080/trips/").toURL();
            HttpURLConnection connection = openConnection(url, "POST");
            String jsonTrip = gson.toJson(trip);
            sendJsonRequest(connection, jsonTrip);
            handleResponse(connection, trip.getClass().getSimpleName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Trip> getAllTrips() {
        try {
            URL url = new URI("http://localhost:8080/trips").toURL();
            HttpURLConnection connection = openConnection(url, "GET");
            String jsonResponse = getJsonResponse(connection);
            return gson.fromJson(jsonResponse, new TypeToken<List<Trip>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public List<Train> getAllTrains() {
        try {
            URL url = new URI("http://localhost:8080/trains").toURL();
            HttpURLConnection connection = openConnection(url, "GET");
            String jsonResponse = getJsonResponse(connection);
            return gson.fromJson(jsonResponse, new TypeToken<List<Train>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    private HttpURLConnection openConnection(URL url, String method) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        return connection;
    }

    private void sendJsonRequest(HttpURLConnection connection, String json) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(json);
        writer.flush();
        writer.close();
    }

    private String getJsonResponse(HttpURLConnection connection) throws IOException {
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();
            return responseBuilder.toString();
        } else {
            System.out.println("Error response: " + connection.getResponseCode());
        }
        return "";
    }

    private void handleResponse(HttpURLConnection connection, String classSimpleName) {
        try {
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println(classSimpleName + " created successfully");
            } else {
                System.out.println("Error response: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Gson createGsonInstance() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalTime.class, new JsonSerializer<LocalTime>() {
                    @Override
                    public JsonElement serialize(LocalTime date, Type typeOfSrc, JsonSerializationContext context) {
                        return new JsonPrimitive(date.format(localTimeFormatter));
                    }
                })
                .registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
                    @Override
                    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
                        return new JsonPrimitive(date.format(localDateFormatter));
                    }
                })
                .registerTypeAdapter(LocalTime.class, new JsonDeserializer<LocalTime>() {
                    @Override
                    public LocalTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalTime.parse(json.getAsJsonPrimitive().getAsString(), localTimeFormatter);
                    }
                })
                .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                    @Override
                    public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalDate.parse(json.getAsJsonPrimitive().getAsString(), localDateFormatter);
                    }
                })
                .create();
    }
}
