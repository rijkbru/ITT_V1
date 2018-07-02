package com.example.rijke.itt_v1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ChangeRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://smartdrive.000webhostapp.com/Change_Data_Alle.php";
    private Map<String, String> params;

    public ChangeRequest(String Vorname,String Nachname,String Geburtsdatum,String EMail, Response.Listener<String> ResponseListener){
        super(Method.POST, REGISTER_REQUEST_URL, ResponseListener, null);
        params=new HashMap<>();
        params.put("Vorname", Vorname);
        params.put("Nachname", Nachname);
        params.put("Geburtsdatum", Geburtsdatum);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}





