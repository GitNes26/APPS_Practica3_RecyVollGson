package com.nestor.practicarecyvollgson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // primera parte...
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        //despues crear el diseño
        //despues crear la clase
        //despues crear el adaptador

        //y creamos nuestra lista de (en este caso) vacas
        List<Vaca> ListaVacas = new ArrayList<>();
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 1","Me gusta comer pasto x1"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 2","Me gusta comer pasto x2"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 3","Me gusta comer pasto x3"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 4","Me gusta comer pasto x4"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 5","Me gusta comer pasto x5"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 6","Me gusta comer pasto x6"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 7","Me gusta comer pasto x7"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 8","Me gusta comer pasto x8"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 9","Me gusta comer pasto x9"));
        ListaVacas.add(new Vaca(R.drawable.vaca,"Vaca 10","Me gusta comer pasto x10"));

        // creamos un adaptador y le pasamos la lista de vacas que hemos llenado manualmente
        AdaptadorVaca corral = new AdaptadorVaca(ListaVacas);
        // pasamos el adaptador con informacion al recylcerView
        recyclerView.setAdapter(corral);

        corral.notifyDataSetChanged();

    }
}