package com.example.rijke.itt_v1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;



public class DatenRequest extends  StringRequest {

//    IP Adresse ändern, um php zu erreichen

    private static final String Daten_REQUEST_URL = "https://smartdrive.000webhostapp.com/Register_Request_test.php";
    private Map<String, String> params;

//    mit Datenbank abgleichen

    public DatenRequest(String Vorname, String Nachname, String Geburtsdatum, String Geburtsort, String Handynummer, String EMail , String Personalausweisnummer, String Passwort, Response.Listener<String> ResponseListener) {
        super(Method.POST, Daten_REQUEST_URL, ResponseListener, null);
        params = new HashMap<>();
        params.put("Vorname", Vorname);
        params.put("Nachname", Nachname);
        params.put("Geburtsdatum",Geburtsdatum);
        params.put("Geburtsort", Geburtsort);
        params.put("Handynummer", Handynummer);
        params.put("EMail", EMail);
        params.put("Perso", Personalausweisnummer);
        params.put("Passwort", Passwort);


    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
