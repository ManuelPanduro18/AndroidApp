package com.manuel.lab_c4.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manuel.lab_c4.R;
import com.manuel.lab_c4.models.Solicitud;
import com.manuel.lab_c4.service.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SolicitudesAdapter extends RecyclerView.Adapter<SolicitudesAdapter.ViewHolder> {

    private List<Solicitud>solicitudes;

    public SolicitudesAdapter(){
        this.solicitudes=new ArrayList<>();
    }

    public void setSolicitudes(List<Solicitud>solicitudes){
        this.solicitudes=solicitudes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView fotoImage;
        public TextView tituloText;
        public TextView correoText;
        public TextView descripcionText;

        public ViewHolder(View itemView){
            super(itemView);

            fotoImage=itemView.findViewById(R.id.foto_image);
            tituloText=itemView.findViewById(R.id.titulo_text);
            correoText=itemView.findViewById(R.id.correo_text);
            descripcionText=itemView.findViewById(R.id.descripcion_text);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solicitud, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Solicitud solicitud = this.solicitudes.get(position);

        viewHolder.tituloText.setText(solicitud.getTipo());
        viewHolder.correoText.setText(solicitud.getCorreo());
        viewHolder.descripcionText.setText(solicitud.getDescripcion());

        String url = ApiService.API_BASE_URL + "/solicitudes/images/" + solicitud.getImagen();
        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.solicitudes.size();
    }




}
