package com.lucas.guiadeviagem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private ListView listaDestinos;
    private ArrayAdapter<Destino> adapter;
    private FirebaseApi firebaseApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        listaDestinos = findViewById(R.id.listaDestinos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        firebaseApi = new FirebaseApi(this, listaDestinos, adapter);
        firebaseApi.buscaTarefa();
        configurarClicks();
    }

    private void configurarClicks() {
        listaDestinos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Destino t = firebaseApi.getDestino(position);
                verDetalhes(t);
            }
        });
    }

    private void verDetalhes(Destino destino) {
        String atracoes = String.format("Atracoes: %s", destino.getAtracoes());
        String hoteis = String.format("Hoteis: %s", destino.getHoteis());
        String lazer = String.format("Lazer: %s", destino.getLazer());
        String restaurantes = String.format("Restaurantes: %s", destino.getRestaurantes());
        String viagem = String.format("%s", destino.getViagem());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(viagem);
        builder.setMessage(hoteis + "\n" + atracoes + "\n" + lazer + "\n" + restaurantes);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}