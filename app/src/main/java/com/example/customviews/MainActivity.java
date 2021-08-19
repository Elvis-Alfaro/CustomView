package com.example.customviews;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customview_library.busqueda_list.custom_view.CustomSearchList;
import com.example.customviews.adapter.AdapterGeneric;
import com.example.customviews.model.ItemList;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomSearchList cslLista;
    //private AdapterList adapterList;
    private AdapterGeneric adapterGeneric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cslLista = findViewById(R.id.csl_lista);
        initViews();
    }

    private void initViews() {
        //adapterList = new AdapterList(getList());
        //cslLista.setAdapterList(adapterList);
        adapterGeneric = new AdapterGeneric(getList());
        cslLista.setAdapterList(adapterGeneric);
    }

    private List<ItemList> getList() {
        List<ItemList> list = new ArrayList<>();
        for (int i=0; i<5; i++)
            list.add(new ItemList("titulo "+i, "Description "+i));
        return list;
    }

    public void agregar(View view) {
        adapterGeneric.addItem(new ItemList("Nuevo", "Descripcion"));
    }
}