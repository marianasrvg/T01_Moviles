package com.example.mari_.sesion5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mari_.sesion5.beans.Alumno;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    EditText telefono;
    Spinner escolaridad;
    RadioGroup genero;
    RadioButton femenino;
    RadioButton masculino;
    AutoCompleteTextView librofav;
    CheckBox deporte;
    Button limpiar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.activity_main_name);
        telefono = findViewById(R.id.activity_main_phone);
        escolaridad = findViewById(R.id.activity_main_spinner_escolaridad);
        genero = findViewById(R.id.activity_main_radiogroup_genero);
        femenino = findViewById(R.id.activity_main_femenino);
        masculino = findViewById(R.id.activity_main_masculino);
        librofav = findViewById(R.id.activity_main_textview_librofavorito);
        deporte = findViewById(R.id.activity_main_checkbox_practicadeporte);
        limpiar = findViewById(R.id.activity_main_btn_limpiar);

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
                telefono.setText("");
                escolaridad.setSelection(0);
                if(deporte.isChecked())
                    deporte.toggle();
                if(masculino.isSelected()){
                    femenino.setSelected(true);
                    masculino.setSelected(false);
                }
                librofav.setText("");
                nombre.requestFocus();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        boolean gender = false;

        if(genero.getCheckedRadioButtonId() == R.id.activity_main_femenino){
            gender = true;
        }

        Alumno alumno = new Alumno(
                nombre.getText().toString(),
                telefono.getText().toString(),
                escolaridad.getSelectedItem().toString(),
                gender,
                librofav.getText().toString(),
                deporte.isSelected());

        if(id==R.id.action_bar_btn_save){
            Toast.makeText(this, alumno.toString(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
