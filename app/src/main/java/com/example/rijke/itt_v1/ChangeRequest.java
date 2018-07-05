package com.example.rijke.itt_v1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ChangeRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://smartdrive.000webhostapp.com/Change_Data_Alle.php";
    private Map<String, String> params;

    public ChangeRequest(int IDreisender, String Vorname,String Nachname,String Geburtsdatum,String EMail,String Geburtsort,String Handynummer,String Personalausweisnummer,String Passwort, Response.Listener<String> ResponseListener){
        super(Method.POST, REGISTER_REQUEST_URL, ResponseListener, null);
        params=new HashMap<>();
        params.put("IDreisender", IDreisender + "");
        params.put("Vorname", Vorname);
        params.put("Nachname", Nachname);
        params.put("Geburtsdatum", Geburtsdatum);
        params.put("Geburtsort", Geburtsort);
        params.put("EMail", EMail);
        params.put("Handynummer", Handynummer);
        params.put("Personalausweisnummer", Personalausweisnummer);
        params.put("Passwort", Passwort);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}





