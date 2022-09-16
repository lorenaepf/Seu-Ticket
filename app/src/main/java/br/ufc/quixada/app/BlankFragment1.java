package br.ufc.quixada.app;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BlankFragment1 extends Fragment implements AdapterView.OnItemSelectedListener {
    private static final String[] COUNTRIES = new String[] {"China","Estados Unidos", "Colombia", "Brasil","Belgica"}; //autocomplete
    ToggleButton toggleButton2; //toggle variables
    Button btnDisplay;
    EditText eText; // edit text
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank1, container, false);
        addListenerOnButton(v);
        createEdit(v);
        createAutocomplete(v);
        createSpinner(v);


        return v;


    }
    //autocomplete
    public void createAutocomplete(View v){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = v.findViewById(R.id.actv);
        textView.setAdapter(adapter);

    }
    //autocomplete

    //edit text
    public void createEdit(View v){
        eText = v.findViewById(R.id.edtText);
        btn = v.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Nome adicionado", Toast.LENGTH_SHORT).show();
            }

        });
    }
    //edit text

    //toggle button
    public void addListenerOnButton(View v) {


        toggleButton2 = v.findViewById(R.id.toggleButton2);
        btnDisplay = v.findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append("Toggle Button: ").append(toggleButton2.getText());

                Toast.makeText(getActivity(), result.toString(), Toast.LENGTH_LONG).show();

            }

        });

    }
    //toggle button
    //Option Menu
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //inflate menu
        inflater.inflate(R.menu.exemplemenu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    //Option Menu

    //Spinner
    public void createSpinner(View v){
        Spinner spinner = v.findViewById(R.id.s1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.Países, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),"País selecionado: " + text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    //Spinner


}