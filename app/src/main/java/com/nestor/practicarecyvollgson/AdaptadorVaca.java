package com.nestor.practicarecyvollgson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorVaca extends RecyclerView.Adapter<AdaptadorVaca.MiHolder> {

    private List<Vaca> ListaVaca;

    public AdaptadorVaca(List<Vaca> listaVaca) {
        ListaVaca = listaVaca;
    }

    @NonNull
    @Override
    // este metodo del adaptador, busca el diseño que se creo anteriormente
    // lo infa y crea una vista y esa vista la pasa al constructor de "MiHolder"
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //crearemos una vista a partir de un XML → esto se le conoce como inflate (convertir de XML a vista)
        View vistaVaca = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MiHolder(vistaVaca);
        // al final del dia devuelve un tipo holder
    }

    @Override   //el onBindVieHolder junta el diseño y la informacion
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
    //me regresa (en este caso) a una Vaca  //holder, donde guarda el diseño    //posision, la posicion del elemento de la lista

        Vaca modelo = ListaVaca.get(position);
        holder.setData(modelo); // a travez del holder le paso la información de la vaca con setData
    }

    @Override
    public int getItemCount() {
        return ListaVaca.size();
    }

    // medio por el cual voy a interactuar con el dieseño ↓ saca los elementos
    public class MiHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView titulo;
        private TextView texto;

        public MiHolder(@NonNull View itemView) {
            super(itemView);

            // ligamos las variables creadas aqui con los elementos del diseño
            foto = itemView.findViewById(R.id.fotPerfil);
            titulo = itemView.findViewById(R.id.titulo);
            texto = itemView.findViewById(R.id.texto);
        }

        //
        private void setData(final Vaca v){
            foto.setImageResource(v.getFoto());
            titulo.setText(v.getTitulo());
            texto.setText(v.getTexto());
        }
    }
}
