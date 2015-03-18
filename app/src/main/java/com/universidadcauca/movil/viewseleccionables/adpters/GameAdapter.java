package com.universidadcauca.movil.viewseleccionables.adpters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.universidadcauca.movil.viewseleccionables.R;
import com.universidadcauca.movil.viewseleccionables.models.Game;

import java.util.List;

/**
 * Created by DarioFernando on 11/03/2015.
 */
public class GameAdapter extends BaseAdapter{

    Context context;
    List<Game> data;



    public GameAdapter(Context context, List<Game> data){

        this.context = context;
        this.data = data;

    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;

        if(convertView == null)
            v = View.inflate(context, R.layout.template_game, null);
        else
            v = convertView;

        Game g = (Game) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.titulo);
        txt.setText(g.getTitulo());

        txt = (TextView) v.findViewById(R.id.genero);
        txt.setText(g.getGenero());

        txt = (TextView) v.findViewById(R.id.edad);
        txt.setText(g.getEdad());

        return v;
    }
}
