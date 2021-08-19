package com.example.customview_library.busqueda_list.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customview_library.R;
import com.example.customview_library.busqueda_list.base.BaseCustomAdapter;

public class CustomSearchList extends LinearLayout {
    private EditText etSearch;
    private RecyclerView rvList;

    private BaseCustomAdapter adapterList;

    private int digitsStartSearch;

    public CustomSearchList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0, android.R.style.Theme_Translucent_NoTitleBar);

        View view = LayoutInflater.from(context).inflate(R.layout.custom_search_list_view, this, true);
        etSearch = view.findViewById(R.id.et_search);
        rvList = view.findViewById(R.id.rv_list);

        setOrientation(VERTICAL);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomSearchList);
        validateAttrs(typedArray);
    }

    private void validateAttrs(TypedArray typedArray) {
        digitsStartSearch = typedArray.getInteger(R.styleable.CustomSearchList_num_digits_start_search, 0);
    }

    public void setAdapterList(BaseCustomAdapter adapterList) {
        this.adapterList = adapterList;
        rvList.setAdapter(adapterList);
        initListener();
    }
    private void initListener() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search(s.toString());
            }
        });
    }

    private void search(String input) {
        String textoBusqueda = input.trim();
        if (textoBusqueda.length() >= digitsStartSearch) {
            adapterList.searchInList(textoBusqueda);
        } else {
            adapterList.searchInList("");
        }
    }
}
