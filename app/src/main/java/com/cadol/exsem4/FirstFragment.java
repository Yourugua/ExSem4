package com.cadol.exsem4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_first, container, false);

        listaMascotas = v.findViewById(R.id.rvMascota);

        LinearLayoutManager llm = new LinearLayoutManager( getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascota();
        inicializaAdaptador();

        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public void inicializaAdaptador() {
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);

    }

    public void inicializarListaMascota() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add( new Mascota( R.drawable.bianca,"Bianca", "5"));
        mascotas.add( new Mascota( R.drawable.chocolate,"Chocolate","6"));
        mascotas.add( new Mascota( R.drawable.lola,"Lola", "4"));
        mascotas.add( new Mascota( R.drawable.rayo, "Rayo", "9"));
    }
}
