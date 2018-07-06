package com.example.rijke.itt_v1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
public class DatenRequest extends  StringRequest {

    //Aufruf der benötigten php-Datei auf dem Server
    private static final String Daten_REQUEST_URL = "https://smartdrive.000webhostapp.com/Data_Request.php";
    private Map<String, String> params;


    public DatenRequest(int IDreisender, Response.Listener<String> ResponseListener) {

        //Weitergabe der relevanten Parameter an die php-Datei
        super(Method.POST, Daten_REQUEST_URL, ResponseListener, null);
        params = new HashMap<>();
        params.put("IDreisender", IDreisender + "");



    }

    //Abspeichern der zurückgegebenen Variablen
    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
