package com.lucas.guiadeviagem;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class FirebaseApi {
    private static final String TABELA_NOME = "/guiadeviagem";
    private final Activity activity;
    private ListView listaDestino;
    private ArrayAdapter<Destino> adapter;
    private List<Destino> destino;

    public FirebaseApi(Activity activity, ListView listaDestino, ArrayAdapter<Destino> adapter) {
        this.activity = activity;
        this.listaDestino = listaDestino;
        this.adapter = adapter;
    }

    public FirebaseApi(Activity activity) {
        this.activity = activity;
    }

    public Destino getDestino(int posicao) {
        return destino.get(posicao);
    }

    public void buscaTarefa() {
        destino = new ArrayList<>();

        FirebaseFirestore.getInstance().collection(TABELA_NOME).addSnapshotListener((value, error) -> {
            List<DocumentChange> dc = value.getDocumentChanges();
            for (DocumentChange doc: dc) {
                if (doc.getType() == DocumentChange.Type.ADDED) {
                    Destino d = doc.getDocument().toObject(Destino.class);
                    destino.add(d);
                }
            }
            adapter = new ArrayAdapter<>(
                    activity.getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    destino
            );
            listaDestino.setAdapter(adapter);
        });
    }
}
