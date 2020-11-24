package com.nestor.practicarecyvollgson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private VolleyS mVolleyS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        requestQueue = Volley.newRequestQueue(this);
//        Button btn = findViewById(R.id.btnJugadores);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                JSonMostrar();
//            }
//            private void JSonMostrar() {
//                String url = "http://www.ramiro174.com/api/obtener/numero";
////                JsonObjectRequest pedirJSono = new JsonObjectRequest(Request.Method.GET, url);
//            }
//        });

        Gson gson = new Gson();

        mVolleyS = VolleyS.getInstance(this.getApplicationContext());
        requestQueue = mVolleyS.getRequestQueue();
        findViewById(R.id.btnJugadores).setOnClickListener(this);


        // primera parte...
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        //despues crear el diseño
        //despues crear la clase
        //despues crear el adaptador

        List<Jugador> ListaJugadores = new ArrayList<>();
        ListaJugadores.add(new Jugador(R.drawable.gamer,"ID: ","Nombre: ","Numero: ","Creado: "));
        ListaJugadores.add(new Jugador(R.drawable.gamer,"ID: ","Nombre: ","Numero: ","Creado: "));

        AdaptadorJugador Jugadores = new AdaptadorJugador(ListaJugadores);
        recyclerView.setAdapter(Jugadores);

/*
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
*/
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnJugadores) {
            String url = "http://www.ramiro174.com/api/obtener/numero";

            JsonObjectRequest objetoJSon = new JsonObjectRequest(Request.Method.GET, url, null ,new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray arreglo = response.getJSONArray("resultados");
                        for (int i = 0; i < arreglo.length(); i++){
                            JSONObject resultado = arreglo.getJSONObject(i);
                            String id = resultado.getString("id");
                            String nombre = resultado.getString("nombre");
                            String numero = resultado.getString("numero");
                            String creado = resultado.getString("creado");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            requestQueue.add(objetoJSon);
        }
    }
}