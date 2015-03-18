package com.universidadcauca.movil.viewseleccionables;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.universidadcauca.movil.viewseleccionables.adpters.GameAdapter;
import com.universidadcauca.movil.viewseleccionables.models.Game;

import java.util.ArrayList;
import java.util.List;


public class GameActivity extends ActionBarActivity implements DialogInterface.OnClickListener{

    ListView list;
    String games[];

    GameAdapter adapter;
    List<Game> data;

    AlertDialog alert;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        list = (ListView) findViewById(R.id.list);
        data = new ArrayList<Game>();

        adapter = new GameAdapter(this, data);

        list.setAdapter(adapter);

        games = getResources().getStringArray(R.array.games);
        loadGames();

        registerForContextMenu(list);

        alert = new AlertDialog.Builder(this)
                .setTitle("Alerta")
                .setMessage("Desea eliminar el Juego?")
                .setPositiveButton("Aceptar", this)
                .setNegativeButton("Cancelar", this)
                .create();

    }

    public void loadGames(){

        for(int i=0;i<games.length;i++){
            String info[] = games[i].split(",");

            Game g = new Game(info[2], info[1], info[0]);
            data.add(g);

        }

        adapter.notifyDataSetChanged();
    }

    //Metodos para Menu de Opciones

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_game, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.action_add:
                Toast.makeText(this, "Agregar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_more :
                Toast.makeText(this, "More", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_info:
                Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    //Metodos para menu contextual


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(v==list)
            getMenuInflater().inflate(R.menu.menu_game_ctx,menu);

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)
                item.getMenuInfo();

        pos = info.position;

        switch(item.getItemId()){

            case R.id.action_delete:
                //data.remove(pos);
                //adapter.notifyDataSetChanged();
                alert.show();
                break;
            case R.id.action_edit:break;

        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        if(which == DialogInterface.BUTTON_POSITIVE){

            data.remove(pos);
            adapter.notifyDataSetChanged();
        }

    }
}
