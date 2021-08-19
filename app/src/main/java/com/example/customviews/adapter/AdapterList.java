package com.example.customviews.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customviews.R;
import com.example.customviews.model.ItemList;

import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolderList>{
    private List<ItemList> itemLists;

    public AdapterList(List<ItemList> itemLists) {
        this.itemLists = itemLists;
    }

    @NonNull
    @Override
    public ViewHolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new ViewHolderList(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderList holder, int position) {
        holder.bind(itemLists.get(position));
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
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
