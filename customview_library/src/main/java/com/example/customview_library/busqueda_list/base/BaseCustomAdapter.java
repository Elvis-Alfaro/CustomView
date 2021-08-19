package com.example.customview_library.busqueda_list.base;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCustomAdapter<VH extends ViewHolder, I> extends RecyclerView.Adapter<VH>  {
    protected List<I> listComplete, listFiltered;
    protected Context context;

    public BaseCustomAdapter(List<I> list) {
        this.listComplete = new ArrayList<>(list);
        this.listFiltered = new ArrayList<>(list);
    }

    public abstract VH onCreateCustomViewHolder(@NonNull ViewGroup parent, int viewType);

    public abstract void onBindCustomViewHolder(@NonNull VH holder, int position);

    public abstract void searchInList(String search);

    public abstract void onItemClickListener(I item);

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null)
            context = parent.getContext();
        return onCreateCustomViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        onBindCustomViewHolder(holder, position);
        holder.itemView.setOnClickListener( v -> {
            onItemClickListener(listFiltered.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return listFiltered.size();
    }

    public void addItem(I item) {
        if (item != null) {
            listFiltered.add(item);
            listComplete.add(item);
            notifyDataSetChanged();
        }
    }

    public void removeItem(int posicion) {
        if (!listFiltered.isEmpty()) {
            listFiltered.remove(posicion);
            listComplete.remove(listComplete.get(posicion));
            notifyDataSetChanged();
        }
    }
}
