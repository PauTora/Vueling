package com.example.vuelings;

public class Vuelo {
    private String departure;
    private String arrival;
    private String flight_number;
    private String date;
    private String time;
    private String gate;
    private String passenger_name;
    private String seat;
    private String ticket_type;

    // Getters adaptados al uso en el adapter y fragment
    public String getOrigen() { return departure; }
    public String getDestino() { return arrival; }
    public String getNumeroVuelo() { return flight_number; }
    public String getFecha() { return date; }
    public String getHora() { return time; }
    public String getPuerta() { return gate; }
    public String getNombrePasajero() { return passenger_name; }
    public String getAsiento() { return seat; }
    public String getTipoBillete() { return ticket_type; }
}
