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

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
                //loginUser();
                Intent intent = new Intent(Login.this,PrincipalActivity.class);
                startActivity(intent);
              }
        });
    }
    private void loginUser() {
        //Toast.makeText(getApplicationContext(),"hola",Toast.LENGTH_SHORT).show();
        Usuario user = new Usuario(0,0,edt1.getText().toString(), edt2.getText().toString());

        Call<Usuario> call = apiUsuario.validarUsuario(user);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.code() == 200)
                    Toast.makeText(getApplicationContext(),"Si",Toast.LENGTH_SHORT).show();
                /*
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Toast.makeText(getApplicationContext(),"david: ",Toast.LENGTH_SHORT).show();
                        Log.i("onSuccess", response.body().toString());
                        String jsonresponse = response.body().toString();
                        parseLoginData(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"hola"+edt1.getText().toString(),Toast.LENGTH_SHORT).show();
                }*/
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error: "+edt1.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void parseLoginData(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {
                //saveInfo(response);
                Toast.makeText(Login.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this,PrincipalActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                this.finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
