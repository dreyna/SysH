package com.example.sysh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sysh.entity.Usuario;
import com.example.sysh.retrofit.APIUtils;
import com.example.sysh.retrofit.ApiUsuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Login extends AppCompatActivity {
    private EditText edt1, edt2;
    private Button btn1;
    private ApiUsuario apiUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        apiUsuario = APIUtils.getusuarioService();
        edt1 =(EditText)findViewById(R.id.edtuser);
        edt2 =(EditText)findViewById(R.id.edtpassword);
        btn1 = (Button) findViewById(R.id.btnlogin);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
              }
        });
    }
    private void loginUser() {
        String username, password;
        username = edt1.getText().toString().trim();
        password = edt2.getText().toString().trim();
        Call<Usuario> call = apiUsuario.validarUsuario(new Usuario(0,0,username,password));
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Usuario user1 = response.body();
                if(user1!=null) {
                     parseLoginData(user1);
                }else{
                    Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Log.e("Error:",t.toString());
            }
        });
    }
    private void parseLoginData(Usuario user){
        try {
                Toast.makeText(Login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this,PrincipalActivity.class);
                startActivity(intent);
                this.finish();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
