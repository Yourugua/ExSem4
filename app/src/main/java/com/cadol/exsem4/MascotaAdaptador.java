package com.cadol.exsem4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascota;
    Activity activity;

    // Metodo constructor
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascota = mascotas;
        this.activity= activity;
    }

    // infla el layout y lo pasar al viewholder para que obtenga los views
    @NonNull
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada View
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final  Mascota mascotas = mascota.get(position);
        MascotaViewHolder.imgFoto.setImageResource(mascotas.getFoto());
        MascotaViewHolder.tvNombreCV.setText(mascotas.getNombre());
        MascotaViewHolder.tvLikeCV.setText(mascotas.getLikes());

        MascotaViewHolder.btnLike.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste LIKE a: " + mascotas.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        public static ImageView imgFoto;
        private static TextView tvNombreCV;
        private static TextView tvLikeCV;
        private static AppCompatImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV =  (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikeCV = (TextView) itemView.findViewById(R.id.tvLikeCV);
            btnLike = (AppCompatImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}