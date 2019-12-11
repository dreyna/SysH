package com.example.sysh;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sysh.adapter.AdapterAula;
import com.example.sysh.entity.Aula;
import com.example.sysh.listener.OnDeleteClickListener;
import com.example.sysh.listener.OnUpdateClickListener;
import com.example.sysh.retrofit.APIUtils;
import com.example.sysh.retrofit.JsonApi;
import com.example.sysh.retrofit.Urls;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AulaActivity extends AppCompatActivity implements Urls, OnUpdateClickListener, OnDeleteClickListener {
    private RecyclerView recyclerView;
    private AdapterAula adapter;
    private JsonApi jsonApi;
    private List<Aula> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula);
        jsonApi = APIUtils.getAulaService();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerid);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AulaActivity.this));
        lista = new ArrayList<>();
        listarAula();

    }

    private void listarAula() {
        Toast.makeText(this,"hola",Toast.LENGTH_LONG).show();
        Call<List<Aula>> call = jsonApi.getAula();
        call.enqueue(new Callback<List<Aula>>() {
            @Override
            public void onResponse(Call<List<Aula>> call, Response<List<Aula>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<Aula> lista = response.body();
                adapter = new AdapterAula(lista, AulaActivity.this);
                recyclerView.setAdapter(adapter);
                initListener();
            }
            @Override
            public void onFailure(Call<List<Aula>> call, Throwable t) {

            }
        });
        }
    private void doDelete(final int position, int id) {
        Call<Aula> call = jsonApi.deleteAula(id);
        call.enqueue(new Callback<Aula>() {
            @Override
            public void onResponse(Call<Aula> call, Response<Aula> response) {
                if (response.code() == 200)
                    adapter.remove(position);
                listarAula();
            }
            @Override
            public void onFailure(Call<Aula> call, Throwable t) {
                Log.e(".errorDelete", t.toString());
            }
        });
    }
    @Override
    public void onDeleteClick(final int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Your title");
        alertDialog.setMessage("Desea eliminar...? ");
        alertDialog.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doDelete(position, adapter.getData(position).getIdaula());
            }
        });

        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }
    @Override
    public void onUpdateClick(final int position) {
        final Aula au = adapter.getData(position);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.modificar_aula, null);
        final EditText mID = (EditText) view.findViewById(R.id.edtid);
        final EditText mNombre= (EditText) view.findViewById(R.id.edtnombre);
        final EditText mCapacidad= (EditText) view.findViewById(R.id.edtcapacidad);
        final EditText mTipo= (EditText) view.findViewById(R.id.edttipo);
        Button btnModificar = (Button) view.findViewById(R.id.btnaceptar);
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
        mID.setText(au.getIdaula());
        mNombre.setText(au.getNombre());
        mCapacidad.setText(au.getCapacidad());
        mTipo.setText(au.getTipo());
        alertDialog.setView(view);

       final AlertDialog dialog = alertDialog.create();
        dialog.show();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aula a = new Aula(au.getIdaula(),
                        mNombre.getText().toString(),
                        mCapacidad.getText().toString(),
                        mTipo.getText().toString(),
                        dialog.dismiss();
                updateData(a);
                listarAula();
            }
        });
    }
    private void initListener() {
        adapter.setOnDeleteClickListener(this);
        adapter.setOnUpdateClickListener(this);
    }
    private void updateData(Aula au) {
        int id = au.getIdaula();
        Call<Aula> call = jsonApi.updateAula(id, au);

        call.enqueue(new Callback<Aula>() {
            @Override
            public void onResponse(Call<Aula> call, Response<Aula> response) {
                if (response.code() == 200) {
                    listarAula();
                }else{
                    Log.e(".mal", response.toString());
                }
            }
            @Override
            public void onFailure(Call<Aula> call, Throwable t) {
                Log.e(".error", t.toString());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                add();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
        private void add(){
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            View view = getLayoutInflater().inflate(R.layout.modificar_aula, null);
            final EditText mID = (EditText) view.findViewById(R.id.edtid);
            final EditText mNombre= (EditText) view.findViewById(R.id.edtnombre);
            final EditText mCapacidad= (EditText) view.findViewById(R.id.edtcapacidad);
            final EditText mTipo= (EditText) view.findViewById(R.id.edttipo);
            TextView mtitulo = (TextView) view.findViewById(R.id.textView);
            Button btnaceptar = (Button) view.findViewById(R.id.btnaceptar);
            Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
            mtitulo.setText("Registrar Alumno");
            alertDialog.setView(view);

            final AlertDialog dialog = alertDialog.create();
            dialog.show();
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                }
            });
            btnaceptar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Aula aula = new Aula(
                            0,mID.getText().toString(),
                            mNombre.getText().toString(),
                            mCapacidad.getText().toString(),
                            mTipo.getText().toString());
                    dialog.dismiss();
                    addAula(aula);
                }
            });
        }
        private void addAula(Aula au){
            Call<Aula> call = jsonApi.addAula(au);

            call.enqueue(new Callback<Aula>() {
                @Override
                public void onResponse(Call<Aula> call, Response<Aula> response) {
                    if(response.code() == 200) {
                        listarAula();
                        Toast.makeText(AulaActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<Aula> call, Throwable t) {
                    Log.e(".error", t.toString());
                }
            });
        }
    }
}

