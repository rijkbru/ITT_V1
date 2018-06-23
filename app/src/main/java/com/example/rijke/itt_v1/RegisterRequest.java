package com.example.rijke.itt_v1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://smartdrive.000webhostapp.com/Register_Data_Alle.php";
    private Map<String, String> params;

    public RegisterRequest(String Vorname,String Nachname,String Geburtsdatum,String Geburtsort,String Handynummer,String EMail,String Personalausweisnummer,String Passwort,String Strasse,String Hausnummer,Integer PLZ,String Ort,String Land,String Kontoinhaber,Integer Kartennummer,String Datum,Integer Ziffer, Response.Listener<String> ResponseListener){
        super(Method.POST, REGISTER_REQUEST_URL, ResponseListener, null);
        params=new HashMap<>();
        params.put("Vorname", Vorname);
        params.put("Nachname", Nachname);
        params.put("Geburtsdatum", Geburtsdatum);
        params.put("Geburtsort", Geburtsort);
        params.put("Handynummer", Handynummer);
        params.put("EMail", EMail);
        params.put("Personalausweisnummer", Personalausweisnummer);
        params.put("Passwort", Passwort);
        params.put("Strasse", Strasse);
        params.put("Hausnummer", Hausnummer);
        params.put("PLZ", PLZ + "");
        params.put("Ort", Ort);
        params.put("Land", Land);
        params.put("Kontoinhaber", Kontoinhaber);
        params.put("Kartennummer", Kartennummer + "");
        params.put("Datum", Datum);
        params.put("Ziffer", Ziffer + "");
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}

