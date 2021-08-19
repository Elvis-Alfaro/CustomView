package com.example.customviews.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customview_library.busqueda_list.base.BaseCustomAdapter;
import com.example.customviews.R;
import com.example.customviews.model.ItemList;

import java.util.List;

public class AdapterGeneric extends BaseCustomAdapter<AdapterGeneric.ViewHolderList, ItemList> {

    public AdapterGeneric(List list) {
        super(list);
    }

    @Override
    public ViewHolderList onCreateCustomViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new ViewHolderList(view);
    }

    @Override
    public void onBindCustomViewHolder(@NonNull ViewHolderList holder, int position) {
        holder.bind(listFiltered.get(position));
    }

    @Override
    public void searchInList(String search) {
        listFiltered.clear();
        for (ItemList item :
                listComplete) {
            if (item.getTitle().toLowerCase().contains(search.toLowerCase())) {
                listFiltered.add(item);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public void onItemClickListener(ItemList item) {
        Toast.makeText(context, "Item: \ntitulo: "+item.getTitle() + "\nDescripcion: "+item.getDescription(), Toast.LENGTH_SHORT).show();
    }


    class ViewHolderList extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvDescription;

        public ViewHolderList(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }

        public void bind(ItemList itemList) {
            tvTitle.setText(itemList.getTitle());
            tvDescription.setText(itemList.getDescription());
        }
    }
}
