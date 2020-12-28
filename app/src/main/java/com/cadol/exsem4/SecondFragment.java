package com.cadol.exsem4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private GridView gridView;
    private GridAdapter adapter;
    private Context context;
    private Context mcontext;
    ArrayList<String> arraylist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_second , container, false);

        gridView = (GridView) view.findViewById(R.id.am_gv_gridview);
        adapter = new GridAdapter(mcontext, arraylist);
        gridView.setAdapter(adapter);

        inicializarLista();

        return view;
    }

    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        return;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mcontext = context;
    }

    public void inicializarLista() {

        arraylist.add("10");
        arraylist.add("5");
        arraylist.add("25");
        arraylist.add("200");
        arraylist.add("16");
        arraylist.add("4");
        arraylist.add("33");
        arraylist.add("31");
        arraylist.add("15");
        arraylist.add("69");

    }
}


