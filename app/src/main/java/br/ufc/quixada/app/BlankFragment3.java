package br.ufc.quixada.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment3 extends Fragment {
    List<Model> listaUsuario;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank3, container, false);

        initData(v);
        initRecycler(v);

        return v;
    }

    public void initRecycler(View v) {
        RecyclerView recyclerView = v.findViewById(R.id.recyclerid);
        LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        AdapterRecycle adapter = new AdapterRecycle(listaUsuario);
        recyclerView.setAdapter(adapter);



    }

    private void initData(View v) {
        listaUsuario = new ArrayList<>();

        listaUsuario.add(new Model(R.drawable.orange, "Laranja", "Isso é uma Laranja."));
        listaUsuario.add(new Model(R.drawable.strawberry, "Morango", "Isso é um Morango."));
        listaUsuario.add(new Model(R.drawable.coffee, "Café", "Isso é um café."));
        listaUsuario.add(new Model(R.drawable.orange, "Laranja", "Isso é uma Laranja."));
        listaUsuario.add(new Model(R.drawable.strawberry, "Morango", "Isso é um Morango."));
        listaUsuario.add(new Model(R.drawable.coffee, "Café", "Isso é um café."));
        listaUsuario.add(new Model(R.drawable.orange, "Laranja", "Isso é uma Laranja."));
        listaUsuario.add(new Model(R.drawable.strawberry, "Morango", "Isso é um Morango."));
        listaUsuario.add(new Model(R.drawable.coffee, "Café", "Isso é um café."));



    }
}