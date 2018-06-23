package com.example.rijke.itt_v1;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://smartdrive.000webhostapp.com/Login_Data.php";
    private Map<String, String> params;

    public LoginRequest(String EMail, String Passwort, Response.Listener<String> ResponseListener){
        super(Method.POST, LOGIN_REQUEST_URL, ResponseListener, null);
        params=new HashMap<>();
        params.put("EMail", EMail);
        params.put("Passwort", Passwort);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
