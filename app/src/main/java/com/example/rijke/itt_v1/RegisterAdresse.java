package com.example.rijke.itt_v1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterAdresse extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://smartdrive.000webhostapp.com/Register_Adresse.php";
    private Map<String, String> params;

    public RegisterAdresse(String Strasse,String Hausnummer,Integer PLZ,String Ort,String Land, Response.Listener<String> ResponseListener){
        super(Method.POST, REGISTER_REQUEST_URL, ResponseListener, null);
        params=new HashMap<>();
        params.put("Strasse", Strasse);
        params.put("Hausnummer", Hausnummer);
        params.put("PLZ", PLZ+ "");
        params.put("Ort", Ort);
        params.put("Land", Land);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
