package br.ufc.quixada.app;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class BlankFragment2 extends Fragment {
    MediaPlayer player;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank2, container, false);
        createRadioButton(v);
        createLongPress(v);
        createDropdown(v);
        createListView(v);
        pausar(v);
        tocar(v);
        parar(v);


        return v;
    }

    //Radio Button
    public void createRadioButton(View v){
        RadioGroup radioGroup = v.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.radioButton7:
                        break;
                    case R.id.radioButton6:
                        break;
                }
            }
        });
    }
    //Radio Button

    //Long press
    public void createLongPress(View v){
        TextView txtView = v.findViewById(R.id.txtViewLongPress);
        txtView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getActivity(), "Pressionado",Toast.LENGTH_LONG).show();
                return true;
            }
        });
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Pressione mais!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    //Long press

    //DropDown Menu
    public void createDropdown(View v){

        Button btnDrop = (Button) v.findViewById(R.id.btnDrop);
        btnDrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(getActivity(), btnDrop);
                popup.getMenuInflater().inflate(R.menu.item_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getActivity(), "Item clicado: " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup.show();
            }
        });

        }
    //DropDown Menu

    //ListView e ArrayAdapter
    public void createListView(View v){
        String itens[] = new String[] {"Maçã", "Acerola", "Caqui"};
        ListView list = v.findViewById(R.id.frutasid);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_dropdown_item_1line, itens);
        list.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        list.setOnItemClickListener(this::onItemSelected);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),"Fruta selecionada: " + text, Toast.LENGTH_SHORT).show();
    }
    //ListView e ArrayAdapter

    //Tocar um som


    public void tocar(View view){
        Button btnTocar = view.findViewById(R.id.tocarsom);
        btnTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player == null){
                    player = MediaPlayer.create(getActivity(), R.raw.sound);
                }
                player.start();
            }
        });
    }

    public void pausar(View view){
        Button btnPausar = view.findViewById(R.id.pausarsom);
        btnPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null){
                    player.pause();
                }
            }
        });
    }

    public void parar(View view){
        Button btnParar = view.findViewById(R.id.pararsom);
        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();
            }
        });

    }
    //Tocar um som

}




