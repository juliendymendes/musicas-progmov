package com.me.trab1_progmov;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adaptador extends BaseAdapter {
    private final Context context;
    private final int[] lista;

    public Adaptador(Context context, int[] lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int i) {
        return lista[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView iv = new ImageView(context);
        iv.setImageResource(lista[i]);
        iv.setLayoutParams(new ViewGroup.LayoutParams(240,240));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(4,4,4,4);
        return iv;
    }
}
